public class Parser {
    private String token = "";
    private miEscaner scanner;
    private boolean avanza = false;

    public Parser(String codigo) {
        scanner = new miEscaner(codigo);
        token = scanner.getToken(true);
        P();
    }

    public void comer(String tok) {
        if (this.token.equals(tok)) {
            this.token = scanner.getToken(true);
            this.avanza = true;
            System.out.println("Token: " + this.token);
        } else {
            this.avanza = false;
            error();
        }
    }

    public void intorstring(String tok) {
        switch (tok) {
            case "int":
                comer("int");
                break;
            case "string":
                comer("string");
                break;
            default:
                error();
                break;
        }
    }

    public void P() {
        D();
        S();
        System.exit(0);
    }

    public void D() {
        switch (token) {
            case "id":
                comer("id");
                id();
                intorstring(token);
                comer(";");
                D();
                break;
            case " ":
                break;
            default:
                error();
                break;
        }
    }

    public void S() {
        switch (token) {
            case "while":
                comer("while");
                E();
                comer("do");
                S();
                break;
            case "id":
                comer("id");
                comer("=");
                E();
                break;
            case "print":
                comer("print");
                E();
                break;
            default:
                error();
                break;
        }
    }

    // pendiente por ver
    public void E() {
        if (avanza) {
            comer("id");
            comer("+");
            comer("id");
        }
        comer("id");
    }

    public void id() {

    }

    public void error() {
        System.out.println("Error de sintaxis");
        System.exit(0);
    }
}

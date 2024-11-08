public class Parser {
    private String token = "";
    private String tipoToken = "";
    private miEscaner scanner;
    private Pair[] tablaSimbolos = {
            new Pair("id", 1),
            new Pair("int", 2),
            new Pair("string", 3),
            new Pair("while", 4),
            new Pair("do", 5),
            new Pair("print", 6),
            new Pair("+", 7),
            new Pair("=", 8),
            new Pair(";", 9)
    };

    public Parser(String codigo) {
        scanner = new miEscaner(codigo);
        token = scanner.getToken(true);
        P();
    }

    public void comer(String tok) {
        if (this.token.equals(tok)) {
            this.tipoToken = scanner.getTipoToken();
            this.token = scanner.getToken(true);
            System.out.println(scanner.getTipoToken());
        } else {
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

    public void error() {
        System.out.println("Error de sintaxis");
        System.exit(0);
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
                id(token);
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
        switch (token) {
            case "id":
                comer("id");
                break;
            case "+":
                comer("+");
                E();
                break;
            default:
                error();
                break;
        }
    }

}

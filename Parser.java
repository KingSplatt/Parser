
public class Parser {
    private String token;
    private miEscaner scanner;
    private boolean avanza = false;
    private boolean id = false;
    private final String M_id = "id",
            M_int = "int",
            M_string = "string",
            M_while = "while",
            M_do = "do",
            M_print = "print",
            M_puntoycoma = ";",
            M_operador = "+",
            M_igual = "=";

    public Parser(String codigo) {
        scanner = new miEscaner(codigo);
        avanzar();
    }

    public void avanzar() {
        this.token = scanner.getToken(true);
        if (id()) {
            this.token = "id";
            System.out.println("Token: " + this.token);
        } else {
            if (this.token.equals("EOF")) {
                System.exit(0);
            }
            System.out.println("Token: " + this.token);
        }
    }

    public void comer(String tok) {
        if (this.token.equals(tok)) {
            avanzar();
            this.avanza = true;
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
        if (this.token.equals(M_id)) {
            comer(M_id);
            intorstring(this.token);
            comer(";");
            D();
        } else {
            return;
        }
    }

    public void S() {
        switch (this.token) {
            case M_while:
                comer(M_while);
                E();
                comer("do");
                S();
                break;
            case M_id:
                comer(M_id);
                comer(M_igual);
                E();
                break;
            case M_print:
                comer(M_print);
                E();
                break;
            default:
                error();
                break;
        }
    }

    // pendiente por ver
    public void E() {
        if (id) {
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
        } else {
            throw new Error("Error de sintaxis se espera un id");
        }
    }

    public boolean id() {
        if (scanner.getTipoToken().equals("id")) {
            return true;
        }
        return false;
    }

    public void error() {
        System.out.println("Error de sintaxis");
        System.exit(0);
    }
}

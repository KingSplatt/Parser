import java.io.IOException;

public class Parser extends IOException {
    private String token;
    private miEscaner scanner;
    private final String M_id = "id",
            M_int = "int",
            M_string = "string",
            M_while = "while",
            M_do = "do",
            M_print = "print",
            M_operador = "+",
            M_igual = "=";

    public Parser(String codigo) throws Exception {
        try {
            if (codigo.equals("")) {
                throw new RuntimeException();
            }
            scanner = new miEscaner(codigo);
            avanzar();
        } catch (Exception e) {
            throw new RuntimeException("No se puede leer un archivo vacio");
        }
    }

    public void avanzar() {
        this.token = scanner.getToken(true);
        if (scanner.getTipoToken().equals("id")) {
            this.token = "id";
            System.out.println("Token: " + this.token);
        } else {
            System.out.println("Token: " + this.token);
        }
    }

    public void comer(String tok) {
        try {
            if (this.token.equals(tok)) {
                avanzar();
            } else {
                throw new Exception("error en " + tok);
            }

        } catch (Exception e) {
            System.err.println(e);

        }

    }

    public void intorstring(String tok) {
        try {
            if (this.token.equals(M_int)) {
                comer(M_int);
            } else if (this.token.equals(M_string)) {
                comer(M_string);
            } else {
                throw new Exception("Error se esperaba un tipo de dato");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void P() throws Exception {
        try {
            D();
            S();
            System.exit(0);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void D() {
        if (this.token.equals(M_id)) {
            comer(M_id);
            if (this.token.equals(M_igual)) {
                comer(M_igual);
                return;
            }
            intorstring(this.token);
            comer(";");
            D();
        } else {
            return;
        }

    }

    public void S() throws Exception {
        try {
            if (this.token.equals(M_while)) {
                comer(M_while);
                E();
                comer(M_do);
                S();
            } else if (this.token.equals(M_id)) {
                comer(M_id);
                if (this.token.equals("EOF")) {
                    return;
                }
                if (this.token.equals(M_operador)) {
                    comer(M_operador);
                    if (this.token.equals(M_id)) {
                        comer(M_id);
                        return;
                    } else {
                        throw new Exception("id");
                    }
                }
                comer(M_igual);
                E();
            } else if (this.token.equals(M_print)) {
                comer(M_print);
                E();
            } else {
                throw new Exception("Error se esperaba algo en S (while, id, print)");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void E() throws Exception {
        try {
            if (!this.token.equals(M_id)) {
                throw new Exception("Expresion");
            }
            if (this.token.equals(M_id)) {
                comer(M_id);
                if (this.token.equals(M_operador)) {
                    comer(M_operador);
                    if (this.token.equals(M_id)) {
                        comer(M_id);
                    } else {
                        throw new Exception("id");
                    }
                }
                if (this.token.equals(M_id)) {
                    throw new Exception("Operador");
                }
            }
        } catch (Exception e) {
            throw new Exception("Error se esperaba una " + e.getMessage());
        }
    }

    public void error() {
        System.out.println("Error de sintaxis");
        System.exit(0);
    }
}

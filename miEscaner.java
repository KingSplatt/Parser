public class miEscaner {
    private String tokens[];
    private final String reservadas[] = { "id", "int", "string", "while", "do", "print" };
    private final String operadores[] = { "+", "=" };
    private final String delimitador = ";";
    private int indice;
    private String tokenActual = "";
    private String tipoToken = "";

    public miEscaner(String codigo) {
        tokens = codigo.split("\\s+");
        indice = 0;
        tokenActual = tokens[indice];
    }

    public String getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(String tipo) {
        this.tipoToken = tipo;
    }

    public String getToken(boolean avanza) {
        boolean tokenValido = false;
        String token = tokens[indice];
        if (avanza) {
            indice++;
        }
        // Verificar si es una palabra reservada
        for (String reservada : reservadas) {
            if (token.equals(reservada)) {
                tokenValido = true;
                setTipoToken("Palabra reservada");
                break;
            }
        }
        // Verificar si es un operador
        if (!tokenValido) {
            for (String operador : operadores) {
                if (token.equals(operador)) {
                    tokenValido = true;
                    setTipoToken("Operador");
                    break;
                }
            }
        }
        // Verificar si es un delimitador
        if (!tokenValido) {
            if (token.equals(delimitador)) {
                tokenValido = true;
                setTipoToken("Delimitador");
            }
        }
        // Verificar si es un número
        if (!tokenValido) {
            try {
                Integer.parseInt(token);
                tokenValido = true;
            } catch (NumberFormatException e) {
                tokenValido = false;
            }
        }
        // Verificar si es un identificador
        if (!tokenValido) {
            if (Character.isLetter(token.charAt(0))) {
                tokenValido = true;
            }
        }

        if (tokenValido) {
            return token;

        } else {
            error(token);
            setTipoToken("Token invalido");
            return "Token invalido";
        }
    }

    public void error(String token) {
        System.out.println("Token no valido para: " + token);
    }
}

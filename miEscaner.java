public class miEscaner {
    private String tokens[];
    private final String reservadas[] = { "id", "int", "string", "while", "do", "print" };
    private final String operadores[] = { "+", "=" };
    private final String delimitador = ";";
    private int indice;
    private String tokenActual = "";
    private boolean isPalabraR = false, isOp = false, isDel = false, isNum = false, isId = false;

    public miEscaner(String codigo) {
        this.tokens = codigo.split("\\s+");
        this.indice = 0;
        this.tokenActual = tokens[indice];
    }

    public String getToken(boolean avanza) {
        boolean tokenValido = false;
        isPalabraR = false;
        isOp = false;
        isDel = false;
        isNum = false;
        isId = false;
        if (indice >= tokens.length) {
            return "Fin de archivo";
        }
        tokenActual = tokens[indice];
        if (avanza) {
            indice++;
        }
        // Verificar si es una palabra reservada
        for (String reservada : reservadas) {
            if (tokenActual.equals(reservada)) {
                tokenValido = true;
                isPalabraR = true;
                break;
            }
        }
        // Verificar si es un operador
        if (!tokenValido) {
            for (String operador : operadores) {
                if (tokenActual.equals(operador)) {
                    tokenValido = true;
                    isOp = true;
                    break;
                }
            }
        }
        // Verificar si es un delimitador
        if (!tokenValido) {
            if (tokenActual.equals(delimitador)) {
                tokenValido = true;
                isDel = true;
            }
        }
        // Verificar si es un número
        if (!tokenValido) {
            if (tokenActual.matches("[0-9]+")) {
                tokenValido = true;
                isNum = true;
            }
        }
        // Verificar si es un identificador
        if (!tokenValido) {
            if (tokenActual.matches("[a-z|A-Z][a-z|A-Z|0-9]*")) {
                tokenValido = true;
                isId = true;
            }
        }

        if (tokenValido) {
            return tokenActual;

        } else {
            error(tokenActual);
            return "Token invalido";
        }
    }

    public String getSigToken() {
        if (indice >= tokens.length) {
            return "Fin de archivo";
        }
        indice++;
        return tokens[indice];
    }

    public void error(String token) {
        System.out.println("Token no valido para: " + token);
    }

    public boolean getisPalabraR() {
        return isPalabraR;
    }

    public boolean getisOp() {
        return isOp;
    }

    public boolean getisDel() {
        return isDel;
    }

    public boolean getisNum() {
        return isNum;
    }

    public boolean getisId() {
        return isId;
    }
}

public class Compilador {

    public static void main(String[] args) {
        // String codigo = "a83 int ; b32 string ; while a3 do print b8";
        String codigo = "while a3 + b82 do print b8";
        Parser parser = new Parser(codigo);
        parser.P();
    }
}
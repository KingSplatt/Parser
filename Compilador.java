public class Compilador {

    public static void main(String[] args) {
        String codigo = "a83 int ; b32 string ; while a3 do b8 = a3 + b8";
        Parser parser = new Parser(codigo);
        parser.P();
    }
}
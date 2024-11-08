public class Compilador {

    public static void main(String[] args) {
        String codigo = "print 5 + 5";
        Parser parser = new Parser(codigo);
        parser.P();
    }
}
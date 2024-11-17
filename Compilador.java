public class Compilador {

    public static void main(String[] args) throws Exception {
        String codigo = "a83 int ; b32 string ; while a3 do print b8";
        // String codigo = "while a3 + b82 do print b8";
        // String codigo = "while a63 do print b8 + a43";
        // String codigo = "print a3 + b82 ; print b8 ;";
        // pendiente ver el de abajo
        // String codigo = "x1 int ; print t4 +";
        Parser parser = new Parser(codigo);
        parser.P();
    }
}
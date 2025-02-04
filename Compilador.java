
public class Compilador {

    public static void main(String[] args) throws Exception {

        // String codigo = "a83 int ; b32 string ; while a3 + a23 do while hola do while
        // pepe do print s + a84";
        // String codigo = "while a63 do while ba28 + a43 do print hola23 + a42";
        // String codigo = "while a3 + b82 do print b8 + a43";
        // String codigo = "while a63 do while ba28 + a43 do print hola23 + while";
        // String codigo = "print a3 + b82 ; print b8 ;";
        // String codigo = "";

        String codigo = "id = ha + as2";
        Parser parser = new Parser(codigo);
        parser.P();
    }
}
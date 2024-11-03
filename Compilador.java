public class Compilador {

    public static void main(String[] args) {
        String codigo = "print 5 + 5";
        miEscaner escaner = new miEscaner(codigo);
        System.out.println(escaner.getToken(true));
        System.out.println(escaner.getToken(true));
        System.out.println(escaner.getToken(true));
        System.out.println(escaner.getToken(true));

    }
}
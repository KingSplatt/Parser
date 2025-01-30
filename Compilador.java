import javax.swing.*;
import java.awt.*;

public class Compilador extends JPanel {
    public Compilador() {
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("Hola Mundo", 100, 100);
    }

    public static void main(String[] args) throws Exception {
        JFrame ventana = new JFrame("Compilador");
        Compilador compilador = new Compilador();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 300);
        ventana.add(compilador);
        ventana.setVisible(true);
        // String codigo = "a83 int ; b32 string ; while a3 + a23 do while hola do while
        // pepe do print s + a84";
        // String codigo = "while a63 do while ba28 + a43 do print hola23 + a42";
        // String codigo = "while a3 + b82 do print b8 + a43";
        // String codigo = "while a63 do while ba28 + a43 do print hola23 + while";
        // String codigo = "print a3 + b82 ; print b8 ;";
        // String codigo = "";

        // String codigo = "id = ha + as2";
        // Parser parser = new Parser(codigo);
        // parser.P();
    }
}
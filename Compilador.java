import javax.swing.*;
import java.awt.*;

public class Compilador extends JPanel {
    JFrame ventana;
    JPanel panelPrograma;

    public Compilador() {
        super();
        inicializarFrame();
    }

    public void inicializarFrame() {
        ventana = new JFrame("Compilador");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1200, 800);
        ventana.add(this);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout());
        agregarPanelPrograma();

        ventana.setVisible(true);
    }

    public void agregarPanelPrograma() {
        // panel
        panelPrograma = new JPanel();
        panelPrograma.setBounds(0, 0, 800, 800);
        panelPrograma.setBackground(new Color(255, 240, 237));
        ventana.add(panelPrograma, BorderLayout.CENTER);
        // texto
        JLabel label = new JLabel("Code here");
        label.setBounds(0, 0, 800, 50);
        ventana.add(label, BorderLayout.NORTH);
        // texto programa
        JTextArea textArea = new JTextArea();
        textArea.setBounds(150, 800, 800, 800);
        panelPrograma.add(textArea);
        // boton compilar
        JButton botonCompilar = new JButton("Compilar");
        botonCompilar.setBounds(800, 0, 200, 50);
        panelPrograma.add(botonCompilar);
    }

    public static void main(String[] args) throws Exception {
        Compilador compilador = new Compilador();
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
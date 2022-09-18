package Exemplos;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class ExemploJanela2 extends JDialog {

    public ExemploJanela2() {
        setSize(500, 400);
        setTitle("Esta é uma Classe Janela");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    
}

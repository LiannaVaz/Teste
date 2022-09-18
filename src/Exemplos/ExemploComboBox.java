package Exemplos;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExemploComboBox extends JFrame {

    public ExemploComboBox() {
        setSize(500, 400);
        setTitle("Exemplo de Combo-box");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        String[] direcoes = new String[5];
        
        direcoes[0] = "Norte";
        direcoes[1] = "Sul";
        direcoes[2] = "Leste";
        direcoes[3] = "Oeste";
        direcoes[4] = "Direção muito longínquoa para seguirmos!";

        JComboBox comboBox = new JComboBox(direcoes);
        JLabel label = new JLabel("Direção:");
               
        add(label);
        add(comboBox);

        setVisible(true);
    }

    public static void main(String[] args) {
        ExemploComboBox a = new ExemploComboBox();
    }
    
}

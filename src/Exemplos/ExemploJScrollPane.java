package Exemplos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;

public class ExemploJScrollPane extends JFrame {
    
    public ExemploJScrollPane() {
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exemplo JScrollPape");

        JScrollPane painel = new JScrollPane();
        
        painel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        painel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        JLabel texto2 = new JLabel("Texto numero dois");
        
        add(texto2, "North");
        
        painel.setVisible(true);
        add(painel);
        setVisible(true);

    }

    public static void main(String[] aasdasdasda) {
        ExemploJScrollPane exemplo = new ExemploJScrollPane();
    }

}

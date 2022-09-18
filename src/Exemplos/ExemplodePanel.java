package Exemplos;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ExemplodePanel {

    public static void main(String[] args) {
        
        JFrame janela = new JFrame();
        janela.setSize(500, 500);
        janela.setTitle("Exemplo de painel");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout(FlowLayout.TRAILING));

        JLabel l1 = new JLabel("Primeiro objeto");
        JLabel l2 = new JLabel("Segundo objeto");
        JButton botao = new JButton("Teste do construtor");

        Color c = new Color(255255255);

        botao.setBackground(c);
        
        painel.add(l1);
        painel.add(l2);
        painel.add(botao);
        janela.add(painel, "North");
        janela.setVisible(true);


    }

    public ExemplodePanel() {
    }


    
}

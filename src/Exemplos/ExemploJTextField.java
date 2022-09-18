package Exemplos;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;

public class ExemploJTextField {

    public static void main(String[] args) {
        
        JFrame janela = new JFrame();
        janela.setSize(500, 500);
        janela.setTitle("Exemplo de JTextField");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout(FlowLayout.LEFT));
        painel.setBackground(Color.yellow);
        JPanel painelEndereco = new JPanel();
        painelEndereco.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel l1 = new JLabel("Nome:");
        JTextField campoNome = new JTextField(30);
        campoNome.setEnabled(true);

        JLabel l2 = new JLabel("Endereço:");
        JTextField campoEndereco = new JTextField(30);
        campoEndereco.setEnabled(true);
        
        painel.add(l1);
        painel.add(campoNome);

        painelEndereco.add(l2);
        painelEndereco.add(campoEndereco);

        janela.add(painel, "North");
        janela.add(painelEndereco, "Center");
        janela.setVisible(true);


    }
    
}

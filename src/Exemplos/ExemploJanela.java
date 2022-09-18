package Exemplos;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class ExemploJanela {

    
    public static void main(String[] args) {

        JLabel norte = new JLabel("Norte");
        JLabel sul = new JLabel("Sul");
        JLabel leste = new JLabel("Leste");
        JLabel oeste = new JLabel("Oeste");
        
        JFrame janela = new JFrame();
        janela.setSize(500, 400);
        janela.setTitle("Primeira Janela Exemplo");
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.add(norte, "North");
        janela.add(sul, "South");
        janela.add(leste, "East");
        janela.add(oeste, "West");
        
        



        
    }



    
}

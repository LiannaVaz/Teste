package Exemplos;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Enums.BairrosEnum;



public class ExemploComboBairro extends JFrame {

    public ExemploComboBairro() {
        setSize(500, 400);
        setTitle("Exemplo de Combo-box de Bairro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JComboBox bairroComboBox = new JComboBox();

        bairroComboBox.addItem("Selecione o Bairro");

        for(BairrosEnum bairro:BairrosEnum.values()) {

            bairroComboBox.addItem(bairro.getDescricao());
        }
        

        JLabel label = new JLabel("Bairro:");
               
        add(label);
        add(bairroComboBox);

        setVisible(true);
    }

    public static void main(String[] args) {
        ExemploComboBairro a = new ExemploComboBairro();
    }    
    
}

package Exemplos;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Enums.BairrosEnum;

public abstract class ExemploJanelaAbstrata extends JFrame {

    public ExemploJanelaAbstrata() {
        setSize(500, 400);
        setTitle("Exemplo de janela Abstrata");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
    }

    public void mostraJanela() {
        setVisible(true);
    }

    public void montaTela() {
        JComboBox bairroComboBox = new JComboBox();
        bairroComboBox.addItem("Selecione o Bairro");
        for(BairrosEnum bairro:BairrosEnum.values()) {
            bairroComboBox.addItem(bairro.getDescricao());
        }
        JLabel label = new JLabel("Bairro:");
        add(label);
        add(bairroComboBox);
    }
}

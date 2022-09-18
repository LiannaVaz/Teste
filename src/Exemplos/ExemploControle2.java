package Exemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExemploControle2 implements ActionListener {

   private JFrame ObjetoJanela;
       

    public ExemploControle2(JFrame param) {
        this.ObjetoJanela = param;
    }

    public void actionPerformed(ActionEvent ae) {
        System.out.println("Executou um evento: " + ae.getActionCommand());
        if (ae.getActionCommand().equals("Adicionar")) {
            ExemploGridBagLayout a = new ExemploGridBagLayout();
        }
       
        if (ae.getActionCommand().equals("Remover")) {
            JOptionPane.showConfirmDialog(ObjetoJanela, "Confirma essa exclusão", "Exclusão", JOptionPane.YES_NO_CANCEL_OPTION);
        }

    }    
    
}

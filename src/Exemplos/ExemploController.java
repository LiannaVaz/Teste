package Exemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExemploController implements ActionListener {

   private JFrame ObjetoJanela;
       

    public ExemploController(JFrame param) {
        this.ObjetoJanela = param;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equalsIgnoreCase("Confirma")) {
            System.out.println("Apertou o botão Confirma");
            //JOptionPane.showMessageDialog(ObjetoJanela, "Você Clicou no botão Confirma!!");
            //JOptionPane.showMessageDialog(ObjetoJanela, "Você acabou com todo o sistema. Favor passar no RH!", 
            //"Erro Crítico e Brutal!", JOptionPane.ERROR_MESSAGE );
           /* Integer opcao = JOptionPane.showConfirmDialog(ObjetoJanela, "E ai confirma a detonação ?", "Confirmação", JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.QUESTION_MESSAGE );
            System.out.println("Opcao selecionada: " + opcao);*/

            String valor = JOptionPane.showInputDialog(ObjetoJanela, // Objeto da janela
                                                      "Entrada de dados", // Mensagem que aparece em cima do campo
                                                      "Entrada de dados", // Titulo da janela
                                                      JOptionPane.PLAIN_MESSAGE); // Tipo da mensagem 
            
            System.out.println("Valor informado: " + valor);
        }
        if (ae.getActionCommand().equalsIgnoreCase("Cancela")) {
            System.out.println("Apertou o botão Cancela");
            //JOptionPane.showMessageDialog(ObjetoJanela, "Botão Cancela pressionado!");
            JOptionPane.showMessageDialog(ObjetoJanela, "Sábia Decisão. Você poderia ter se metido em problemas", 
            "Atenção! Cuidado", JOptionPane.WARNING_MESSAGE );
        }
        System.out.println("Executou um evento: ");

    }    
    
}

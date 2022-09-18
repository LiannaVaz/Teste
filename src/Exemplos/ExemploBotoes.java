package Exemplos;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class ExemploBotoes extends ExemploJanelaAbstrata{

    public static void main(String[] args) {

        
        ExemploBotoes.setDefaultLookAndFeelDecorated(false);
        ExemploBotoes janela = new ExemploBotoes();
        
        JButton botaoConfirma = new JButton("Confirma");
        JButton botaoCancela = new JButton("Cancela");
        
        botaoConfirma.setBounds(5, 330, 89, 23);
        botaoCancela.setBounds(102, 330, 89, 23);
       
        janela.setTitle("Exemplo de Botões");
        janela.setLayout(null);
        janela.setSize(500, 400);
        janela.add(botaoConfirma);
        janela.add(botaoCancela);
        


        ExemploController controle = new ExemploController(janela);
        botaoConfirma.addActionListener(controle);
        botaoCancela.addActionListener(controle);
        botaoConfirma.setName("Confirma");
        botaoCancela.setName("Cancela");

        try {
           // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            
        } catch (Exception e) {
            
            e.printStackTrace();
        } 

        SwingUtilities.updateComponentTreeUI(janela);
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo look : looks) {
            System.out.println(look.getClassName());
        }
      

        
        janela.mostraJanela();
    }


    
}

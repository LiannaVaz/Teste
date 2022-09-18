package Exemplos;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

import Enums.BairrosEnum;

public class ExemploSemLayout extends JDialog {

    public ExemploSemLayout() {
        setSize(500, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Exemplo de Janela sem layout");
        try {
            montarTela();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    public void montarTela() throws Exception {
        getContentPane().setLayout(null);
        // Colocando Label nome na tela
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 20, 70, 20);
        getContentPane().add(nomeLabel);
        // Colocando o label do Endereço
        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoLabel.setBounds(10, 45, 70, 20);
        getContentPane().add(enderecoLabel);
        // Colocando o Label do Numero
        JLabel numeroLabel = new JLabel("Número:");
        numeroLabel.setBounds(10, 70, 70, 20);
        getContentPane().add(numeroLabel);
        // Colocando o Label do Bairro
        JLabel bairroLabel = new JLabel("Bairro:");
        bairroLabel.setBounds(10, 95, 70, 20);
        getContentPane().add(bairroLabel);
        // Colocando o campo nome na tela!
        JFormattedTextField nomeCampo = new JFormattedTextField();
        nomeCampo.setBounds(70, 20, 400, 20);
        getContentPane().add(nomeCampo);
        // Colocando o campo endereço na tela!
        JFormattedTextField enderecoCampo = new JFormattedTextField();
        enderecoCampo.setBounds(70, 45, 433, 20);
        getContentPane().add(enderecoCampo);
        // Colocando o campo número na tela!
        MaskFormatter mascaraNumero = new MaskFormatter("######");
        JFormattedTextField numeroCampo = new JFormattedTextField(mascaraNumero);
        numeroCampo.setBounds(70, 70, 50, 20);
        getContentPane().add(numeroCampo);
        // Colocando o combo-box de bairros na nossa tela
        JComboBox<String> bairrosCombo = new JComboBox<String>();
        bairrosCombo.addItem("Selecione um Bairro");
        
        for(BairrosEnum b:BairrosEnum.values()) {
            bairrosCombo.addItem(b.getDescricao());
        }
        bairrosCombo.setBounds(70, 95, 150, 20);
        getContentPane().add(bairrosCombo);

        JButton botaoConfirma = new JButton("Confirma");
        JButton botaoCancela = new JButton("Cancela");
        
        botaoConfirma.setBounds(5, 330, 89, 23);
        botaoCancela.setBounds(102, 330, 89, 23);

        getContentPane().add(botaoConfirma);
        getContentPane().add(botaoCancela);



    }


    public static void main(String[] args) {
        ExemploSemLayout esl = new ExemploSemLayout();
    }
    



}

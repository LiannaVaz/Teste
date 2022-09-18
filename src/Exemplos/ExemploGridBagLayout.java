package Exemplos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Arrays;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.text.MaskFormatter;

public class ExemploGridBagLayout extends JDialog {
    
    public ExemploGridBagLayout() {
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Exemplo GridBagLayout");
        setModal(true);

        JPanel painel = new JPanel(new GridBagLayout());

        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.HORIZONTAL;
 
        cons.gridx = 0; //coluna 0
        cons.gridy = 0; //linha 0
        cons.weightx = 0.20; //largura em percentual
        painel.add(new JLabel("Nome"), cons);

        JTextField campoNome = new JTextField(40);

        cons.gridx = 1; //coluna 1
        cons.gridy = 0; //linha 1
        cons.weightx = 0.80; //largura em percentual
        painel.add(campoNome, cons);

        // Label e Campo para endereço

        cons.gridx = 0; //coluna 0
        cons.gridy = 1; //linha 0
        cons.weightx = 0.20; //largura em percentual
        painel.add(new JLabel("Endereço"), cons);

        MaskFormatter mascaraEndereco = null;

        try {

        char[] fill = new char[50];
        Arrays.fill(fill, '*');
        String mascaraString = new String(fill);
            mascaraEndereco = new MaskFormatter(mascaraString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        JFormattedTextField campoEndereco = new JFormattedTextField(mascaraEndereco);

        cons.gridx = 1; //coluna 1
        cons.gridy = 1; //linha 1
        cons.weightx = 0.80; //largura em percentual
        painel.add(campoEndereco, cons);

        // Label e campo para o Numero

        cons.gridx = 0; //coluna 0
        cons.gridy = 2; //linha 0
        cons.weightx = 0.20; //largura em percentual
        painel.add(new JLabel("Numero"), cons);

        MaskFormatter mascaraNumero = null;
        
        try {
            mascaraNumero = new MaskFormatter("######");
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
        JFormattedTextField campoNumero = new JFormattedTextField(mascaraNumero);
        cons.gridx = 1; //coluna 1
        cons.gridy = 2; //linha 1
        cons.weightx = 0.80; //largura em percentual
        painel.add(campoNumero, cons);

        


        

        campoNome.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                
                if (campoNome.getText().length() >= 50) {
                    e.consume();
                }

                // Impedir a digitação de Números
                try {
                    Character ch = e.getKeyChar();
                    Integer.parseUnsignedInt(ch.toString());
                    e.consume();
                } catch (NumberFormatException nfe) {
                    
                } 
            }
        });

        
        // Label e campo para o CPF

        cons.gridx = 0; //coluna 0
        cons.gridy = 3; //linha 0
        cons.weightx = 0.20; //largura em percentual
        painel.add(new JLabel("CPF"), cons);
        MaskFormatter mascaraCPF = null;
        try {
            mascaraCPF = new MaskFormatter("###.###.###-##");
        } catch (ParseException pe) {
            // TODO Auto-generated catch block
            pe.printStackTrace();
        }

        JFormattedTextField campoCPF = new JFormattedTextField(mascaraCPF);
        cons.gridx = 1; //coluna 1
        cons.gridy = 3; //linha 3
        cons.weightx = 0.80; //largura em percentual
        painel.add(campoCPF, cons);

        // Label e campo para Data de Nascimento
        cons.gridx = 0;
        cons.gridy = 4;
        cons.weightx = 0.20;
        painel.add(new JLabel("Data de Nascimento"), cons);

        MaskFormatter mascaraData = null;
        try {
            mascaraData = new MaskFormatter("##/##/####");
        } catch (Exception e) {
            e.printStackTrace();
        }

        cons.gridx = 1;
        cons.gridy = 4;
        cons.weightx = 0.80;
        JFormattedTextField campoNascimento = new JFormattedTextField(mascaraData);
        painel.add(campoNascimento, cons);
        // Label e campo para o CEP
        cons.gridx = 0;
        cons.gridy = 5;
        cons.weightx = 0.20;
        painel.add(new JLabel("CEP"), cons);
        MaskFormatter mascaraCEP = null;
        
        try {
            mascaraCEP = new MaskFormatter("##.###-###");
        } catch(Exception e) {
            e.printStackTrace();
        }

        cons.gridx = 1;
        cons.gridy = 5;
        cons.weightx = 0.80;
        JFormattedTextField campoCEP = new JFormattedTextField(mascaraCEP);
        painel.add(campoCEP, cons);

        // Label e campo para a senha
        cons.gridx = 0;
        cons.gridy = 6;
        cons.weightx = 0.20;
        painel.add(new JLabel("Senha"), cons);
        
        cons.gridx = 1;
        cons.gridy = 6;
        cons.weightx = 0.80;
        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setEchoChar('*');
        painel.add(campoSenha, cons);


        add(painel, "Center");
        setVisible(true);
    }

    public static void main(String[] args) {
    

        ExemploGridBagLayout a = new ExemploGridBagLayout();
    }


}

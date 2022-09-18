package views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.text.MaskFormatter;

import Enums.BairrosEnum;
import Enums.PagamentosEnum;
import controle.clientesFormController;

public class clientesForm extends JDialog {

    private JFrame pai;
    private clientesFormController controle = new clientesFormController();


    public clientesForm(JFrame param) {
        pai = param;
        controle.setJanela(this);
        setSize(550, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Cliente");
        try {
            montarTela();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
        setLocationRelativeTo(pai);
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
        // Colocando o Label do CEP
        JLabel cepLabel = new JLabel("CEP:");
        cepLabel.setBounds(10, 120, 70, 20);
        getContentPane().add(cepLabel);

        // Colocando o Label do telefone
        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(10, 145, 70, 20);
        getContentPane().add(telefoneLabel);

        // Colocando o Label do e-mail
        JLabel emailLabel = new JLabel("E-Mail:");
        emailLabel.setBounds(10, 170, 70, 20);
        getContentPane().add(emailLabel);

        // Colocando o Label da senha
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(10, 195, 70, 20);
        getContentPane().add(senhaLabel);

        // Colocando o Label da senha
        JLabel pagamentoLabel = new JLabel("Pagamento:");
        pagamentoLabel.setBounds(10, 220, 70, 20);
        getContentPane().add(pagamentoLabel);




        // Colocando o campo nome na tela!
        JFormattedTextField nomeCampo = new JFormattedTextField();
        nomeCampo.setBounds(85, 20, 400, 20);
        nomeCampo.setName("nome");
        nomeCampo.addFocusListener(controle);
        getContentPane().add(nomeCampo);

        // Colocando o campo endereço na tela!
        JFormattedTextField enderecoCampo = new JFormattedTextField();
        enderecoCampo.setName("endereco");
        enderecoCampo.setBounds(85, 45, 433, 20);
        enderecoCampo.addFocusListener(controle);
        getContentPane().add(enderecoCampo);

        // Colocando o campo número na tela!
        MaskFormatter mascaraNumero = new MaskFormatter("######");
        JFormattedTextField numeroCampo = new JFormattedTextField(mascaraNumero);
        numeroCampo.setName("numero");
        numeroCampo.setBounds(85, 70, 50, 20);
        numeroCampo.addFocusListener(controle);
        getContentPane().add(numeroCampo);

        // Colocando o combo-box de bairros na nossa tela
        JComboBox<String> bairrosCombo = new JComboBox<String>();
        bairrosCombo.setName("bairro");
        bairrosCombo.addFocusListener(controle);
        bairrosCombo.addItem("Selecione um Bairro");
        
        for(BairrosEnum b:BairrosEnum.values()) {
            bairrosCombo.addItem(b.getDescricao());
        }
        bairrosCombo.setBounds(85, 95, 150, 20);
        getContentPane().add(bairrosCombo);

        // Colocando o campo CEP na tela!            
        MaskFormatter mascaraCEP = new MaskFormatter("##.###-###");
        JFormattedTextField cepCampo = new JFormattedTextField(mascaraCEP);
        cepCampo.setName("cep");
        cepCampo.setBounds(85, 120, 70, 20);
        cepCampo.addFocusListener(controle);
        getContentPane().add(cepCampo);

        // Colocando o campo Telefone  na tela!            
        MaskFormatter mascaraTelefone = new MaskFormatter("#####-####");
        JFormattedTextField telefoneCampo = new JFormattedTextField(mascaraTelefone);
        telefoneCampo.setName("telefone");
        telefoneCampo.setBounds(85, 145, 110, 20);
        telefoneCampo.addFocusListener(controle);
        getContentPane().add(telefoneCampo);

        // Colocando o campo e-mail  na tela!            
        JFormattedTextField emailCampo = new JFormattedTextField();
        emailCampo.setName("email");
        emailCampo.setBounds(85, 170, 200, 20);
        emailCampo.addFocusListener(controle);
        getContentPane().add(emailCampo);
        
        // Colocando o campo senha  na tela!            
        JPasswordField senhaCampo = new JPasswordField();
        senhaCampo.setName("senha");
        senhaCampo.setBounds(85, 195, 150, 20);
        senhaCampo.setColumns(10);
        senhaCampo.addFocusListener(controle);
        getContentPane().add(senhaCampo);
        
        // Colocando o combo-box de Formas de Pagamento na nossa tela
        JComboBox<String> pagamentosCombo = new JComboBox<String>();
        pagamentosCombo.setName("pagamento");
        pagamentosCombo.addFocusListener(controle);
        pagamentosCombo.addItem("Selecione uma forma de pagamento");
        
        for(PagamentosEnum b:PagamentosEnum.values()) {
            pagamentosCombo.addItem(b.name());
        }
        pagamentosCombo.setBounds(85, 220, 230, 20);
        getContentPane().add(pagamentosCombo);
        
        JButton botaoConfirma = new JButton("Confirma");
        JButton botaoCancela = new JButton("Cancela");
        
        botaoConfirma.setBounds(5, 330, 89, 23);
        botaoCancela.setBounds(102, 330, 89, 23);

        botaoConfirma.addActionListener(controle);
        botaoCancela.addActionListener(controle);

        getContentPane().add(botaoConfirma);
        getContentPane().add(botaoCancela);



    }

    public void mostra() {
        setVisible(true);
    }


    public static void main(String[] args) {
        clientesForm form = new clientesForm(null);

        form.mostra();
        
    }

    
}

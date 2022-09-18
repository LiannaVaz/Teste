package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import DAOs.ClientesDAO;
import Entidades.Cliente;
import Entidades.Pagamento;
import Enums.BairrosEnum;
import Enums.PagamentosEnum;
import views.clientesForm;

public class clientesFormController implements ActionListener, FocusListener {


    private clientesForm janela;
    private ClientesDAO dao = new ClientesDAO();
    private Cliente cli = new Cliente();
    

    public Cliente getCli() {
        return cli;
    }


    public void setCli(Cliente cli) {
        this.cli = cli;
    }



    public JDialog getJanela() {
        return janela;
    }



    public void setJanela(clientesForm janela) {
        this.janela = janela;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String textoBotao = e.getActionCommand();

        if (textoBotao.equals("Confirma")) {
            
            try {
                dao.validaInclusao(cli);
                dao.adicionar(cli);
                janela.dispose();
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(janela, exception.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }





        } else  {
            // Funcao do botao cancelar
            janela.dispose();
        }    
        
    }


    @Override
    public void focusGained(FocusEvent e) {
        System.out.println("Entrou no focusGained por que o campo recebeu o foco!!!");
        System.out.println(e.getID());
        System.out.println(e.getComponent().getName());
        
        
    }


    @Override
    public void focusLost(FocusEvent e) {
        System.out.println("Entrou no focusLost por que o campo perdeu o foco.");
        System.out.println(e.getID());
        System.out.println(e.getComponent().getName());

        if (e.getComponent().getName() == "nome") {
            JFormattedTextField obj = (JFormattedTextField) e.getComponent();
            System.out.println(obj.getText().trim());
            cli.setNome(obj.getText().trim());
        } else  if (e.getComponent().getName() == "endereco") {
            JFormattedTextField obj = (JFormattedTextField) e.getComponent();
            System.out.println(obj.getText().trim());
            cli.setEndereco(obj.getText().trim());
        } else  if (e.getComponent().getName() == "numero") {
            JFormattedTextField obj = (JFormattedTextField) e.getComponent();
            String valor = new String(obj.getText());
            System.out.println(valor);
            cli.setNumero(Integer.parseInt(valor));
        } else  if (e.getComponent().getName() == "cep") {
            JFormattedTextField obj = (JFormattedTextField) e.getComponent();
            String valor = obj.getText().trim();
            valor = valor.replace(".","");
            valor = valor.replace("-","").trim();
            if (valor != null && !valor.isEmpty()) {
                 System.out.println(valor);
            
                cli.setCEP(Integer.parseInt(valor));
            }
        } else  if (e.getComponent().getName() == "telefone") {
            JFormattedTextField obj = (JFormattedTextField) e.getComponent();
            String valor = obj.getText().trim();
            System.out.println(valor);
            cli.setTelefone(valor);
        } else  if (e.getComponent().getName() == "email") {
            JFormattedTextField obj = (JFormattedTextField) e.getComponent();
            System.out.println(obj.getText().trim());
            cli.setEmail(obj.getText().trim());
        } else  if (e.getComponent().getName() == "senha") {
            JPasswordField obj = (JPasswordField) e.getComponent();
            String valor = new String(obj.getPassword());
            System.out.println(valor);
            cli.setSenha(valor);
        } else  if (e.getComponent().getName() == "bairro") {
           
            JComboBox obj = (JComboBox) e.getComponent();
            String valor = String.valueOf(obj.getSelectedItem());
            if (!valor.equals("Selecione um Bairro")) {
                System.out.println(valor);
                System.out.println(BairrosEnum.valueOf(valor));
                cli.setBairro(BairrosEnum.valueOf(valor));
            }
            //cli.setSenha(valor);
        } else  if (e.getComponent().getName() == "pagamento") {
            JComboBox obj = (JComboBox) e.getComponent();
            String valor = String.valueOf(obj.getSelectedItem());
            if (!valor.equals("Selecione uma forma de pagamento")) {
                System.out.println(valor);
                System.out.println(PagamentosEnum.valueOf(valor));

                Pagamento pag = new Pagamento();
                pag.setTipo(PagamentosEnum.valueOf(valor));
                cli.setFormadePagamento(pag);
            }
        }   
    }


    


}

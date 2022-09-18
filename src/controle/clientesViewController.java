package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import DAOs.ClientesDAO;
import Entidades.Cliente;
import views.clientesForm;

public class clientesViewController implements ActionListener {


    private JFrame janela;
    private ClientesDAO dao = new ClientesDAO();
    private List<Cliente> clientes = dao.listar();
    private JTable tabela;

    public JTable montaTabela() {
        
        String[] colunas = new String[] {"Código", "Nome","Endereço", "Número", "Bairro", "Telefone", "E-mail"} ;
        Object[][] dados = new Object[clientes.size()][7];
        System.out.println(clientes.size());

        Integer contador = 0;
        for(Cliente cli:clientes) {
            dados[contador][0] = cli.getCodigo();
            dados[contador][1] = cli.getNome();
            dados[contador][2] = cli.getEndereco();
            dados[contador][3] = cli.getNumero();
            dados[contador][4] = cli.getBairro();
            dados[contador][5] = cli.getTelefone();
            dados[contador][6] = cli.getEmail();
            contador++;
        }
        tabela = new JTable(dados, colunas);
        return tabela;
    }

    public clientesViewController() {
        super();
    }

    public clientesViewController(JFrame param) {
        super();
        this.janela = param;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       

        String textoBotao = e.getActionCommand();

        if (textoBotao.equals("Adicionar")) {
            clientesForm form = new clientesForm(janela);
            form.mostra();
            tabela.repaint();
        } else if (textoBotao.equals("Alterar")) {
            
            clientesForm form = new clientesForm(janela);
            form.mostra();

        } else if (textoBotao.equals("Remover")) {
            System.out.println("Removendo cliente");
            Integer opcao = JOptionPane.showConfirmDialog(janela, "Confirma Exclusão?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (opcao == 0) {
                System.out.println("Cliente excluído para todo o sempre!");
            } else {
                System.out.println("Cliente poupado da exclusão ... dessa vez !");
            }

        }    

        
    }

    

    

    
    
}

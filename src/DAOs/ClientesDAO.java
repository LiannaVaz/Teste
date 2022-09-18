package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Cliente;
import Entidades.Pagamento;
import Enums.BairrosEnum;
import Enums.PagamentosEnum;
import Validacoes.ValidaCliente;

public class ClientesDAO {

    String enderecoBD = "jdbc:mariadb://localhost:3306/ubeer";
    String userBD = "root";
    String senhaBD = "univille";



    public static void main(String[] args) {
        ClientesDAO cd = new ClientesDAO();
        List<Cliente> result = cd.listar("teste");
        System.out.println("Quantos clientes ? " + result.size());
    }
    

    private List<Cliente> retornaListaClientesTeste() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente c1 = new Cliente();
        c1.setCodigo(1);
        c1.setNome("José da Silva");
        c1.setEndereco("Rua satunino de brito");
        c1.setNumero(74);
        c1.setBairro(BairrosEnum.Paranaguamirim);
        c1.setCEP(892000000);
        c1.setTelefone("9999999");
        c1.setEmail("jose.silva@Ubeer.com");
        c1.setSenha("Secreta@");
        Pagamento dinheiro = new Pagamento();
        dinheiro.setTipo(PagamentosEnum.Dinheiro);
        c1.setFormadePagamento(dinheiro);

        Cliente c2 = new Cliente();
        c2.setCodigo(2);
        c2.setNome("Marciano Verdi");
        c2.setEndereco("Rua Marte");
        c2.setNumero(4000);
        c2.setBairro(BairrosEnum.AdhemarGarcia);
        c2.setCEP(892012000);
        c2.setTelefone("932329999");
        c2.setEmail("joao.souza@Ubeer.com");
        c2.setSenha("Senha@");
        Pagamento credito = new Pagamento();
        credito.setNumero(3421234);
        credito.setCVC(123);
        credito.setTipo(PagamentosEnum.Crédito);
        c2.setFormadePagamento(credito);

        Cliente c3 = new Cliente();
        c3.setCodigo(3);
        c3.setNome("Odete Roitmann");
        c3.setEndereco("Rua Berrini");
        c3.setNumero(70);
        c3.setBairro(BairrosEnum.BoaVista);
        c3.setCEP(892222000);
        c3.setTelefone("932234999");
        c3.setEmail("odete.roitmann@Ubeer.com");
        c3.setSenha("SuperSecreta@123");
        Pagamento debito = new Pagamento();
        credito.setNumero(4421234);
        credito.setCVC(126);
        credito.setTipo(PagamentosEnum.Débito);
        c3.setFormadePagamento(debito);

        Cliente c4 = new Cliente();
        c4.setCodigo(4);
        c4.setNome("Hideo Komija");
        c4.setEndereco("Alguma rua no japao");
        c4.setNumero(5);
        c4.setBairro(BairrosEnum.BoaVista);
        c4.setCEP(892222000);
        c4.setTelefone("932234999");
        c4.setEmail("hideo.kojima@Ubeer.com");
        c4.setSenha("SuperSecreta@123");
        c4.setFormadePagamento(debito);

        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);

        
        


       return clientes; 
    }

    public List<Cliente> listar(String param) {

        if (param.equalsIgnoreCase("teste")) {
            return retornaListaClientesTeste();
        }




        return new ArrayList<Cliente>();
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<Cliente>();

        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(enderecoBD, 
                                                  userBD, 
                                                  senhaBD);

            PreparedStatement query = conexao.prepareStatement("SELECT * from cliente;");

            ResultSet resultado = query.executeQuery();
            while(resultado.next()) {
                Integer codCliente = resultado.getInt(1);
                String nomeCliente = resultado.getString(2);
                String enderecoCliente = resultado.getString(3);
                Integer numero = resultado.getInt(4);
                String Bairro = resultado.getString(5);
                String telefone = resultado.getString(6);
                String email = resultado.getString(7);
                Integer cep = resultado.getInt(8);

                Cliente cliente = new Cliente();
                cliente.setCodigo(codCliente);
                cliente.setNome(nomeCliente);
                cliente.setEndereco(enderecoCliente);
                cliente.setNumero(numero);
                cliente.setBairro(BairrosEnum.BoaVista);
                cliente.setCEP(cep);
                cliente.setTelefone(telefone);
                cliente.setEmail(email);
                cliente.setSenha("SuperSecreta@123");
                //cliente.setFormadePagamento(debito);

                clientes.add(cliente);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }



        return clientes;
    }

    public void adicionar(Cliente cli) {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(enderecoBD, 
                                                  userBD, 
                                                  senhaBD);
	
            PreparedStatement query = conexao.prepareStatement("INSERT INTO cliente (cliente.nome, cliente.endereco, " +
                                                               "cliente.numero, cliente.bairro, cliente.telefone, cliente.email, " +
                                                               "cliente.cep, cliente.senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?); ");

           query.setString(1, cli.getNome());
           query.setString(2, cli.getEndereco());  
           query.setInt(3, cli.getNumero());
           query.setString(4, cli.getBairro().getDescricao());
           query.setString(5, cli.getTelefone());  
           query.setString(6, cli.getEmail());
           query.setInt(7, cli.getCEP());
           query.setString(8, cli.getSenha());  

           Integer resultado = query.executeUpdate();
           System.out.println("ClienterDAO - adicionar - resultado " + resultado);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void editar(Cliente cli) {
        
    }

    public void excluir(Cliente cli) {
        
    }

    public void validaInclusao(Cliente cli) throws Exception {
        ValidaCliente vc = new ValidaCliente();
        vc.validaInclusao(cli);
    }

    public void validaEdicao(Cliente cli) throws Exception {
        ValidaCliente vc = new ValidaCliente();
        vc.validaEdicao(cli);

    }

    
}

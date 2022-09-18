package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Pagamento;

import Validacoes.ValidaPagamento;

public class PagamentosDAO {

    String enderecoBD = "jdbc:mariadb://localhost:3306/ubeer";
    String userBD = "root";
    String senhaBD = "univille";


    ValidaPagamento validador = new ValidaPagamento();

    public List<Pagamento> listar() {
        List<Pagamento> pagamentos = new ArrayList<Pagamento>();


        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(enderecoBD, 
                                                  userBD, 
                                                  senhaBD);

            PreparedStatement query = conexao.prepareStatement("SELECT * from pagamento;");

            ResultSet resultado = query.executeQuery();
            while(resultado.next()) {
                Integer codPagamento = resultado.getInt(1);
                String nomePagamento = resultado.getString(2);
                Boolean credenciais = resultado.getBoolean(3);
                Pagamento pag = new Pagamento();
                pag.setCodigo(codPagamento);
                pag.setNome(nomePagamento);
                pag.setCredencial(credenciais);
                
                pagamentos.add(pag);
                

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


        return pagamentos;
    }

    public void adicionar(Pagamento pag) {

    }

    public void editar(Pagamento Pag) {

    }

    public void excluir(Pagamento pag) {

    }

    public void validaInclusao(Pagamento pag) throws Exception  {
        validador.validaAdicao(pag);

    }

    public void validaEdicao(Pagamento pag) throws Exception {
        validador.validaEdicao(pag);
    }

    public void validaExclusao(Pagamento pag) throws Exception {
        validador.validaExclusao(pag);
    }


    
}

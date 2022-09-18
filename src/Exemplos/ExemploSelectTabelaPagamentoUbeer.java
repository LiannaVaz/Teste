package Exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExemploSelectTabelaPagamentoUbeer {

    public static void main(String[] args) {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost:3306/ubeer", 
                                                            "root", 
                                                            "univille");

            PreparedStatement query = conexao.prepareStatement("SELECT * from pagamento;");

            ResultSet resultado = query.executeQuery();
            while(resultado.next()) {
                Integer codPagamento = resultado.getInt(1);
                String nomePagamento = resultado.getString(2);
                Boolean credenciais = resultado.getBoolean(3);
                System.out.println(codPagamento + " " + nomePagamento + " " + credenciais);

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


    }
    
}

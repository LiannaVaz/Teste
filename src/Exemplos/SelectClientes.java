package Exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectClientes {

    public static void main(String[] args) {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost:3306/ubeer", 
                                                            "root", 
                                                            "univille");

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

                System.out.println(codCliente + " " + nomeCliente + " " + enderecoCliente +
                                   numero + " " + Bairro + " " + telefone +
                                   email + " " + cep);

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

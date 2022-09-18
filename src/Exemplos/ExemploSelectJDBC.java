package Exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExemploSelectJDBC {

    public static void main(String[] args) {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escola", 
                                                            "root", 
                                                            "univille");

            PreparedStatement query = conexao.prepareStatement("SELECT aluno.NomeAluno FROM aluno;");

            ResultSet resultado = query.executeQuery();
            while(resultado.next()) {
                String nomeAluno = resultado.getString(1);
                System.out.println(nomeAluno);

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

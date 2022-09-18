package Exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ExemploUpdateJDBC {

    public static void main(String[] args) {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escola", 
                                                            "root", 
                                                            "univille");

            PreparedStatement query = conexao.prepareStatement("UPDATE aluno SET aluno.NomeAluno = ?," +
                                                               " aluno.CodTurma = ? WHERE aluno.CodAluno > ?; " );

           query.setString(1, "Astrobaldo");
           query.setInt(2, 4);
           query.setInt(3, 10);

           Integer resultado = query.executeUpdate();
           System.out.println("Foram alterados " + resultado + " registros na tabela aluno");

            
            

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

package Exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExemploInsertJDBC {

    public static void main(String[] args) {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escola", 
                                                            "root", 
                                                            "univille");

            PreparedStatement query = conexao.prepareStatement("INSERT INTO aluno (aluno.NomeAluno, aluno.CodTurma)" +
                                                                                   " VALUES (?, ?);" );

           query.setString(1, "Enzo");
           query.setInt(2, 1);

           Integer resultado = query.executeUpdate();
           System.out.println("Foram criados " + resultado + " registros na tabela aluno");

            
            

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

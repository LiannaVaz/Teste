package Exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class ExemploDeleteJDBC {
    public static void main(String[] args) {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escola", 
                                                            "root", 
                                                            "univille");

            PreparedStatement query = conexao.prepareStatement("DELETE FROM aluno WHERE aluno.CodAluno = ?;");

            query.setInt(1, 11);
           

           Integer resultado = query.executeUpdate();
           System.out.println("Foram excluídos " + resultado + " registros na tabela aluno");

            
            

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

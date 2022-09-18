package Exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class ExemploConexao {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/escola",
            "root", "univille");

            PreparedStatement statement = connection.prepareStatement("SELECT aluno.NomeAluno FROM aluno;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String val1 = resultSet.getString(1);
                System.out.println(val1);
            }    
  
            if (connection != null) {
                System.out.println(connection.isValid(100));
            } 



            connection.close();

    }
}

package Exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExemploConexaoJDBC {

    public static void main(String[] args) {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escola", 
                                                            "root", 
                                                            "univille");

            if (conexao != null) {
                
                System.out.println("Conectamos no banco " );
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

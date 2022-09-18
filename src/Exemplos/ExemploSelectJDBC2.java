package Exemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExemploSelectJDBC2 {

    public static void main(String[] args) {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost:3306/escola", 
                                                            "root", 
                                                            "univille");

            PreparedStatement query = conexao.prepareStatement("SELECT aluno.NomeAluno, aluno.CodAluno," +
                                                               "turma.TurmaNome FROM aluno JOIN turma ON " + 
                                                               "aluno.CodTurma = turma.CodTurma;");

            ResultSet resultado = query.executeQuery();
            while(resultado.next()) {
                String nomeAluno = resultado.getString(1);
                Integer codigo = resultado.getInt(2);
                String nomeTurma = resultado.getString(3);
                System.out.println(codigo + " - " +nomeAluno + " - " + nomeTurma);

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

package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App
{
    public static void main(String[] args)
    {
        Connection con;

        String driver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/users";
        String login = "azmovi";
        String password = "123";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dbURL, login, password);
        }
        catch (Exception e)
        {
            System.out.println(e);
            con = null;
        }

        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            statement = con.createStatement();

            String query = "SELECT id, nome, senha, idade FROM user";
            resultSet = statement.executeQuery(query);

            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                int idade = resultSet.getInt("idade");

                // Faça o que quiser com os valores
                System.out.println("Id: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Senha: " + senha);
                System.out.println("Idade: " + idade);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally 
        {
            try
            {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (con != null) con.close();
            } 
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}

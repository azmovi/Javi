package br.ufscar.dc.dsw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessaBD {

	public static void main(String[] args) {
		try {

			/* Setup para uso do banco de dados MySQL */

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Livraria";
			Connection con = (Connection) DriverManager.getConnection(url,
					"root", "root");

			Statement stmt = con.createStatement();
            
            stmt.executeUpdate("insert into Editora(cnpj, nome) values  ('87.557.922/0001-82', 'Seguinte');");
            stmt.executeUpdate("insert into Livro(titulo, autor, ano, preco, editora_id) values ('O Dia do Curinga', 'Jostein Gaarder', 1996, 29.99, 4);");
            stmt.executeUpdate("insert into Livro(titulo, autor, ano, preco, editora_id) values ('A Revolução dos Bichos', 'George Orwell', 2007, 23.90, 1);");

			ResultSet rs = stmt.executeQuery("select * from Livro order by preco");
			while (rs.next()) {
				System.out.print(rs.getString("Titulo"));
				System.out.print(", " + rs.getString("Autor"));
				System.out.print(", " + rs.getInt("Ano"));
				System.out.println(" (R$ " + rs.getFloat("Preco") + ")");
			}
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("A classe do driver de conexão não foi encontrada!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("O comando SQL não pode ser executado!");
		}
	}
}

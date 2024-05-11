package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Studio;
import br.ufscar.dc.dsw.domain.Filme;

public class FilmeDAO extends GenericDAO {

    public void insert(Filme filme) {

        String sql = "INSERT INTO Filme(nome, diretor, ano, preco, studio_id) VALUES (?, ?, ?, ?, ?)";

        try
        {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, filme.getNome());
            statement.setString(2, filme.getDiretor());
            statement.setInt(3, filme.getAno());
            statement.setFloat(4, filme.getPreco());
            statement.setLong(5, filme.getStudio().getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        }

        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Filme> getAll() {

        List<Filme> listaFilmes = new ArrayList<>();

        String sql = "SELECT * from Filme f, Studio s where f.STUDIO_ID = s.ID order by f.id";

        try
        {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String diretor = resultSet.getString("diretor");
                int ano = resultSet.getInt("ano");
                float preco = resultSet.getFloat("preco");

                Long studio_id= resultSet.getLong("studio_id");
                String cnpj = resultSet.getString("cnpj");
                String empresa = resultSet.getString("empresa");

                Studio studio = new Studio(studio_id, cnpj, empresa);
                Filme filme = new Filme(id, nome, diretor, ano, preco, studio);
                listaFilmes.add(filme);
            }

            resultSet.close();
            statement.close();
            conn.close();

        }

        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return listaFilmes;
    }

    public void delete(Filme filme) {
        String sql = "DELETE FROM Livro where id = ?";

        try 
        {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, filme.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        }

        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void update(Filme filme) {
        String sql = "UPDATE Livro SET titulo = ?, autor = ?, ano = ?, preco = ?";
        sql += ", editora_id = ? WHERE id = ?";

        try 
        {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, filme.getNome());
            statement.setString(2, filme.getDiretor());
            statement.setInt(3, filme.getAno());
            statement.setFloat(4, filme.getPreco());
            statement.setFloat(5, filme.getStudio().getId());
            statement.setLong(6, filme.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        }

        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Filme get(Long id) {
        Filme filme = null;

        String sql = "SELECT * from Filme f, Studio s WHERE f.id = ? AND f.STUDIO_ID = s.id";

        try
        {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                String nome = resultSet.getString("nome");
                String diretor = resultSet.getString("diretor");
                int ano = resultSet.getInt("ano");
                float preco = resultSet.getFloat("preco");

                Long studio_id = resultSet.getLong("studio_id");
                Studio studio = new StudioDAO().get(studio_id);

                filme = new Filme(id, nome, diretor, ano, preco, studio);
            }

            resultSet.close();
            statement.close();
            conn.close();
        }

        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return filme;
    }
}

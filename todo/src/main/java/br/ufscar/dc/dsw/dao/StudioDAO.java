package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Studio;

public class StudioDAO extends GenericDAO {

    public List<Studio> getAll() {

        List<Studio> listaStudios = new ArrayList<>();

        String sql = "SELECT * from Studio";

        try
        {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next())
            {
                Long id = resultSet.getLong("id");
                String cnpj = resultSet.getString("cnpj");
                String empresa = resultSet.getString("empresa");
                Studio studio= new Studio(id, cnpj, empresa);
                listaStudios.add(studio);
            }

            resultSet.close();
            statement.close();
            conn.close();

        }

        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return listaStudios;
    }

    public Studio get(Long id) {
        Studio studio = null;
        
        String sql = "SELECT * from Studio where id = ?";

        try
        {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                String cnpj = resultSet.getString("cnpj");
                String empresa = resultSet.getString("empresa");
                studio = new Studio(id, cnpj, empresa);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } 

        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return studio;
    }
}

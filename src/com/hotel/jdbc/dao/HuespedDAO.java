package com.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotel.jdbc.modelo.Huespedes;
import com.hotel.jdbc.modelo.Reservas;

public class HuespedDAO {

    private Connection con;

    public HuespedDAO(Connection con) {
        this.con = con;
    }

    public void guardar(Huespedes huesped) {
        try {
            PreparedStatement statement;
                statement = con.prepareStatement(
                        "INSERT INTO HUESPEDES "
                        + "(Nombre, Apellido, FechaNacimiento, Nacionalidad, Telefono)"
                        + " VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            try (statement) {
                statement.setString(1, huesped.getNombre());
                statement.setString(2, huesped.getApellido());
                statement.setString(3, huesped.getFechaNacimiento());
                statement.setString(4, huesped.getNacionalidad());
                statement.setString(5, huesped.getTelefono());
                //statement.setInt(6, huesped.getIdReserva());
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        huesped.setId(resultSet.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Huespedes> listar() {
        List<Huespedes> resultado = new ArrayList<>();

        try {
            String sql = "SELECT * FROM HUESPEDES";
            
            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                	    resultado.add(new Huespedes(
                	    		resultSet.getInt("id"),
                	            resultSet.getString("Nombre"),
                	            resultSet.getString("Apellido"),
                	            resultSet.getString("FechaNacimiento"),
                	            resultSet.getString("Nacionalidad"),
                	            resultSet.getString("Telefono"),
                	            resultSet.getInt("idReserva")));
                	}
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
    
    public int modificar(Integer id, String Nombre, String Apellido, String FechaNacimiento, String Nacionalidad, String Telefono) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE HUESPEDES SET "
                    + " ID = ?,"
                    + " NOMBRE = ?,"
                    + " APELLIDO = ?,"
                    + " FECHANACIMIENTO = ?,"
                    + " NACIONALIDAD = ?,"
                    + " TELEFONO = ?"
                    + " WHERE ID = ?");

            
            try (statement) {
            	statement.setInt(1, id);
                statement.setString(2, Nombre);
                statement.setString(3, Apellido);
                statement.setString(4, FechaNacimiento);
                statement.setString(5, Nacionalidad);
                statement.setString(6, Telefono);
                statement.setInt(7, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();
                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int eliminar(Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM HUESPEDES WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Huespedes> listarOnly(String txtFiltado) {
        List<Huespedes> resultado = new ArrayList<>();
        
        try {
           String sql = "SELECT * FROM HUESPEDES WHERE id='"+ txtFiltado +"' or nombre='"+txtFiltado+"' or apellido='"+txtFiltado+"' or nacionalidad='"+txtFiltado+"' or telefono='"+txtFiltado+"'" ;

           final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                	    resultado.add(new Huespedes(
                	    		resultSet.getInt("id"),
                	    		resultSet.getString("Nombre"),
                	            resultSet.getString("Apellido"),
                	            resultSet.getString("FechaNacimiento"),
                	            resultSet.getString("Nacionalidad"),
                	            resultSet.getString("Telefono"), 
                	            null));
                	}
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
}
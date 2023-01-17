package com.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotel.jdbc.modelo.Huespedes;
import com.hotel.jdbc.modelo.Reservas;

public class ReservaDAO {

	 private Connection con;

	    public ReservaDAO(Connection con) {
	        this.con = con;
	    }
	    
	    public void guardar(Reservas reserva) {
	        try {
	            PreparedStatement statement;
	                statement = con.prepareStatement(
	                        "INSERT INTO RESERVAS "
	                        + "(FechaEntrada, FechaSalida, Valor, FormaPago)"
	                        + " VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	    
	            try (statement) {
	                statement.setDate(1, reserva.getFechaEntrada());
	                statement.setDate(2, reserva.getFechaSalida());
	                statement.setInt(3, reserva.getValor());
	                statement.setString(4, reserva.getFormaPago());
	    
	                statement.execute();
	                final ResultSet resultSet = statement.getGeneratedKeys();
	    
	                try (resultSet) {
	                    while (resultSet.next()) {
	                    	reserva.setId(resultSet.getInt(1));
	                       
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    public List<Reservas> listar() {
	        List<Reservas> resultado = new ArrayList<>();

	        try {
	            String sql = "SELECT * FROM RESERVAS";
	            
	            final PreparedStatement statement = con
	                    .prepareStatement(sql);

	            try (statement) {
	                final ResultSet resultSet = statement.executeQuery();

	                try (resultSet) {
	                    while (resultSet.next()) {
	                	    resultado.add(new Reservas(
	                	    		resultSet.getInt("id"),
	                	    		resultSet.getDate("FechaEntrada"),
	                	            resultSet.getDate("FechaSalida"),
	                	            resultSet.getInt("Valor"),
	                	            resultSet.getString("FormaPago")));
	                	}
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return resultado;
	    }
	    
	    public int modificar(Integer id, Date FechaEntrada , Date FechaSalida, Integer Valor, String FormaPago, Integer id2) {
	        try {
	            final PreparedStatement statement = con.prepareStatement(
	                    "UPDATE RESERVAS SET "
                		+ " ID = ?,"
	                    + " FECHAENTRADA = ?,"
	                    + " FECHASALIDA = ?,"
	                    + " VALOR = ?,"
	                    + " FORMAPAGO = ?"
	                    + " WHERE ID = ?");

	            try (statement) {
	            	statement.setInt(1, id);
	            	statement.setDate(2, FechaEntrada);
	                statement.setDate(3, FechaSalida);
	                statement.setInt(4, Valor);
	                statement.setString(5, FormaPago);
	                statement.setInt(6, id2);
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
	            final PreparedStatement statement = con.prepareStatement("DELETE FROM RESERVAS WHERE ID = ?");

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
	    
	    public List<Reservas> listarOnly(String txtFiltado) {
	        List<Reservas> resultado = new ArrayList<>();

	        try {
	           String sql = "SELECT * FROM RESERVAS WHERE id='"+ txtFiltado +"' or Valor='"+txtFiltado+"' or FormaPago='"+txtFiltado+"' ";
	           final PreparedStatement statement = con
	                    .prepareStatement(sql);

	            try (statement) {
	                final ResultSet resultSet = statement.executeQuery();

	                try (resultSet) {
	                    while (resultSet.next()) {
	                	    resultado.add(new Reservas(
	                	    		resultSet.getInt("id"),
	                	    		resultSet.getDate("FechaEntrada"),
	                	            resultSet.getDate("FechaSalida"),
	                	            resultSet.getInt("Valor"),
	                	            resultSet.getString("FormaPago")));
	                	}
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return resultado;
	    }
	    
	   

}
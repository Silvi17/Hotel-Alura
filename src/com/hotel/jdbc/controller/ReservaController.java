package com.hotel.jdbc.controller;

import java.sql.Date;
import java.util.List;

import com.hotel.jdbc.dao.ReservaDAO;
import com.hotel.jdbc.factory.ConnectionFactory;
import com.hotel.jdbc.modelo.Reservas;

public class ReservaController {

    private ReservaDAO reservaDAO;

    public ReservaController() {
        var factory = new ConnectionFactory();
        this.reservaDAO = new ReservaDAO(factory.recuperaConexion());
    }

    public int eliminar(Integer id) {
        return reservaDAO.eliminar(id);
    }
    
    public int modificar(Integer id, Date FechaEntrada ,Date FechaSalida,Integer Valor,String FormaPago, Integer id2) {
        return reservaDAO.modificar(id, FechaEntrada ,FechaSalida,Valor,FormaPago, id2);
    }
    
    public List<Reservas> listar() {
        return this.reservaDAO.listar();
    }
	
    public void guardar(Reservas reserva) {
    	reservaDAO.guardar(reserva);
    }

	public List<Reservas> listarOnly(String txtFiltado) {
		   return this.reservaDAO.listarOnly(txtFiltado);
	}
}

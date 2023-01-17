package com.hotel.jdbc.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.hotel.jdbc.modelo.Reservas;

public class Reservas {
	

	private Integer id;

    private Date FechaEntrada;

    private Date FechaSalida;

    private Integer Valor;
    
    private String FormaPago;


	public Reservas(Integer id, Date FechaEntrada, Date FechaSalida, Integer Valor, String FormaPago) {
		this.id = id;
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida ;
        this.Valor = Valor;
        this.FormaPago = FormaPago;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaEntrada() {
		return FechaEntrada;
	}

	public void setFechaEntrada(Date FechaEntrada) {
		this.FechaEntrada = FechaEntrada;
	}

	public Date getFechaSalida() {
		return FechaSalida;
	}

	public void setFechaSalida(Date FechaSalida) {
		this.FechaSalida = FechaSalida;
	}

	public Integer getValor() {
		return Valor;
	}

	public void setValor(Integer Valor) {
		this.Valor = Valor;
	}

	public String getFormaPago() {
		return FormaPago;
	}

	public void setFormaPago(String FormaPago) {
		this.FormaPago = FormaPago;
	}
    


}

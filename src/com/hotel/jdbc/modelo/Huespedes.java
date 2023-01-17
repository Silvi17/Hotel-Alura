package com.hotel.jdbc.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.hotel.jdbc.modelo.Huespedes;

public class Huespedes {
	
	private Integer id;

    private String Nombre;
    
    private String Apellido;
    
    private String FechaNacimiento;
    
    private String Nacionalidad;
    
    private String Telefono;
    
    private Integer idReserva;
    
    
    private List<Huespedes> huesped = new ArrayList<>();

    

	public Huespedes(Integer id, String Nombre, String Apellido, String FechaNacimiento, String Nacionalidad, String Telefono, Integer idReserva) {
		this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.FechaNacimiento = FechaNacimiento;
        this.Nacionalidad = Nacionalidad;
        this.Telefono = Telefono;
        this.idReserva = idReserva;
    }

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.Nombre;
    }

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String FechaNacimiento) {
		this.FechaNacimiento = FechaNacimiento;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String Nacionalidad) {
		this.Nacionalidad = Nacionalidad;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}

	public List<Huespedes> getHuesped() {
		return huesped;
	}
	public void setHuesped(List<Huespedes> huesped) {
		this.huesped = huesped;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String Apellido) {
		this.Apellido = Apellido;
	}
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}



}

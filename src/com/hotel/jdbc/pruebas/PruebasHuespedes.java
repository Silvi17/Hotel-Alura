package com.hotel.jdbc.pruebas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hotel.jdbc.controller.HuespedController;


import com.hotel.jdbc.factory.ConnectionFactory;
import com.hotel.jdbc.modelo.Huespedes;


public class PruebasHuespedes {

    public static void main(String[] args) throws SQLException {


        List<Huespedes> nuevo;
		try {
			HuespedController huespedController = new HuespedController();


			System.out.println(huespedController.listar());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  
    }

}
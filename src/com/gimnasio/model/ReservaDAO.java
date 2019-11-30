package com.gimnasio.model;

import com.gimnasio.entities.Reserva;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class ReservaDAO extends Conexion<Reserva> implements GenericDAO<Reserva>{
	
	public ReservaDAO() {
		super(Reserva.class);
	}

}

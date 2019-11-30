package com.gimnasio.model;

import com.gimnasio.entities.Clase;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class ClaseDAO extends Conexion<Clase> implements GenericDAO<Clase> {
	
	public ClaseDAO() {
		super(Clase.class);
	}

}

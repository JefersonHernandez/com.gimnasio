package com.gimnasio.model;

import com.gimnasio.entities.Asiste;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class AsisteDAO extends Conexion<Asiste> implements GenericDAO<Asiste>{

	public AsisteDAO() {
		super(Asiste.class);
	}
}

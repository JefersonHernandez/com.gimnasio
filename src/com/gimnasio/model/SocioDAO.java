package com.gimnasio.model;

import com.gimnasio.entities.Socio;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class SocioDAO extends Conexion<Socio> implements GenericDAO<Socio>{
	public SocioDAO() {
		super(Socio.class);
	}
}

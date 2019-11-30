package com.gimnasio.model;

import com.gimnasio.entities.Preparacion;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class PreparacionDAO extends Conexion<Preparacion> implements GenericDAO<Preparacion>{
	public PreparacionDAO() {
		super(Preparacion.class);
	}
}

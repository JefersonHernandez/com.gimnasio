package com.gimnasio.model;


import com.gimnasio.entities.AparatoEstado;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class AparatoEstadoDAO extends Conexion<AparatoEstado> implements GenericDAO<AparatoEstado> {
	
	public AparatoEstadoDAO() {
		super(AparatoEstado.class);
	}

}

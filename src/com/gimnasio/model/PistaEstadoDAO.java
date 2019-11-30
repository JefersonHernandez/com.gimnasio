package com.gimnasio.model;

import com.gimnasio.entities.PistaEstado;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class PistaEstadoDAO extends Conexion<PistaEstado> implements GenericDAO<PistaEstado>{
	public PistaEstadoDAO() {
		super(PistaEstado.class);
	}
}

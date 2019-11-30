package com.gimnasio.model;

import com.gimnasio.entities.PistaSquash;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class PistaSquashDAO extends Conexion<PistaSquash> implements GenericDAO<PistaSquash>{
	public PistaSquashDAO() {
		super(PistaSquash.class);
	}
}

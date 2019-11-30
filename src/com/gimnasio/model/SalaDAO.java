package com.gimnasio.model;

import com.gimnasio.entities.Sala;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class SalaDAO extends Conexion<Sala> implements GenericDAO<Sala>{
	public SalaDAO() {
		super(Sala.class);
	}
}

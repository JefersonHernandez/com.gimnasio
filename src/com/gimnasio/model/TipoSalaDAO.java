package com.gimnasio.model;

import com.gimnasio.entities.TipoSala;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class TipoSalaDAO extends Conexion<TipoSala> implements GenericDAO<TipoSala> {
	
	public TipoSalaDAO() {
		super(TipoSala.class);
	}

}

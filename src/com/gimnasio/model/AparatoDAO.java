package com.gimnasio.model;

import com.gimnasio.entities.Aparato;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class AparatoDAO extends Conexion<Aparato> implements GenericDAO<Aparato>{
	public AparatoDAO() {
		super(Aparato.class);
	}
}

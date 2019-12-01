package com.gimnasio.model;

import com.gimnasio.entities.Administradores;
import com.gimnasio.entities.Aparato;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class AdministradoresDAO extends Conexion<Administradores> implements GenericDAO<Administradores>{
	public AdministradoresDAO() {
		super(Administradores.class);
	}
}

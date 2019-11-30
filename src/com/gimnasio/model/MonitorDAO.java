package com.gimnasio.model;

import com.gimnasio.entities.Monitor;
import com.gimnasio.util.Conexion;
import com.gimnasio.util.GenericDAO;

public class MonitorDAO extends Conexion<Monitor> implements GenericDAO<Monitor>{
	public MonitorDAO() {
		super(Monitor.class);
	}
}

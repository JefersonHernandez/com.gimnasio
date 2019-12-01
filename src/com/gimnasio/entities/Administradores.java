package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADMINISTRADORES database table.
 * 
 */
@Entity
@Table(name="ADMINISTRADORES")
@NamedQuery(name="Administradores.findAll", query="SELECT a FROM Administradores a")
public class Administradores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codigo")
	private String codigo;

	private String clave;

	private String nombre;

	public Administradores() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
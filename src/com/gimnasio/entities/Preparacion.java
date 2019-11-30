package com.gimnasio.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the PREPARACION database table.
 * 
 */
@Entity
@Table(name="PREPARACION")
@NamedQuery(name="Preparacion.findAll", query="SELECT p FROM Preparacion p")
public class Preparacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	@Column(name="descripcion", length=200)
	private String descripcion;	
	
	@OneToMany(mappedBy = "descripcion")
	private List<Clase> clases;
	
	public Preparacion() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	
}
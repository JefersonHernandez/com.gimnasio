package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MONITOR database table.
 * 
 */
@Entity
@Table(name="MONITOR")
@NamedQuery(name="Monitor.findAll", query="SELECT m FROM Monitor m")
public class Monitor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;

	@Column(name="experiencia",length=50)
	private String experiencia;
	
	@Column(name="nombre",length=200)
	private String nombre;

	@Column(name="telefono",length=10)
	private String telefono;

	@Column(name="titulo",length=200)
	private String titulo;
	
	@OneToMany(mappedBy = "monitor")
	private List<Clase> clases;
	
	@Column(name="clave")
	private String clave;
	public Monitor() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getExperiencia() {
		return this.experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	

	
}
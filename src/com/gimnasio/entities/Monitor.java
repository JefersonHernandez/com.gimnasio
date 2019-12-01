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

	private String clave;

	private String experiencia;

	private String nombre;

	private String telefono;

	private String titulo;

	//bi-directional many-to-one association to Clase
	@OneToMany(mappedBy="monitorBean", cascade = CascadeType.ALL)
	private List<Clase> clases;

	public Monitor() {
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
		return this.clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public Clase addClas(Clase clas) {
		getClases().add(clas);
		clas.setMonitor(this);

		return clas;
	}

	public Clase removeClas(Clase clas) {
		getClases().remove(clas);
		clas.setMonitor(null);

		return clas;
	}

}
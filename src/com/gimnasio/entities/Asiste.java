package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ASISTE database table.
 * 
 */
@Entity
@Table(name="ASISTE")
@NamedQuery(name="Asiste.findAll", query="SELECT a FROM Asiste a")
public class Asiste implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AsistePK id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="codigo_clase", insertable=false, updatable=false)
	private Clase clase;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name ="numero_socio", insertable=false, updatable=false)
	private Socio socio;

	public Asiste() {
	}

	public AsistePK getId() {
		return id;
	}

	public void setId(AsistePK id) {
		this.id = id;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Clase getClase1() {
		return clase;
	}

	public void setClase1(Clase clase1) {
		this.clase = clase1;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
}
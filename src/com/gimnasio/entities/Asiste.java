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

	public Asiste() {
	}

	public AsistePK getId() {
		return this.id;
	}

	public void setId(AsistePK id) {
		this.id = id;
	}

}
package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ASISTE database table.
 * 
 */
@Embeddable
public class AsistePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="fk_clase", insertable=false, updatable=false)
	private int fkClase;

	@Column(name="fk_socio", insertable=false, updatable=false)
	private int fkSocio;

	public AsistePK() {
	}
	public int getFkClase() {
		return this.fkClase;
	}
	public void setFkClase(int fkClase) {
		this.fkClase = fkClase;
	}
	public int getFkSocio() {
		return this.fkSocio;
	}
	public void setFkSocio(int fkSocio) {
		this.fkSocio = fkSocio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AsistePK)) {
			return false;
		}
		AsistePK castOther = (AsistePK)other;
		return 
			(this.fkClase == castOther.fkClase)
			&& (this.fkSocio == castOther.fkSocio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fkClase;
		hash = hash * prime + this.fkSocio;
		
		return hash;
	}
	@Override
	public String toString() {
		return "AsistePK [fkClase=" + fkClase + ", fkSocio=" + fkSocio + "]";
	}
}
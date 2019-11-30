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

	@Column(name="numero_socio", insertable=false, updatable=false)
	private int numeroSocio;

	@Column(name="codigo_clase", insertable=false, updatable=false)
	private int codigoClase;

	public AsistePK() {
	}
	
	 public int getNumeroSocio() {
		return this.numeroSocio;
	}
	public void setNumeroSocio(int numeroSocio) {
		this.numeroSocio = numeroSocio;
	}
	public int getCodigoClase() {
		return this.codigoClase;
	}
	public void setCodigoClase(int codigoClase) {
		this.codigoClase = codigoClase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoClase;
		result = prime * result + numeroSocio;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsistePK other = (AsistePK) obj;
		if (codigoClase != other.codigoClase)
			return false;
		if (numeroSocio != other.numeroSocio)
			return false;
		return true;
	}



}
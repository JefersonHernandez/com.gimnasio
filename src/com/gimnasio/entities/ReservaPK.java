package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESERVA database table.
 * 
 */
@Embeddable
public class ReservaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="numero_pista", insertable=false, updatable=false)
	private int numeroPista;

	@Column(name="numero_socio", insertable=false, updatable=false)
	private int numeroSocio;

	public ReservaPK() {
	}
	public int getNumeroPista() {
		return this.numeroPista;
	}
	public void setNumeroPista(int numeroPista) {
		this.numeroPista = numeroPista;
	}
	public int getNumeroSocio() {
		return this.numeroSocio;
	}
	public void setNumeroSocio(int numeroSocio) {
		this.numeroSocio = numeroSocio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReservaPK)) {
			return false;
		}
		ReservaPK castOther = (ReservaPK)other;
		return 
			(this.numeroPista == castOther.numeroPista)
			&& (this.numeroSocio == castOther.numeroSocio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numeroPista;
		hash = hash * prime + this.numeroSocio;
		
		return hash;
	}
}
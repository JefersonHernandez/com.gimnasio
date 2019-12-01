package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the RESERVA database table.
 * 
 */
@Entity
@Table(name="RESERVA")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReservaPK id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time hora;

	//bi-directional many-to-one association to PistaSquash
	@ManyToOne
	@JoinColumn(name="numero_pista",insertable=false, updatable=false)
	private PistaSquash pistaSquash;

	//bi-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="numero_socio",insertable=false, updatable=false)
	private Socio socio;

	public Reserva() {
	}

	public ReservaPK getId() {
		return this.id;
	}

	public void setId(ReservaPK id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public PistaSquash getPistaSquash() {
		return this.pistaSquash;
	}

	public void setPistaSquash(PistaSquash pistaSquash) {
		this.pistaSquash = pistaSquash;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}
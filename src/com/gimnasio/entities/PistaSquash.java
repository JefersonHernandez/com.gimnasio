package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PISTA_SQUASH database table.
 * 
 */
@Entity
@Table(name="PISTA_SQUASH")
@NamedQuery(name="PistaSquash.findAll", query="SELECT p FROM PistaSquash p")
public class PistaSquash implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;

	private String descripcion;

	//bi-directional many-to-one association to PistaEstado
	@ManyToOne
	@JoinColumn(name="pista_estado")
	private PistaEstado pistaEstadoBean;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="pistaSquash")
	private List<Reserva> reservas;

	public PistaSquash() {
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public PistaEstado getPistaEstadoBean() {
		return this.pistaEstadoBean;
	}

	public void setPistaEstadoBean(PistaEstado pistaEstadoBean) {
		this.pistaEstadoBean = pistaEstadoBean;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setPistaSquash(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setPistaSquash(null);

		return reserva;
	}

}
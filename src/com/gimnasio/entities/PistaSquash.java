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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numero;

	@Column(name="descripcion")
	private String descripcion;

	//bi-directional many-to-one association to PistaEstado
	@ManyToOne
	@JoinColumn(name="pista_estado")
	private PistaEstado pistaEstadoBean;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="pistaSquash",cascade=CascadeType.MERGE)
	private List<Reserva> reservas1;

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

	public List<Reserva> getReservas1() {
		return this.reservas1;
	}

	public void setReservas1(List<Reserva> reservas1) {
		this.reservas1 = reservas1;
	}

	public Reserva addReservas1(Reserva reservas1) {
		getReservas1().add(reservas1);
		reservas1.setPistaSquash1(this);

		return reservas1;
	}

	public Reserva removeReservas1(Reserva reservas1) {
		getReservas1().remove(reservas1);
		reservas1.setPistaSquash1(null);

		return reservas1;
	}

}
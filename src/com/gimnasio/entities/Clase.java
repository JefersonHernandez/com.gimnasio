package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CLASE database table.
 * 
 */
@Entity
@Table(name="CLASE")
@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	@Temporal(TemporalType.DATE)
	private Date dia;

	private Time hora;
	
	@ManyToOne
	@JoinColumn(name="descripcion_clase")
	private Preparacion descripcion;
	
	@ManyToOne
	@JoinColumn(name="monitor")
	private Monitor monitor;
	
	@ManyToOne
	@JoinColumn(name="sala")
	private Sala sala;
	
	@OneToMany(mappedBy = "clase", cascade = CascadeType.MERGE)
	private List<Asiste> asiste;

	public Clase() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Date getDia() {
		return this.dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Preparacion getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(Preparacion descripcion) {
		this.descripcion = descripcion;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Asiste> getAsiste() {
		return asiste;
	}

	public void setAsiste(List<Asiste> asiste) {
		this.asiste = asiste;
	}

 	public Asiste addAsiste(Asiste asiste) {
		getAsiste().add(asiste);
		asiste.setClase(this);

		return asiste;
	}

	public Asiste removeAsiste(Asiste asiste) {
		getAsiste().remove(asiste);
		asiste.setClase(null);

		return asiste;
	}
 
}
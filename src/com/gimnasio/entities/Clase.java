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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@Temporal(TemporalType.DATE)
	private Date dia;

	private Time hora;

	//bi-directional many-to-one association to Monitor
	@ManyToOne
	@JoinColumn(name="monitor")
	private Monitor monitorBean;

	//bi-directional many-to-one association to Preparacion
	@ManyToOne
	@JoinColumn(name="descripcion_clase")
	private Preparacion preparacion;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="sala")
	private Sala salaBean;

	//bi-directional many-to-many association to Socio
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
		name="ASISTE"
		, joinColumns={
			@JoinColumn(name="fk_clase")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fk_socio")
			}
		)
	private List<Socio> socios;

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

	public Monitor getMonitorBean() {
		return this.monitorBean;
	}

	public void setMonitor(Monitor monitorBean) {
		this.monitorBean = monitorBean;
	}

	public Preparacion getPreparacion() {
		return this.preparacion;
	}

	public void setPreparacion(Preparacion preparacion) {
		this.preparacion = preparacion;
	}

	public Sala getSalaBean() {
		return this.salaBean;
	}

	public void setSala(Sala salaBean) {
		this.salaBean = salaBean;
	}

	public List<Socio> getSocios() {
		return this.socios;
	}

	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}

}
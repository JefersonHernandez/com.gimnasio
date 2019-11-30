package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIPO_SALA database table.
 * 
 */
@Entity
@Table(name="TIPO_SALA")
@NamedQuery(name="TipoSala.findAll", query="SELECT t FROM TipoSala t")
public class TipoSala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	@Column(name="descripcion")
	private String descripcion;

	//bi-directional many-to-one association to Sala
	@OneToMany(mappedBy="tipoSalaBean")
	private List<Sala> salas;

	public TipoSala() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Sala> getSalas() {
		return this.salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public Sala addSala(Sala sala) {
		getSalas().add(sala);
		sala.setTipoSalaBean(this);

		return sala;
	}

	public Sala removeSala(Sala sala) {
		getSalas().remove(sala);
		sala.setTipoSalaBean(null);

		return sala;
	}

}
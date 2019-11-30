package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SALA database table.
 * 
 */
@Entity
@Table(name="SALA")
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numero;

	@Column(name="metros_cuadrados")
	private String metrosCuadrados;

	@Column(name="ubicacion",length=200)
	private String ubicacion;

	//bi-directional many-to-one association to Aparato
	@OneToMany(mappedBy="sala")
	private List<Aparato> aparatos;

	//bi-directional many-to-one association to TipoSala
	@ManyToOne
	@JoinColumn(name="tipo_sala")
	private TipoSala tipoSalaBean;
	
	@OneToMany(mappedBy = "sala")
	private List<Clase> clase;

	public Sala() {
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getMetrosCuadrados() {
		return this.metrosCuadrados;
	}

	public void setMetrosCuadrados(String metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Aparato> getAparatos() {
		return this.aparatos;
	}

	public void setAparatos(List<Aparato> aparatos) {
		this.aparatos = aparatos;
	}

	public Aparato addAparato(Aparato aparato) {
		getAparatos().add(aparato);
		aparato.setSala(this);

		return aparato;
	}

	public Aparato removeAparato(Aparato aparato) {
		getAparatos().remove(aparato);
		aparato.setSala(null);

		return aparato;
	}

	public TipoSala getTipoSalaBean() {
		return this.tipoSalaBean;
	}

	public void setTipoSalaBean(TipoSala tipoSalaBean) {
		this.tipoSalaBean = tipoSalaBean;
	}

	public List<Clase> getClase() {
		return clase;
	}

	public void setClase(List<Clase> clase) {
		this.clase = clase;
	}

}
package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="APARATO_ESTADO")
@NamedQuery(name="AparatoEstado.findAll", query="SELECT a FROM AparatoEstado a")
public class AparatoEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	@Column(name="descripcion", length=200)
	private String descripcion;

	//bi-directional many-to-one association to Aparato
	@OneToMany(mappedBy="aparatoEstado")
	private List<Aparato> aparatos;

	public AparatoEstado() {
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

	public List<Aparato> getAparatos() {
		return this.aparatos;
	}

	public void setAparatos(List<Aparato> aparatos) {
		this.aparatos = aparatos;
	}

	public Aparato addAparato(Aparato aparato) {
		getAparatos().add(aparato);
		aparato.setAparatoEstado(this);

		return aparato;
	}

	public Aparato removeAparato(Aparato aparato) {
		getAparatos().remove(aparato);
		aparato.setAparatoEstado(null);

		return aparato;
	}

}
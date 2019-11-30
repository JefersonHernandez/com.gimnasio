package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="APARATO")
@NamedQuery(name="Aparato.findAll", query="SELECT a FROM Aparato a")
public class Aparato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

	@Column(name="descripcion",length=200)
	private String descripcion;

	//bi-directional many-to-one association to AparatoEstado
	@ManyToOne
	@JoinColumn(name="estado_aparato")
	private AparatoEstado aparatoEstado;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="numero_sala")
	private Sala sala;

	public Aparato() {
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

	public AparatoEstado getAparatoEstado() {
		return this.aparatoEstado;
	}

	public void setAparatoEstado(AparatoEstado aparatoEstado) {
		this.aparatoEstado = aparatoEstado;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}
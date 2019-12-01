package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PISTA_ESTADO database table.
 * 
 */
@Entity
@Table(name="PISTA_ESTADO")
@NamedQuery(name="PistaEstado.findAll", query="SELECT p FROM PistaEstado p")
public class PistaEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	private String descripcion;

	//bi-directional many-to-one association to PistaSquash
	@OneToMany(mappedBy="pistaEstadoBean")
	private List<PistaSquash> pistaSquashs;

	public PistaEstado() {
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

	public List<PistaSquash> getPistaSquashs() {
		return this.pistaSquashs;
	}

	public void setPistaSquashs(List<PistaSquash> pistaSquashs) {
		this.pistaSquashs = pistaSquashs;
	}

	public PistaSquash addPistaSquash(PistaSquash pistaSquash) {
		getPistaSquashs().add(pistaSquash);
		pistaSquash.setPistaEstadoBean(this);

		return pistaSquash;
	}

	public PistaSquash removePistaSquash(PistaSquash pistaSquash) {
		getPistaSquashs().remove(pistaSquash);
		pistaSquash.setPistaEstadoBean(null);

		return pistaSquash;
	}

}
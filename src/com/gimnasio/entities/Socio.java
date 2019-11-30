package com.gimnasio.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SOCIO database table.
 * 
 */
@Entity
@Table(name="SOCIO")
@NamedQuery(name="Socio.findAll", query="SELECT s FROM Socio s")
public class Socio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numero;

	@Column(name="datos_bancarios")
	private String datosBancarios;

	private String direccion;

	private String nombre;

	private String profesion;

	private String telefono;
	
	@Column(name="clave")
	private String clave;

	@OneToMany(mappedBy="socio")
	private List<Reserva> reservas1;
	
	@OneToMany(mappedBy = "socio")
	private List<Asiste> asiste;

	public Socio() {
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDatosBancarios() {
		return this.datosBancarios;
	}

	public void setDatosBancarios(String datosBancarios) {
		this.datosBancarios = datosBancarios;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesion() {
		return this.profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Reserva> getReservas1() {
		return this.reservas1;
	}

	public void setReservas1(List<Reserva> reservas1) {
		this.reservas1 = reservas1;
	}

	public Reserva addReservas1(Reserva reservas1) {
		getReservas1().add(reservas1);
		reservas1.setSocio1(this);

		return reservas1;
	}

	public Reserva removeReservas1(Reserva reservas1) {
		getReservas1().remove(reservas1);
		reservas1.setSocio1(null);

		return reservas1;
	}

	public List<Asiste> getAsiste() {
		return asiste;
	}

	public void setAsiste(List<Asiste> asiste) {
		this.asiste = asiste;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	

}
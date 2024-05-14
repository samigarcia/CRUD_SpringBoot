package com.rsr.curso.estudiante.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// crear la tabla a la BD
@Table(name = "estudiante") // <== tabla de bd
public class Estudiante implements Serializable {
	// metodos por ser interface
	// campos a la BD
	private static final long serialVersionUID = 1l;
	@Id
	// generar su Id de forma automatica tipo serial
	// col|nombre|direc|tel| etc
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono")
	private Integer telefono;

	// constrcutor vacio
	public Estudiante() {

	}

	// constructor sobrecargado

	// getters y setters

	public Long getId() {
		return id;
	}

	public Estudiante(Long id, String nombre, String direccion, Integer telefono) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}

}

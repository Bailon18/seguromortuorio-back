package com.seguro.app.model.entidad;

import jakarta.persistence.*;

@Entity
public class Beneficiario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String apellido;
	private String documentoIdentidad;
	private double porcentajeHerencia;

	@ManyToOne
	@JoinColumn(name = "socio_id")
	private Socio socio;

	public Beneficiario() {

	}

	public Beneficiario(Long id, String nombre, String apellido, String documentoIdentidad, double porcentajeHerencia,
			Socio socio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documentoIdentidad = documentoIdentidad;
		this.porcentajeHerencia = porcentajeHerencia;
		this.socio = socio;
	}

	public Long getId() {
		return id;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	public double getPorcentajeHerencia() {
		return porcentajeHerencia;
	}

	public void setPorcentajeHerencia(double porcentajeHerencia) {
		this.porcentajeHerencia = porcentajeHerencia;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}
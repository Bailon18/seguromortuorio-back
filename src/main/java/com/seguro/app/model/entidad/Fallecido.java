package com.seguro.app.model.entidad;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Fallecido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date fechaFallecimiento;

	@ManyToOne
	@JoinColumn(name = "socio_id")
	private Socio socio;

	public Fallecido() {
		super();
	}

	public Fallecido(Long id, Date fechaFallecimiento, Socio socio) {
		super();
		this.id = id;
		this.fechaFallecimiento = fechaFallecimiento;
		this.socio = socio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaFallecimiento() {
		return fechaFallecimiento;
	}

	public void setFechaFallecimiento(Date fechaFallecimiento) {
		this.fechaFallecimiento = fechaFallecimiento;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}
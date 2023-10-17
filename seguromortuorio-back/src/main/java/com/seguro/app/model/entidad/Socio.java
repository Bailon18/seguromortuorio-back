package com.seguro.app.model.entidad;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Socio {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String documentoIdentidad;
    
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    private int edad;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String contrasena;
    
    private Date FechaInscripcion;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean activo;


    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Familiar> familiares;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Aportacion> aportaciones;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Fallecido> fallecidos;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Beneficiario> beneficiarios;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Documento> documentos;

	public Socio() {
		super();
	}

	public Socio(Long id, String nombre, String apellido, String documentoIdentidad, Date fechaNacimiento, int edad,
			String direccion, String telefono, String correoElectronico, String contrasena, Date fechaInscripcion,
			boolean activo, List<Familiar> familiares, List<Aportacion> aportaciones, List<Fallecido> fallecidos,
			List<Beneficiario> beneficiarios, List<Documento> documentos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documentoIdentidad = documentoIdentidad;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.contrasena = contrasena;
		FechaInscripcion = fechaInscripcion;
		this.activo = activo;
		this.familiares = familiares;
		this.aportaciones = aportaciones;
		this.fallecidos = fallecidos;
		this.beneficiarios = beneficiarios;
		this.documentos = documentos;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaInscripcion() {
		return FechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		FechaInscripcion = fechaInscripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<Familiar> getFamiliares() {
		return familiares;
	}

	public void setFamiliares(List<Familiar> familiares) {
		this.familiares = familiares;
	}

	public List<Aportacion> getAportaciones() {
		return aportaciones;
	}

	public void setAportaciones(List<Aportacion> aportaciones) {
		this.aportaciones = aportaciones;
	}

	public List<Fallecido> getFallecidos() {
		return fallecidos;
	}

	public void setFallecidos(List<Fallecido> fallecidos) {
		this.fallecidos = fallecidos;
	}

	public List<Beneficiario> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(List<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	

    
}
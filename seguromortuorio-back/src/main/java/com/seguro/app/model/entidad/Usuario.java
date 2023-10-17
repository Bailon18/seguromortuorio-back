package com.seguro.app.model.entidad;

import jakarta.persistence.*;
import java.util.List;

import com.seguro.app.util.TipoUsuario;

@Entity
public class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombreUsuario;
    private String correoElectronico;
    private String contrasena;
    
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "tesorero")
    private List<Aportacion> aportacionesTesorero;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombreUsuario, String correoElectronico, String contrasena, TipoUsuario tipoUsuario,
			List<Aportacion> aportacionesTesorero) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.correoElectronico = correoElectronico;
		this.contrasena = contrasena;
		this.tipoUsuario = tipoUsuario;
		this.aportacionesTesorero = aportacionesTesorero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Aportacion> getAportacionesTesorero() {
		return aportacionesTesorero;
	}

	public void setAportacionesTesorero(List<Aportacion> aportacionesTesorero) {
		this.aportacionesTesorero = aportacionesTesorero;
	}

    
}

package com.seguro.app.model.entidad;

import com.seguro.app.util.ENUM.TipoDocumento;

import jakarta.persistence.*;

@Entity
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Efectivo', 'Transferencia Bancaria', 'Otros') DEFAULT 'Efectivo'")
	private TipoDocumento tipoDocumento;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] archivo;

	@ManyToOne
	@JoinColumn(name = "socio_id")
	private Socio socio;

	@ManyToOne
	@JoinColumn(name = "familiar_id")
	private Familiar familiar;

	public Documento() {
		super();
	}

	public Documento(Long id, TipoDocumento tipoDocumento, byte[] archivo, Socio socio, Familiar familiar) {
		super();
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.archivo = archivo;
		this.socio = socio;
		this.familiar = familiar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Familiar getFamiliar() {
		return familiar;
	}

	public void setFamiliar(Familiar familiar) {
		this.familiar = familiar;
	}

}
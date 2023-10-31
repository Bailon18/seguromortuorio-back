package com.seguro.app.model.entidad;

import java.time.LocalDateTime;

import com.seguro.app.util.ENUM.MetodoPago;
import com.seguro.app.util.ENUM.TipoPago;

import jakarta.persistence.*;

@Entity
public class Aportacion {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaAportacion;
    
    private double monto;
    private double cuotas;
    private double cuotasFinados;
    private double otrasAportaciones;
    
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Efectivo', 'Transferencia Bancaria', 'Otros') DEFAULT 'Efectivo'")
    private MetodoPago metodoPago;
    
    private String numeroTransaccion;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('PENDIENTE', 'PAGADA', 'RETRASADA') DEFAULT 'PENDIENTE'")
    private TipoPago estadoPago;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "tesorero_id")
    private Usuario tesorero;

	public Aportacion() {
		super();
	}

	public Aportacion(Long id, LocalDateTime fechaAportacion, double monto, double cuotas, double cuotasFinados,
			double otrasAportaciones, String descripcion, MetodoPago metodoPago, String numeroTransaccion,
			TipoPago estadoPago, Socio socio, Usuario tesorero) {
		super();
		this.id = id;
		this.fechaAportacion = fechaAportacion;
		this.monto = monto;
		this.cuotas = cuotas;
		this.cuotasFinados = cuotasFinados;
		this.otrasAportaciones = otrasAportaciones;
		this.descripcion = descripcion;
		this.metodoPago = metodoPago;
		this.numeroTransaccion = numeroTransaccion;
		this.estadoPago = estadoPago;
		this.socio = socio;
		this.tesorero = tesorero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaAportacion() {
		return fechaAportacion;
	}

	public void setFechaAportacion(LocalDateTime fechaAportacion) {
		this.fechaAportacion = fechaAportacion;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double isCuotas() {
		return cuotas;
	}

	public void setCuotas(double cuotas) {
		this.cuotas = cuotas;
	}

	public double isCuotasFinados() {
		return cuotasFinados;
	}

	public void setCuotasFinados(double cuotasFinados) {
		this.cuotasFinados = cuotasFinados;
	}

	public double isOtrasAportaciones() {
		return otrasAportaciones;
	}

	public void setOtrasAportaciones(double otrasAportaciones) {
		this.otrasAportaciones = otrasAportaciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getNumeroTransaccion() {
		return numeroTransaccion;
	}

	public void setNumeroTransaccion(String numeroTransaccion) {
		this.numeroTransaccion = numeroTransaccion;
	}

	public TipoPago getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(TipoPago estadoPago) {
		this.estadoPago = estadoPago;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Usuario getTesorero() {
		return tesorero;
	}

	public void setTesorero(Usuario tesorero) {
		this.tesorero = tesorero;
	}

    
}

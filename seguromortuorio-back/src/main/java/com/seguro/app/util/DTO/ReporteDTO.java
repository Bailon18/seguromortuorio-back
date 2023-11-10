package com.seguro.app.util.DTO;

public class ReporteDTO {

    private double ingresosTotalesMensuales;
    private double ingresosTotalesAnuales;
    private long totalAportacionesRealizadas;
    private long numeroSociosActivosTotales;

    public ReporteDTO() {
    }

    public ReporteDTO(double ingresosTotalesMensuales, double ingresosTotalesAnuales, long totalAportacionesRealizadas,
            long numeroSociosActivosTotales) {
        this.ingresosTotalesMensuales = ingresosTotalesMensuales;
        this.ingresosTotalesAnuales = ingresosTotalesAnuales;
        this.totalAportacionesRealizadas = totalAportacionesRealizadas;
        this.numeroSociosActivosTotales = numeroSociosActivosTotales;
    }

    public double getIngresosTotalesMensuales() {
        return ingresosTotalesMensuales;
    }

    public void setIngresosTotalesMensuales(double ingresosTotalesMensuales) {
        this.ingresosTotalesMensuales = ingresosTotalesMensuales;
    }

    public double getIngresosTotalesAnuales() {
        return ingresosTotalesAnuales;
    }

    public void setIngresosTotalesAnuales(double ingresosTotalesAnuales) {
        this.ingresosTotalesAnuales = ingresosTotalesAnuales;
    }

    public long getTotalAportacionesRealizadas() {
        return totalAportacionesRealizadas;
    }

    public void setTotalAportacionesRealizadas(long totalAportacionesRealizadas) {
        this.totalAportacionesRealizadas = totalAportacionesRealizadas;
    }

    public long getNumeroSociosActivosTotales() {
        return numeroSociosActivosTotales;
    }

    public void setNumeroSociosActivosTotales(long numeroSociosActivosTotales) {
        this.numeroSociosActivosTotales = numeroSociosActivosTotales;
    }

}

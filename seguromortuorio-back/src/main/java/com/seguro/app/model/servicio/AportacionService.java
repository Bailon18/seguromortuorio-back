package com.seguro.app.model.servicio;

import java.util.List;
import java.util.Optional;

import com.seguro.app.model.entidad.Aportacion;

public interface AportacionService {

    List<Aportacion> findAllAportaciones();

    Optional<Aportacion> findAportacionById(Long aportacionId);

    Aportacion saveAportacion(Aportacion aportacion);

    void deleteAportacion(Long aportacionId);

    Aportacion updateAportacion(Long aportacionId, Aportacion updatedAportacion);
    
    List<Integer> findDistinctYearsBySocioId(Long socioId);
    List<Aportacion> getAportacionesPorAnioYIdSocio(Integer year, Long socioId);

	double obtenerIngresosTotalesMensuales();

	double obtenerIngresosTotalesAnuales();

	long obtenerTotalAportacionesRealizadas();
}

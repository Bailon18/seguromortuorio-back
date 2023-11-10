package com.seguro.app.model.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.seguro.app.model.entidad.Aportacion;

public interface AportacionRepository extends JpaRepository<Aportacion, Long> {

	@Query(value = "SELECT DISTINCT EXTRACT(YEAR FROM a.fecha_aportacion) FROM aportacion a WHERE a.socio_id = :socioId", nativeQuery = true)
	List<Integer> findDistinctYearsBySocioId(@Param("socioId") Long socioId);

	@Query("SELECT a FROM Aportacion a WHERE YEAR(a.fechaAportacion) = :year AND a.socio.id = :socioId")
	List<Aportacion> findAportacionesByYearAndSocioId(@Param("year") Integer year, @Param("socioId") Long socioId);

	// INGRESOS TOTALES MENSUALES (fecha actual)
	@Query(value = "SELECT COALESCE(SUM(a.cuotas + a.cuotas_finados + a.otras_aportaciones), 0) FROM aportacion a WHERE MONTH(a.fecha_aportacion) = MONTH(CURRENT_DATE)", nativeQuery = true)
	double getIngresosTotalesMensuales();

	// INGRESOS TOTALES ANUALES (año actual)
	@Query(value = "SELECT COALESCE(SUM(a.cuotas + a.cuotas_finados + a.otras_aportaciones), 0) FROM aportacion a WHERE YEAR(a.fecha_aportacion) = YEAR(CURRENT_DATE)", nativeQuery = true)
	double getIngresosTotalesAnuales();

	// TOTAL DE APORTACIONES REALIZADAS (totales)
	@Query(value ="SELECT COUNT(*) FROM aportacion", nativeQuery = true)
	long getTotalAportacionesRealizadas();
}

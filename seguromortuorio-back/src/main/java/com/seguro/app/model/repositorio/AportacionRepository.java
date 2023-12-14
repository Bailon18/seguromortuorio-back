package com.seguro.app.model.repositorio;

import java.time.LocalDate;
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


	@Query(value = "SELECT todos_meses.mes, COALESCE(SUM(aportacion.cuotas + aportacion.cuotas_finados + aportacion.otras_aportaciones), 0) as monto " +
               "FROM (SELECT 1 as mes UNION SELECT 2 as mes UNION SELECT 3 as mes UNION SELECT 4 as mes " +
               "      UNION SELECT 5 as mes UNION SELECT 6 as mes UNION SELECT 7 as mes UNION SELECT 8 as mes " +
               "      UNION SELECT 9 as mes UNION SELECT 10 as mes UNION SELECT 11 as mes UNION SELECT 12 as mes) todos_meses " +
               "LEFT JOIN aportacion ON MONTH(aportacion.fecha_aportacion) = todos_meses.mes " +
               "                 AND YEAR(aportacion.fecha_aportacion) = YEAR(CURRENT_DATE) " +
               "GROUP BY todos_meses.mes " +
               "ORDER BY todos_meses.mes", nativeQuery = true)
	List<Object[]> obtenerMontosPorMes();
	
    @Query(value = "SELECT * FROM aportacion WHERE socio_id = :socioId AND DATE(fecha_aportacion) BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Aportacion> findAportacionesBySocioAndDateRange(
        @Param("socioId") Long socioId,
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );
}

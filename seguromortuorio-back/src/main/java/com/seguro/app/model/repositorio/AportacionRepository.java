package com.seguro.app.model.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.seguro.app.model.entidad.Aportacion;

public interface AportacionRepository extends JpaRepository<Aportacion, Long> {
	
	@Query(
	        value = "SELECT DISTINCT EXTRACT(YEAR FROM a.fecha_aportacion) FROM aportacion a WHERE a.socio_id = :socioId",
	        nativeQuery = true
	    )
	List<Integer> findDistinctYearsBySocioId(@Param("socioId") Long socioId);
	
	@Query("SELECT a FROM Aportacion a WHERE YEAR(a.fechaAportacion) = :year AND a.socio.id = :socioId")
	List<Aportacion> findAportacionesByYearAndSocioId(@Param("year") Integer year, @Param("socioId") Long socioId);
}

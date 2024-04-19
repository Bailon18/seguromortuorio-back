package com.seguro.app.model.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.seguro.app.model.entidad.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long> {
	
    boolean existsByCorreoElectronico(String correoElectronico);
    boolean existsByDocumentoIdentidad(String documentoIdentidad);
    
    @Query(value = "SELECT * FROM socio WHERE nombre LIKE %:filtro% OR apellido LIKE %:filtro% OR documento_identidad LIKE %:filtro%", nativeQuery = true)
    List<Socio> buscarSocioPorFiltro(@Param("filtro") String filtro);

    // NÚMERO DE SOCIOS ACTIVOS (totales)
    @Query(value = "SELECT COUNT(*) FROM socio", nativeQuery = true)
    long getNumeroSociosActivosTotales();
}

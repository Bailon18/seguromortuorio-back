package com.seguro.app.model.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seguro.app.model.entidad.Familiar;

public interface FamiliarRepository extends JpaRepository<Familiar, Long> {
  
	List<Familiar> findBySocioId(Long socioId);
	boolean existsByDocumentoIdentidad(String documentoIdentidad);
}

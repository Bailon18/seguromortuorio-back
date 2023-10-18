package com.seguro.app.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seguro.app.model.entidad.Familiar;

public interface FamiliarRepository extends JpaRepository<Familiar, Long> {
  
}

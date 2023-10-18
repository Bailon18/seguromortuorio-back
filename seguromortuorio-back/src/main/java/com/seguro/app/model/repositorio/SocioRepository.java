package com.seguro.app.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seguro.app.model.entidad.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long> {
}

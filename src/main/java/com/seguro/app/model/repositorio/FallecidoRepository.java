package com.seguro.app.model.repositorio;

import com.seguro.app.model.entidad.Fallecido;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FallecidoRepository extends JpaRepository<Fallecido, Long> {
}

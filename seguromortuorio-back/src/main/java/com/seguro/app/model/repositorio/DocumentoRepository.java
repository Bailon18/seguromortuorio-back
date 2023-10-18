package com.seguro.app.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seguro.app.model.entidad.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
   
}

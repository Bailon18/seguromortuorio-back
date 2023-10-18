package com.seguro.app.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seguro.app.model.entidad.Aportacion;

public interface AportacionRepository extends JpaRepository<Aportacion, Long> {
 
}

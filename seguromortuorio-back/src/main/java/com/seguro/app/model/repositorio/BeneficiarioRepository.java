package com.seguro.app.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seguro.app.model.entidad.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}

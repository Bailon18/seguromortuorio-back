package com.seguro.app.model.servicio;

import com.seguro.app.model.entidad.Beneficiario;

import java.util.List;
import java.util.Optional;

public interface BeneficiarioService {
    List<Beneficiario> findAllBeneficiarios();
    Optional<Beneficiario> findBeneficiarioById(Long beneficiarioId);
    Beneficiario saveBeneficiario(Beneficiario beneficiario);
    void deleteBeneficiario(Long beneficiarioId);
    Beneficiario updateBeneficiario(Long beneficiarioId, Beneficiario updatedBeneficiario);
}

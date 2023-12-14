package com.seguro.app.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.seguro.app.model.entidad.Beneficiario;
import com.seguro.app.model.repositorio.BeneficiarioRepository;
import com.seguro.app.model.servicio.BeneficiarioService;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Override
    public List<Beneficiario> findAllBeneficiarios() {
        return beneficiarioRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<Beneficiario> findBeneficiarioById(Long beneficiarioId) {
        return beneficiarioRepository.findById(beneficiarioId);
    }

    @Override
    public Beneficiario saveBeneficiario(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    @Override
    public void deleteBeneficiario(Long beneficiarioId) {
        beneficiarioRepository.deleteById(beneficiarioId);
    }

    @Override
    public Beneficiario updateBeneficiario(Long beneficiarioId, Beneficiario updatedBeneficiario) {
        Optional<Beneficiario> existingBeneficiario = beneficiarioRepository.findById(beneficiarioId);
    
        if (existingBeneficiario.isPresent()) {
            Beneficiario beneficiario = existingBeneficiario.get();
            // Actualizar todos los campos del objeto Beneficiario con los valores de updatedBeneficiario
            beneficiario.setNombre(updatedBeneficiario.getNombre());
            beneficiario.setApellido(updatedBeneficiario.getApellido());
            beneficiario.setDocumentoIdentidad(updatedBeneficiario.getDocumentoIdentidad());
            beneficiario.setPorcentajeHerencia(updatedBeneficiario.getPorcentajeHerencia());
            beneficiario.setSocio(updatedBeneficiario.getSocio()); 
          
            return beneficiarioRepository.save(beneficiario);
        } 
        return null;
    }
    
    
    
}

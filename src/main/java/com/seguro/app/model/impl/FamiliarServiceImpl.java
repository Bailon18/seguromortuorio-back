package com.seguro.app.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.seguro.app.model.entidad.Familiar;
import com.seguro.app.model.repositorio.FamiliarRepository;
import com.seguro.app.model.servicio.FamiliarService;

import java.util.List;
import java.util.Optional;

@Service
public class FamiliarServiceImpl implements FamiliarService {

    @Autowired
    private FamiliarRepository familiarRepository;

    @Override
    public List<Familiar> findAllFamiliares() {
        return familiarRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<Familiar> findFamiliarById(Long familiarId) {
        return familiarRepository.findById(familiarId);
    }

    @Override
    public Familiar saveFamiliar(Familiar familiar) {
        return familiarRepository.save(familiar);
    }

    @Override
    public void deleteFamiliar(Long familiarId) {
        familiarRepository.deleteById(familiarId);
    }

    @Override
    public Familiar updateFamiliar(Familiar updatedFamiliar) {
    	
        Familiar existingFamiliar = familiarRepository.findById(updatedFamiliar.getId()).orElse(null);
       
        if (existingFamiliar != null ) {
        	
        	existingFamiliar.setNombre(updatedFamiliar.getNombre());
        	existingFamiliar.setApellido(updatedFamiliar.getApellido());
        	existingFamiliar.setDocumentoIdentidad(updatedFamiliar.getDocumentoIdentidad());
        	existingFamiliar.setTipoParentesco(updatedFamiliar.getTipoParentesco());
        	existingFamiliar.setFechaNacimiento(updatedFamiliar.getFechaNacimiento());
        	existingFamiliar.setEdad(updatedFamiliar.getEdad());
        	existingFamiliar.setDireccion(updatedFamiliar.getDireccion());
        	existingFamiliar.setTelefono(updatedFamiliar.getTelefono());
        	existingFamiliar.setSocio(updatedFamiliar.getSocio());

            return familiarRepository.save(existingFamiliar);
        } 
        return null;
    }
    
    @Override
    public List<Familiar> obtenerFamiliaresPorSocioId(Long socioId) {
        return familiarRepository.findBySocioId(socioId);
    }
    
    @Override
    public boolean existsByDocumentoIdentidad(String documentoIdentidad) {
        return familiarRepository.existsByDocumentoIdentidad(documentoIdentidad);
    }

}

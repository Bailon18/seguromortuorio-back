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
    public Familiar updateFamiliar(Long familiarId, Familiar updatedFamiliar) {
        Optional<Familiar> existingFamiliar = familiarRepository.findById(familiarId);

        if (existingFamiliar.isPresent()) {
        	
            Familiar familiar = existingFamiliar.get();
            
            // Actualiza todos los campos del objeto Familiar con los valores de updatedFamiliar
            familiar.setNombre(updatedFamiliar.getNombre());
            familiar.setApellido(updatedFamiliar.getApellido());
            familiar.setDocumentoIdentidad(updatedFamiliar.getDocumentoIdentidad());
            familiar.setTipoParentesco(updatedFamiliar.getTipoParentesco());
            familiar.setFechaNacimiento(updatedFamiliar.getFechaNacimiento());
            familiar.setEdad(updatedFamiliar.getEdad());
            familiar.setDireccion(updatedFamiliar.getDireccion());
            familiar.setTelefono(updatedFamiliar.getTelefono());
            familiar.setSocio(updatedFamiliar.getSocio());

            return familiarRepository.save(familiar);
        } 
        return null;
    }
    
    @Override
    public List<Familiar> obtenerFamiliaresPorSocioId(Long socioId) {
        return familiarRepository.findBySocioId(socioId);
    }

}

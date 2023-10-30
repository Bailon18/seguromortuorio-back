package com.seguro.app.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.seguro.app.model.entidad.Socio;
import com.seguro.app.model.repositorio.SocioRepository;
import com.seguro.app.model.servicio.SocioService;

import java.util.List;
import java.util.Optional;

@Service
public class SocioServiceImpl implements SocioService {

    @Autowired
    private SocioRepository socioRepository;

    @Override
    public List<Socio> findAllSocios() {
        return socioRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<Socio> findSocioById(Long socioId) {
        return socioRepository.findById(socioId);
    }

    @Override
    public Socio saveSocio(Socio socio) {
        return socioRepository.save(socio);
    }

    @Override
    public void deleteSocio(Long socioId) {
        socioRepository.deleteById(socioId);
    }

    @Override
    public Socio updateSocio(Socio updatedSocio) {
        Socio existingSocio = socioRepository.findById(updatedSocio.getId()).orElse(null);

        if (existingSocio != null) {
   
        	existingSocio.setNombre(updatedSocio.getNombre());
        	existingSocio.setApellido(updatedSocio.getApellido());
        	existingSocio.setDocumentoIdentidad(updatedSocio.getDocumentoIdentidad());
        	existingSocio.setFechaNacimiento(updatedSocio.getFechaNacimiento());
        	existingSocio.setEdad(updatedSocio.getEdad());
        	existingSocio.setDireccion(updatedSocio.getDireccion());
        	existingSocio.setTelefono(updatedSocio.getTelefono());
        	existingSocio.setCorreoElectronico(updatedSocio.getCorreoElectronico());
        	existingSocio.setContrasena(updatedSocio.getContrasena());
        	existingSocio.setFechaInscripcion(updatedSocio.getFechaInscripcion());
        	existingSocio.setActivo(updatedSocio.isActivo());

            return socioRepository.save(existingSocio);
        } return null;
    }
    
    @Override
    public boolean existsByCorreoElectronico(String correoElectronico) {
        return socioRepository.existsByCorreoElectronico(correoElectronico);
    }

    @Override
    public boolean existsByDocumentoIdentidad(String documentoIdentidad) {
        return socioRepository.existsByDocumentoIdentidad(documentoIdentidad);
    }
}

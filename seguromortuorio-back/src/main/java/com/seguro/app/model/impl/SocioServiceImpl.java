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
    public Socio updateSocio(Long socioId, Socio updatedSocio) {
        Optional<Socio> existingSocio = socioRepository.findById(socioId);

        if (existingSocio.isPresent()) {
            Socio socio = existingSocio.get();
            // Actualiza los campos del objeto Socio con los valores de updatedSocio
            socio.setNombre(updatedSocio.getNombre());
            socio.setApellido(updatedSocio.getApellido());
            socio.setDocumentoIdentidad(updatedSocio.getDocumentoIdentidad());
            socio.setFechaNacimiento(updatedSocio.getFechaNacimiento());
            socio.setEdad(updatedSocio.getEdad());
            socio.setDireccion(updatedSocio.getDireccion());
            socio.setTelefono(updatedSocio.getTelefono());
            socio.setCorreoElectronico(updatedSocio.getCorreoElectronico());
            socio.setContrasena(updatedSocio.getContrasena());
            socio.setFechaInscripcion(updatedSocio.getFechaInscripcion());
            socio.setActivo(updatedSocio.isActivo());

            // Actualiza la lista de familiares, aportaciones, fallecidos, beneficiarios, documentos según sea necesario.

            return socioRepository.save(socio);
        } return null;
    }
}

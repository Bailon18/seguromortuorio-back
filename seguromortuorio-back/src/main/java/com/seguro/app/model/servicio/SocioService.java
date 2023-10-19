package com.seguro.app.model.servicio;

import com.seguro.app.model.entidad.Socio;

import java.util.List;
import java.util.Optional;

public interface SocioService {
	
    List<Socio> findAllSocios();
    Optional<Socio> findSocioById(Long socioId);
    Socio saveSocio(Socio socio);
    void deleteSocio(Long socioId);
    Socio updateSocio(Long socioId, Socio updatedSocio);
}
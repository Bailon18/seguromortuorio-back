package com.seguro.app.model.servicio;

import com.seguro.app.model.entidad.Socio;

import java.util.List;
import java.util.Optional;


public interface SocioService {
	
    List<Socio> findAllSocios();
    Optional<Socio> findSocioById(Long socioId);
    Socio saveSocio(Socio socio);
    void deleteSocio(Long socioId);
    Socio updateSocio(Socio updatedSocio);
    boolean existsByCorreoElectronico(String correoElectronico);
    boolean existsByDocumentoIdentidad(String documentoIdentidad);
    List<Socio> buscarSocioFiltro(String filtro);
    long obtenerNumeroSociosActivosTotales();
    
}

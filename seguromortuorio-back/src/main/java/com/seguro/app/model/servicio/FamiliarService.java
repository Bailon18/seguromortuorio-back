package com.seguro.app.model.servicio;

import com.seguro.app.model.entidad.Familiar;
import java.util.List;
import java.util.Optional;

public interface FamiliarService {
    List<Familiar> findAllFamiliares();
    Optional<Familiar> findFamiliarById(Long familiarId);
    Familiar saveFamiliar(Familiar familiar);
    void deleteFamiliar(Long familiarId);
    Familiar updateFamiliar(Familiar updatedFamiliar);
    
    List<Familiar> obtenerFamiliaresPorSocioId(Long socioId);
    boolean existsByDocumentoIdentidad(String documentoIdentidad);
}

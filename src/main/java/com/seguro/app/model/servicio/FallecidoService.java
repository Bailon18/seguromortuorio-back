package com.seguro.app.model.servicio;

import com.seguro.app.model.entidad.Fallecido;
import java.util.List;
import java.util.Optional;

public interface FallecidoService {
	
    List<Fallecido> findAllFallecidos();
    Optional<Fallecido> findFallecidoById(Long fallecidoId);
    Fallecido saveFallecido(Fallecido fallecido);
    void deleteFallecido(Long fallecidoId);
    Fallecido updateFallecido(Long fallecidoId, Fallecido updatedFallecido);
}

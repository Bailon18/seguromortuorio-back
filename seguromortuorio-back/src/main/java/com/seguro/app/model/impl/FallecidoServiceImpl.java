package com.seguro.app.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.seguro.app.model.entidad.Fallecido;
import com.seguro.app.model.repositorio.FallecidoRepository;
import com.seguro.app.model.servicio.FallecidoService;

import java.util.List;
import java.util.Optional;

@Service
public class FallecidoServiceImpl implements FallecidoService {

    @Autowired
    private FallecidoRepository fallecidoRepository;

    @Override
    public List<Fallecido> findAllFallecidos() {
        return fallecidoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<Fallecido> findFallecidoById(Long fallecidoId) {
        return fallecidoRepository.findById(fallecidoId);
    }

    @Override
    public Fallecido saveFallecido(Fallecido fallecido) {
        return fallecidoRepository.save(fallecido);
    }

    @Override
    public void deleteFallecido(Long fallecidoId) {
        fallecidoRepository.deleteById(fallecidoId);
    }

    @Override
    public Fallecido updateFallecido(Long fallecidoId, Fallecido updatedFallecido) {
        Optional<Fallecido> existingFallecido = fallecidoRepository.findById(fallecidoId);

        if (existingFallecido.isPresent()) {
            Fallecido fallecido = existingFallecido.get();
            // Actualiza los campos del objeto Fallecido con los valores de updatedFallecido
            fallecido.setFechaFallecimiento(updatedFallecido.getFechaFallecimiento());
            fallecido.setSocio(updatedFallecido.getSocio());

            return fallecidoRepository.save(fallecido);
        } 
        return null;
    }
}

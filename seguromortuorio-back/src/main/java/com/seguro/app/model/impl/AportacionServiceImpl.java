package com.seguro.app.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.seguro.app.model.entidad.Aportacion;
import com.seguro.app.model.repositorio.AportacionRepository;
import com.seguro.app.model.servicio.AportacionService;
import java.util.List;
import java.util.Optional;

@Service
public class AportacionServiceImpl implements AportacionService {

    @Autowired
    private AportacionRepository aportacionRepository;

    @Override
    public List<Aportacion> findAllAportaciones() {
        return aportacionRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<Aportacion> findAportacionById(Long aportacionId) {
        return aportacionRepository.findById(aportacionId);
    }

    @Override
    public Aportacion saveAportacion(Aportacion aportacion) {
        return aportacionRepository.save(aportacion);
    }

    @Override
    public void deleteAportacion(Long aportacionId) {
        aportacionRepository.deleteById(aportacionId);
    }

    @Override
    public Aportacion updateAportacion(Long aportacionId, Aportacion updatedAportacion) {
        Optional<Aportacion> existingAportacion = aportacionRepository.findById(aportacionId);

        if (existingAportacion.isPresent()) {
            Aportacion aportacion = existingAportacion.get();
            
            aportacion.setFechaAportacion(updatedAportacion.getFechaAportacion());
            //aportacion.setMonto(updatedAportacion.getMonto());
            aportacion.setCuotas(updatedAportacion.isCuotas());
            aportacion.setCuotasFinados(updatedAportacion.isCuotasFinados());
            aportacion.setOtrasAportaciones(updatedAportacion.isOtrasAportaciones());
            aportacion.setDescripcion(updatedAportacion.getDescripcion());
            aportacion.setMetodoPago(updatedAportacion.getMetodoPago());
            aportacion.setNumeroTransaccion(updatedAportacion.getNumeroTransaccion());
            aportacion.setEstadoPago(updatedAportacion.getEstadoPago());
            aportacion.setSocio(updatedAportacion.getSocio());
            aportacion.setTesorero(updatedAportacion.getTesorero());
            
            return aportacionRepository.save(aportacion);
        } 
        return null;
    }
}

package com.seguro.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.seguro.app.model.entidad.Aportacion;
import com.seguro.app.model.servicio.AportacionService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aportaciones")
public class AportacionController {

    @Autowired
    private AportacionService aportacionService;

    @GetMapping
    public ResponseEntity<List<Aportacion>> getAllAportaciones() {
        List<Aportacion> aportaciones = aportacionService.findAllAportaciones();
        if (aportaciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(aportaciones, HttpStatus.OK);
        }
    }

    @GetMapping("/{aportacionId}")
    public ResponseEntity<Optional<Aportacion>> getAportacionById(@PathVariable Long aportacionId) {
        Optional<Aportacion> aportacion = aportacionService.findAportacionById(aportacionId);
        if (aportacion.isPresent()) {
            return new ResponseEntity<>(aportacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Aportacion> createAportacion(@RequestBody Aportacion aportacion) {
        Aportacion nuevaAportacion = aportacionService.saveAportacion(aportacion);
        return new ResponseEntity<>(nuevaAportacion, HttpStatus.CREATED);
    }

    @DeleteMapping("/{aportacionId}")
    public ResponseEntity<Void> deleteAportacion(@PathVariable Long aportacionId) {
        aportacionService.deleteAportacion(aportacionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.seguro.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.seguro.app.model.entidad.Fallecido;
import com.seguro.app.model.servicio.FallecidoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fallecidos")
public class FallecidoController {

    @Autowired
    private FallecidoService fallecidoService;

    @GetMapping
    public ResponseEntity<List<Fallecido>> getAllFallecidos() {
        List<Fallecido> fallecidos = fallecidoService.findAllFallecidos();
        if (fallecidos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(fallecidos, HttpStatus.OK);
        }
    }

    @GetMapping("/{fallecidoId}")
    public ResponseEntity<Optional<Fallecido>> getFallecidoById(@PathVariable Long fallecidoId) {
        Optional<Fallecido> fallecido = fallecidoService.findFallecidoById(fallecidoId);
        if (fallecido.isPresent()) {
            return new ResponseEntity<>(fallecido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Fallecido> createFallecido(@RequestBody Fallecido fallecido) {
        Fallecido nuevoFallecido = fallecidoService.saveFallecido(fallecido);
        return new ResponseEntity<>(nuevoFallecido, HttpStatus.CREATED);
    }

    @DeleteMapping("/{fallecidoId}")
    public ResponseEntity<Void> deleteFallecido(@PathVariable Long fallecidoId) {
        fallecidoService.deleteFallecido(fallecidoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{fallecidoId}")
    public ResponseEntity<Fallecido> updateFallecido(@PathVariable Long fallecidoId, @RequestBody Fallecido updatedFallecido) {
        Fallecido fallecido = fallecidoService.updateFallecido(fallecidoId, updatedFallecido);
        return new ResponseEntity<>(fallecido, HttpStatus.OK);
    }
}

package com.seguro.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.seguro.app.model.entidad.Familiar;
import com.seguro.app.model.servicio.FamiliarService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/familiares")
public class FamiliarController {

    @Autowired
    private FamiliarService familiarService;

    @GetMapping
    public ResponseEntity<List<Familiar>> getAllFamiliares() {
        List<Familiar> familiares = familiarService.findAllFamiliares();
        if (familiares.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(familiares, HttpStatus.OK);
        }
    }

    @GetMapping("/{familiarId}")
    public ResponseEntity<Optional<Familiar>> getFamiliarById(@PathVariable Long familiarId) {
        Optional<Familiar> familiar = familiarService.findFamiliarById(familiarId);
        if (familiar.isPresent()) {
            return new ResponseEntity<>(familiar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Familiar> createFamiliar(@RequestBody Familiar familiar) {
        Familiar nuevoFamiliar = familiarService.saveFamiliar(familiar);
        return new ResponseEntity<>(nuevoFamiliar, HttpStatus.CREATED);
    }

    @DeleteMapping("/{familiarId}")
    public ResponseEntity<Void> deleteFamiliar(@PathVariable Long familiarId) {
        familiarService.deleteFamiliar(familiarId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{familiarId}")
    public ResponseEntity<Familiar> updateFamiliar(@PathVariable Long familiarId, @RequestBody Familiar updatedFamiliar) {
        Familiar familiar = familiarService.updateFamiliar(familiarId, updatedFamiliar);
        if (familiar != null) {
            return new ResponseEntity<>(familiar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

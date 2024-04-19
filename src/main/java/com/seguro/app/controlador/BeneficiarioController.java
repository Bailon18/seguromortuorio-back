package com.seguro.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.seguro.app.model.entidad.Beneficiario;
import com.seguro.app.model.servicio.BeneficiarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @GetMapping
    public ResponseEntity<List<Beneficiario>> getAllBeneficiarios() {
        List<Beneficiario> beneficiarios = beneficiarioService.findAllBeneficiarios();
        if (beneficiarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(beneficiarios, HttpStatus.OK);
        }
    }

    @GetMapping("/{beneficiarioId}")
    public ResponseEntity<Optional<Beneficiario>> getBeneficiarioById(@PathVariable Long beneficiarioId) {
        Optional<Beneficiario> beneficiario = beneficiarioService.findBeneficiarioById(beneficiarioId);
        if (beneficiario.isPresent()) {
            return new ResponseEntity<>(beneficiario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Beneficiario> createBeneficiario(@RequestBody Beneficiario beneficiario) {
        Beneficiario nuevoBeneficiario = beneficiarioService.saveBeneficiario(beneficiario);
        return new ResponseEntity<>(nuevoBeneficiario, HttpStatus.CREATED);
    }

    @DeleteMapping("/{beneficiarioId}")
    public ResponseEntity<Void> deleteBeneficiario(@PathVariable Long beneficiarioId) {
        beneficiarioService.deleteBeneficiario(beneficiarioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{beneficiarioId}")
    public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable Long beneficiarioId, @RequestBody Beneficiario updatedBeneficiario) {
        Beneficiario beneficiario = beneficiarioService.updateBeneficiario(beneficiarioId, updatedBeneficiario);
        return new ResponseEntity<>(beneficiario, HttpStatus.OK);
    }
}

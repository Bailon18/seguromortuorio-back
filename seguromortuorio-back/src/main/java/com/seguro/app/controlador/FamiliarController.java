package com.seguro.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.seguro.app.model.entidad.Familiar;
import com.seguro.app.model.servicio.FamiliarService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apifm/familiares")
@CrossOrigin(origins = "*")
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

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE, "multipart/form-data;charset=UTF-8" })
    public ResponseEntity<Familiar> createFamiliar(
    		@RequestPart("familiar") Familiar familiar,
    		@RequestPart(name = "archivo") MultipartFile archivo
    		) throws IOException {
    	
    	
        if (archivo != null && !archivo.isEmpty()) {
            byte[] archivoBytes = archivo.getBytes();
            familiar.setArchivo(archivoBytes);
        }else {
        	System.out.println("ARCHIVO MAL");
        }
    	
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
    
   
    @GetMapping("/por-socio/{socioId}")
    public List<Familiar> obtenerFamiliaresPorSocioId(@PathVariable Long socioId) {
        return familiarService.obtenerFamiliaresPorSocioId(socioId);
    }
    
    @GetMapping("/exists-documento")
    public ResponseEntity<Boolean> existsByDocumentoIdentidad(@RequestParam String documentoIdentidad) {
        boolean exists = familiarService.existsByDocumentoIdentidad(documentoIdentidad);
        HttpStatus status = exists ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(exists, status);
    }
}

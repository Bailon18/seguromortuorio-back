package com.seguro.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.seguro.app.model.entidad.Socio;
import com.seguro.app.model.servicio.SocioService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apifm/socios")
@CrossOrigin(origins = "*")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @GetMapping
    public ResponseEntity<List<Socio>> getAllSocios() {
        List<Socio> socios = socioService.findAllSocios();
        if (socios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(socios, HttpStatus.OK);
        }
    }

    @GetMapping("/{socioId}")
    public ResponseEntity<Optional<Socio>> getSocioById(@PathVariable Long socioId) {
        Optional<Socio> socio = socioService.findSocioById(socioId);
        if (socio.isPresent()) {
            return new ResponseEntity<>(socio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE, "multipart/form-data;charset=UTF-8" })
    public ResponseEntity<Socio> createSocio(
    		@RequestPart("socio") Socio socio,
    		@RequestPart(name = "archivo") MultipartFile archivo
    		) throws IOException {
 
        if (archivo != null && !archivo.isEmpty()) {
            byte[] archivoBytes = archivo.getBytes();
            socio.setArchivo(archivoBytes);
        }else {
        	System.out.println("ARCHIVO MAL");
        }
        
        Socio socioretorno = new Socio();
        
        if(socio.getId() != null) {
        	socioretorno = socioService.updateSocio(socio);
        }else {
        	socioretorno = socioService.saveSocio(socio);
        }
       
        return new ResponseEntity<>(socioretorno, HttpStatus.CREATED);
    }

    @DeleteMapping("/{socioId}")
    public ResponseEntity<Void> deleteSocio(@PathVariable Long socioId) {
        socioService.deleteSocio(socioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @GetMapping("/exists-correo")
    public ResponseEntity<Boolean> existsByCorreoElectronico(@RequestParam String correoElectronico) {
        boolean exists = socioService.existsByCorreoElectronico(correoElectronico);
        HttpStatus status = exists ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(exists, status);
    }

    @GetMapping("/exists-documento")
    public ResponseEntity<Boolean> existsByDocumentoIdentidad(@RequestParam String documentoIdentidad) {
        boolean exists = socioService.existsByDocumentoIdentidad(documentoIdentidad);
        HttpStatus status = exists ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(exists, status);
    }
    
    @GetMapping("/buscar-socio")
    public ResponseEntity<List<Socio>> buscarSocioPorFiltro(@RequestParam String filtro) {
        List<Socio> socioEncontrado = socioService.buscarSocioFiltro(filtro);
        
        if (socioEncontrado != null) {
            return new ResponseEntity<>(socioEncontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cambiarEstado/{id}/{estado}")
    public ResponseEntity<Socio> bloquearSocio(@PathVariable Long id, @PathVariable boolean estado) {
        Socio socio = socioService.bloquearSocio(id, estado);
        return new ResponseEntity<>(socio, HttpStatus.OK);
    }
}

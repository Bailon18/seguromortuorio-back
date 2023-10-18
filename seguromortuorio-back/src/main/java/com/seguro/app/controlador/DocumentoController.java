package com.seguro.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.seguro.app.model.entidad.Documento;
import com.seguro.app.model.servicio.DocumentoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping
    public ResponseEntity<List<Documento>> getAllDocumentos() {
        List<Documento> documentos = documentoService.findAllDocumentos();
        if (documentos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(documentos, HttpStatus.OK);
        }
    }

    @GetMapping("/{documentoId}")
    public ResponseEntity<Optional<Documento>> getDocumentoById(@PathVariable Long documentoId) {
        Optional<Documento> documento = documentoService.findDocumentoById(documentoId);
        if (documento.isPresent()) {
            return new ResponseEntity<>(documento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Documento> createDocumento(@RequestBody Documento documento) {
        Documento nuevoDocumento = documentoService.saveDocumento(documento);
        return new ResponseEntity<>(nuevoDocumento, HttpStatus.CREATED);
    }

    @DeleteMapping("/{documentoId}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long documentoId) {
        documentoService.deleteDocumento(documentoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{documentoId}")
    public ResponseEntity<Documento> updateDocumento(@PathVariable Long documentoId, @RequestBody Documento updatedDocumento) {
        Documento documento = documentoService.updateDocumento(documentoId, updatedDocumento);
        return new ResponseEntity<>(documento, HttpStatus.OK);
    }
}

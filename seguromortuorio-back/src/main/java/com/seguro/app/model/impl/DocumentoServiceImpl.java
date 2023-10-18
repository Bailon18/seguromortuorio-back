package com.seguro.app.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.seguro.app.model.entidad.Documento;
import com.seguro.app.model.repositorio.DocumentoRepository;
import com.seguro.app.model.servicio.DocumentoService;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoServiceImpl implements DocumentoService {
    
    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public List<Documento> findAllDocumentos() {
        return documentoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<Documento> findDocumentoById(Long documentoId) {
        return documentoRepository.findById(documentoId);
    }

    @Override
    public Documento saveDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    @Override
    public void deleteDocumento(Long documentoId) {
        documentoRepository.deleteById(documentoId);
    }

    @Override
    public Documento updateDocumento(Long documentoId, Documento updatedDocumento) {
        Optional<Documento> existingDocumento = documentoRepository.findById(documentoId);

        if (existingDocumento.isPresent()) {
            Documento documento = existingDocumento.get();
            // Actualizar los campos del objeto Documento con los valores de updatedDocumento
            documento.setTipoDocumento(updatedDocumento.getTipoDocumento());
            documento.setArchivo(updatedDocumento.getArchivo());
            documento.setFamiliar(updatedDocumento.getFamiliar());
            documento.setSocio(updatedDocumento.getSocio());

            return documentoRepository.save(documento);
        }
        return null;
    }
}

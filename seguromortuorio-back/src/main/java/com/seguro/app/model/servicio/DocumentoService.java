package com.seguro.app.model.servicio;

import com.seguro.app.model.entidad.Documento;
import java.util.List;
import java.util.Optional;

public interface DocumentoService {
	
	List<Documento> findAllDocumentos();

	Optional<Documento> findDocumentoById(Long documentoId);

	Documento saveDocumento(Documento documento);

	void deleteDocumento(Long documentoId);

	Documento updateDocumento(Long documentoId, Documento updatedDocumento);
}

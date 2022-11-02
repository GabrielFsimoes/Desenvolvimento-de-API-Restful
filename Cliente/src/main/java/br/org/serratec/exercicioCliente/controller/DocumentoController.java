package br.org.serratec.exercicioCliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.exercicioCliente.domain.Documento;
import br.org.serratec.exercicioCliente.repository.DocumentoRepository;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

	@Autowired
	private DocumentoRepository documentoRepository;

	@GetMapping
	public List<Documento> documentos() {
		return documentoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Documento> buscar(@PathVariable Long id) {
		Optional<Documento> documento = documentoRepository.findById(id);
		if (documento.isPresent()) {
			return ResponseEntity.ok(documento.get());
		}
		return ResponseEntity.notFound().build();
	}

}

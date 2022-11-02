package br.org.serratec.backend.exercicio.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.backend.exercicio.domain.Associado;
import br.org.serratec.backend.exercicio.repository.AssociadoRepository;



@RestController
@RequestMapping("/associado")
public class AssociadoController {

	@Autowired
	private AssociadoRepository associadoRepository;

	@GetMapping
	public List<Associado> associados() {
		return associadoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Associado> buscar(@PathVariable Long id) {
		Optional<Associado> associado = associadoRepository.findById(id);
		if (associado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(associado.get());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Associado inserir(@Valid @RequestBody Associado associado) {
		return associadoRepository.save(associado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Associado> alterar(@Valid @RequestBody Associado associado, @PathVariable Long id) {
		Optional<Associado> associadoAlt = associadoRepository.findById(id);
		if (associadoAlt.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			Associado associadoBanco = associadoAlt.get();
			associadoBanco.setNome(associado.getNome());
			associadoBanco.setTelefone(associado.getTelefone());
			associadoBanco.setLogradouro(associado.getLogradouro());
			associadoBanco.setNumero(associado.getNumero());
			associadoBanco.setBairro(associado.getBairro());
			associadoBanco.setComplemento(associado.getComplemento());
			associadoBanco.setCidade(associado.getCidade());
			associadoBanco.setEstado(associado.getEstado());
			associadoBanco = associadoRepository.save(associadoBanco);
			return ResponseEntity.ok(associadoBanco);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		if (associadoRepository.existsById(id)) {
			associadoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}

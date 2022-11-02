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

import br.org.serratec.backend.exercicio.domain.Autor;
import br.org.serratec.backend.exercicio.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@GetMapping
	public List<Autor> autors() {
		return autorRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Autor> buscar(@PathVariable Long id) {
		Optional<Autor> autor = autorRepository.findById(id);
		if (autor.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(autor.get());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Autor inserir(@Valid @RequestBody Autor autor) {
		return autorRepository.save(autor);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Autor> alterar(@Valid @RequestBody Autor autor, @PathVariable Long id) {
		Optional<Autor> autorAlt = autorRepository.findById(id);
		if (autorAlt.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			Autor autorBanco = autorAlt.get();
			autorBanco.setNome(autor.getNome());
			autorBanco = autorRepository.save(autorBanco);
			return ResponseEntity.ok(autorBanco);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		if (autorRepository.existsById(id)) {
			autorRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}

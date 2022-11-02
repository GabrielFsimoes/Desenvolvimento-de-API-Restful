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

import br.org.serratec.backend.exercicio.domain.Categoria;
import br.org.serratec.backend.exercicio.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> categorias() {
		return categoriaRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (categoria.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(categoria.get());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria inserir(@Valid @RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Categoria> alterar(@Valid @RequestBody Categoria categoria, @PathVariable Long id) {
		Optional<Categoria> categoriaAlt = categoriaRepository.findById(id);
		if (categoriaAlt.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			Categoria categoriaBanco = categoriaAlt.get();
			categoriaBanco.setNome(categoria.getNome());
			categoriaBanco.setDescricao(categoria.getDescricao());
			categoriaBanco = categoriaRepository.save(categoriaBanco);
			return ResponseEntity.ok(categoriaBanco);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		if (categoriaRepository.existsById(id)) {
			categoriaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}

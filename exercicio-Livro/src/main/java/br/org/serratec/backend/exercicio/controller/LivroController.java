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

import br.org.serratec.backend.exercicio.domain.Livro;
import br.org.serratec.backend.exercicio.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping
	public List<Livro> livros() {
		return livroRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(livro.get());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro inserir(@Valid @RequestBody Livro livro) {
		return livroRepository.save(livro);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> alterar(@Valid @RequestBody Livro livro, @PathVariable Long id) {
		Optional<Livro> livroAlt = livroRepository.findById(id);
		if (livroAlt.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			Livro livroBanco = livroAlt.get();
			livroBanco.setTitulo(livro.getTitulo());
			livroBanco.setData_publicacao(livro.getData_publicacao());
			livroBanco.setCategoria(livro.getCategoria());
			livroBanco = livroRepository.save(livroBanco);
			return ResponseEntity.ok(livroBanco);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		if (livroRepository.existsById(id)) {
			livroRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}

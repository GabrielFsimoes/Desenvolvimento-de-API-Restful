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

import br.org.serratec.backend.exercicio.domain.Emprestimo;
import br.org.serratec.backend.exercicio.repository.EmprestimoRepository;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@GetMapping
	public List<Emprestimo> emprestimos() {
		return emprestimoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> buscar(@PathVariable Long id) {
		Optional<Emprestimo> emprestimo = emprestimoRepository.findById(id);
		if (emprestimo.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(emprestimo.get());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Emprestimo inserir(@Valid @RequestBody Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Emprestimo> alterar(@Valid @RequestBody Emprestimo emprestimo, @PathVariable Long id) {
		Optional<Emprestimo> emprestimoAlt = emprestimoRepository.findById(id);
		if (emprestimoAlt.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			Emprestimo emprestimoBanco = emprestimoAlt.get();
			emprestimoBanco.setAssociado(emprestimo.getAssociado());
			emprestimoBanco.setData_emprestimo(emprestimo.getData_emprestimo());
			emprestimoBanco.setEmprestimo_Livro(emprestimo.getEmprestimo_Livro());
			emprestimoBanco = emprestimoRepository.save(emprestimoBanco);
			return ResponseEntity.ok(emprestimoBanco);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		if (emprestimoRepository.existsById(id)) {
			emprestimoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}

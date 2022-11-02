package br.org.serratec.Aula07.controller;

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

import br.org.serratec.Aula07.domain.Manutencao;
import br.org.serratec.Aula07.repository.ManutencaoRepository;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {
	@Autowired
	ManutencaoRepository manutencaoRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Manutencao inserir(@Valid @RequestBody Manutencao manutencao) {
		manutencao = manutencaoRepository.save(manutencao);
		return manutencaoRepository.findById(manutencao.getId()).get();
		}

	@GetMapping
	public List<Manutencao> listar() {
		return manutencaoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Manutencao> buscar(@PathVariable Long id) {
		Optional<Manutencao> manutencao = manutencaoRepository.findById(id);
		if (!manutencao.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(manutencao.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		if (!manutencaoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		manutencaoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Manutencao> alterar(@PathVariable Long id, @Valid @RequestBody Manutencao manutencao) {

		if (!manutencaoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		manutencao.setId(id);
		return ResponseEntity.ok(manutencaoRepository.save(manutencao));
	}

}

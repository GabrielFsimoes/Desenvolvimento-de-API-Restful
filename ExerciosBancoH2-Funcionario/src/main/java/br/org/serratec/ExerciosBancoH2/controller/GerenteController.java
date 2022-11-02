package br.org.serratec.ExerciosBancoH2.controller;

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
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.ExerciosBancoH2.domain.Gerente;
import br.org.serratec.ExerciosBancoH2.repository.GerenteRepository;

@RestController
@RequestMapping("/gerente")
public class GerenteController {

	@Autowired
	private GerenteRepository gerenteRepository;

	@GetMapping
	public List<Gerente> funcionarios() {
		return gerenteRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Gerente> buscaPorId(@PathVariable Long id) {
		Optional<Gerente> gerente = gerenteRepository.findById(id);
		if (gerente.isPresent()) {
			return ResponseEntity.ok(gerente.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Gerente> inserir(@Valid @RequestBody Gerente gerente) {
		Gerente gerenteInserido = gerenteRepository.save(gerente);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Gerente> alterar(@RequestBody Gerente gerente, @PathVariable Long id) {
		Optional<Gerente> gerenteAlt = gerenteRepository.findById(id);
		if (gerenteAlt.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			Gerente gerenteBanco = gerenteAlt.get();
			gerenteBanco.setNome(gerente.getNome());
			gerenteBanco.setSalario(gerente.getSalario());
			gerenteBanco.setSetor(gerente.getSetor());
			gerenteBanco.setTurno(gerente.getTurno());
			gerenteBanco = gerenteRepository.save(gerente);
			return ResponseEntity.ok(gerenteBanco);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarGerente(@PathVariable Long id) {
		if (gerenteRepository.existsById(id)) {
			gerenteRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}

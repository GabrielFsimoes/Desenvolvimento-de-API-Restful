package br.org.serratec.exercicioCliente.controller;

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

import br.org.serratec.exercicioCliente.domain.Cliente;
import br.org.serratec.exercicioCliente.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<Cliente> listaCliente() {
		return clienteRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarCliente(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(cliente.get());
		}
	}

	@PostMapping
	public ResponseEntity<Cliente> inserir(@Valid @RequestBody Cliente cliente1) {
		Cliente clienteInserido = clienteRepository.save(cliente1);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteInserido);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> Atualizar(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
		Optional<Cliente> clienteNovo = clienteRepository.findById(id);
		if (clienteNovo.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			Cliente clienteBanco = clienteNovo.get();
			clienteBanco.setNome(cliente.getNome());
			clienteBanco.setCpf(cliente.getCpf());
			clienteBanco.setEmail(cliente.getEmail());
			clienteBanco.setDataNasc(cliente.getDataNasc());
			clienteBanco.setEndereco(cliente.getEndereco());

			clienteBanco = clienteRepository.save(clienteBanco);
			return ResponseEntity.ok(clienteBanco);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}

package br.org.serratec.musicmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.musicmanager.domain.Artista;
import br.org.serratec.musicmanager.repository.ArtistaRepository;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

	@Autowired
	private ArtistaRepository artistaRepository;

	@GetMapping
	public List<Artista> ListaTodos() {
		return artistaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Artista busca(@PathVariable Long id) {
		return artistaRepository.findById(id).get();
	}

	@PostMapping
	public Artista inserir(@Valid @RequestBody Artista artista) {
		return artistaRepository.save(artista);
	}

	@PutMapping("/{id}")
	public Artista alterar(@Valid @RequestBody Artista artista, @PathVariable Long id) {
		Optional<Artista> opArtista = artistaRepository.findById(id);
		if (opArtista.isEmpty()) {
			return null;
		}
		Artista artistaBanco = opArtista.get();
		artistaBanco.setNome(artista.getNome());
		artistaBanco.setTipoArtista(artista.getTipoArtista());
		return artistaRepository.save(artistaBanco);

	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		artistaRepository.deleteById(id);

	}

}

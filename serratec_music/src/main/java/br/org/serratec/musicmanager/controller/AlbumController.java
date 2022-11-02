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

import br.org.serratec.musicmanager.domain.Album;
import br.org.serratec.musicmanager.repository.AlbumRepository;

@RestController
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private AlbumRepository albumRepository;

	@GetMapping
	public List<Album> ListaTodos() {
		return albumRepository.findAll();
	}

	@GetMapping("/{id}")
	public Album busca(@PathVariable Long id) {
		return albumRepository.findById(id).get();
	}

	@PostMapping
	public Album inserir(@Valid @RequestBody Album album) {
		return albumRepository.save(album);
	}

	@PutMapping("/{id}")
	public Album alterar(@Valid @RequestBody Album album, @PathVariable Long id) {
		Optional<Album> opAlbum = albumRepository.findById(id);
		if (opAlbum.isEmpty()) {
			return null;
		}
		Album albumBanco = opAlbum.get();
		albumBanco.setNome(album.getNome());
		albumBanco.setMusicas(album.getMusicas());
		return albumRepository.save(albumBanco);

	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		albumRepository.deleteById(id);

	}

}

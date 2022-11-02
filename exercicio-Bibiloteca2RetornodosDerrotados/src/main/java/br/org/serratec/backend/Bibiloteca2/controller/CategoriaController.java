package br.org.serratec.backend.Bibiloteca2.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.backend.Bibiloteca2.domain.Categoria;
import br.org.serratec.backend.Bibiloteca2.exception.DataNotFoundException;
import br.org.serratec.backend.Bibiloteca2.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listar(){
		List<Categoria> categorias = categoriaService.buscarTodos();
		return ResponseEntity.ok(categorias);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> inserir(@Valid @RequestBody Categoria categoria){
		categoria = categoriaService.inserir(categoria);
		
		URI uri = ServletUriComponentsBuilder
		           .fromCurrentRequest()
		           .path("/{id}")
		           .buildAndExpand(categoria.getId())
		           .toUri();
		return ResponseEntity.created(uri).body(categoria);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) throws DataNotFoundException{
		Categoria categoria = categoriaService.buscaPorId(id);
		return ResponseEntity.ok(categoria);
	}
	
//	@DeleteMapping
//	public ResponseEntity<Void> apagar(){
//		
//	}
	

}

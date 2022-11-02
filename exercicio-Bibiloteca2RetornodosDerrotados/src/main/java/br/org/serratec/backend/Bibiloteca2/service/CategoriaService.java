package br.org.serratec.backend.Bibiloteca2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.Bibiloteca2.domain.Categoria;
import br.org.serratec.backend.Bibiloteca2.exception.DataNotFoundException;
import br.org.serratec.backend.Bibiloteca2.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> buscarTodos(){
		return categoriaRepository.findAll();
	}
	

	public Categoria inserir(Categoria categoria) {
		categoria = categoriaRepository.save(categoria);
		return categoria;
	}


	public Categoria buscaPorId(Long id) throws DataNotFoundException {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(categoria.isEmpty()) {
			throw new DataNotFoundException();
		}
		return categoria.get();
	}
}

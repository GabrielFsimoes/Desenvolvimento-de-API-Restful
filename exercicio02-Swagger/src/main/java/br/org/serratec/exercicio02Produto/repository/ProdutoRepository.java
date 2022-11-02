package br.org.serratec.exercicio02Produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.exercicio02Produto.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}

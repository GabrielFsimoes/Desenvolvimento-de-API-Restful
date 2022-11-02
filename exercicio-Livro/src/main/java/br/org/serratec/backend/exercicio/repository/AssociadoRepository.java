package br.org.serratec.backend.exercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.backend.exercicio.domain.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long>{

}

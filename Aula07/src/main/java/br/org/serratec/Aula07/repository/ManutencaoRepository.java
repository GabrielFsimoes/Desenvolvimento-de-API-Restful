package br.org.serratec.Aula07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.Aula07.domain.Manutencao;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{

}

package br.org.serratec.ExerciosBancoH2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.ExerciosBancoH2.domain.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {

}

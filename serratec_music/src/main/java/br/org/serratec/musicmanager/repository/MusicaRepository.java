package br.org.serratec.musicmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.musicmanager.domain.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

}

package br.org.serratec.musicmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.musicmanager.domain.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}

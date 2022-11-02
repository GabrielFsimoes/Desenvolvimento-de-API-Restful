package br.org.serratec.backend.servicedto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.backend.servicedto.domain.Foto;
import br.org.serratec.backend.servicedto.domain.Funcionario;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long>{
	public Optional<Foto> findByFuncionario(Funcionario funcionario);
}

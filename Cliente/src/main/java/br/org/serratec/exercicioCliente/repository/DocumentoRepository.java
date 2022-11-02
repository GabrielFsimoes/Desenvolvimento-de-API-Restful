package br.org.serratec.exercicioCliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.exercicioCliente.domain.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}

package br.org.serratec.exercicioCliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.exercicioCliente.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

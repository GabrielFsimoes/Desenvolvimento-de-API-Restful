package br.org.serratec.exercicioCliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.exercicioCliente.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}

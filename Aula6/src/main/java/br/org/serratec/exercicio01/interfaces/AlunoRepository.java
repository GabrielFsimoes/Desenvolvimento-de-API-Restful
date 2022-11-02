package br.org.serratec.exercicio01.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.exercicio01.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}

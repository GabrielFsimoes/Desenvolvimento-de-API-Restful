package br.org.serratec.exercicio01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.exercicio01.domain.Aluno;
import br.org.serratec.exercicio01.interfaces.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;

	
	@GetMapping
	public List<Aluno> listaAlunos(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{matricula}")
	public ResponseEntity<Aluno> buscarAlunoid(@PathVariable Long matricula) {
		Optional<Aluno> aluno = alunoRepository.findById(matricula);
		if(aluno.isEmpty()) {
			return ResponseEntity.notFound().header("x-data-exclusao", "01/01/01").build();
		}else {
			return ResponseEntity.ok(aluno.get());
		}
	}
	
	@PostMapping
	public ResponseEntity<Aluno> inserir(@RequestBody Aluno aluno) {
		 Aluno alunoBanco = alunoRepository.save(aluno);
		 return ResponseEntity.status(HttpStatus.CREATED).body(alunoBanco);
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
	if(alunoRepository.existsById(id)) {
		alunoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{matricula}")
	public  ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno, @PathVariable Long matricula) {
		Optional<Aluno> alunoOptional = alunoRepository.findById(matricula);
		if(alunoOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Aluno alunoBanco = alunoOptional.get();
		alunoBanco.setNome(aluno.getNome());
		alunoBanco.setEmail(aluno.getEmail());
		alunoBanco.setTelefone(aluno.getTelefone());
		alunoBanco = alunoRepository.save(alunoBanco);
		return ResponseEntity.ok(alunoBanco);
	}

}

package br.org.serratec.ExerciosBancoH2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.ExerciosBancoH2.domain.Fornecedor;
import br.org.serratec.ExerciosBancoH2.domain.PessoaFisica;
import br.org.serratec.ExerciosBancoH2.domain.PessoaJuridica;
import br.org.serratec.ExerciosBancoH2.repository.FornecedorRepository;
import br.org.serratec.ExerciosBancoH2.repository.PessoaFisicaRepository;
import br.org.serratec.ExerciosBancoH2.repository.PessoaJuridicaRepository;

@RestController
public class FornecedorController {

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;

	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@GetMapping("/pessoaFisica")
	public List<PessoaFisica> listaPf() {
		return pessoaFisicaRepository.findAll();

	}

	@GetMapping("/pessoaJuridica")
	public List<PessoaJuridica> listaPj() {
		return pessoaJuridicaRepository.findAll();

	}

	@GetMapping("/fornecedor")
	public List<Fornecedor> listaF() {
		return fornecedorRepository.findAll();

	}

}

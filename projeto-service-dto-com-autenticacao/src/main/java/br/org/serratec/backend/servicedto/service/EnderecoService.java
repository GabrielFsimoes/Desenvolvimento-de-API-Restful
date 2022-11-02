package br.org.serratec.backend.servicedto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.org.serratec.backend.servicedto.domain.Endereco;
import br.org.serratec.backend.servicedto.dto.EnderecoDTO;
import br.org.serratec.backend.servicedto.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public EnderecoDTO buscar(String cep) {
		Optional<Endereco> endereco = Optional.ofNullable(enderecoRepository.findByCep(cep));
		if (endereco.isPresent()) {
			return new EnderecoDTO(endereco.get());
		} else {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "http://viacep.com.br/ws/" + cep + "/json";
			Optional<Endereco> enderecoViaCep = Optional.ofNullable(restTemplate.getForObject(uri, Endereco.class));
			if (enderecoViaCep.get().getCep() != null) {
				String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
				enderecoViaCep.get().setCep(cepSemTraco);
				return inserir(enderecoViaCep.get());
			} else {
				return null;
			}
		}
	}
	private EnderecoDTO inserir(Endereco endereco) {
		return new EnderecoDTO(enderecoRepository.save(endereco));
	}
}

package br.org.serratec.backend.revisao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.revisao.domain.Usuario;
import br.org.serratec.backend.revisao.dto.UsuarioDTO;
import br.org.serratec.backend.revisao.dto.UsuarioInserirDto;
import br.org.serratec.backend.revisao.exception.EmailException;
import br.org.serratec.backend.revisao.exception.SenhaException;
import br.org.serratec.backend.revisao.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<UsuarioDTO> lista(){
			List<Usuario> usuarios = usuarioRepository.findAll();
			List<UsuarioDTO> usuariosDTO = new ArrayList<>();
			for (Usuario usuario : usuarios) {
				usuariosDTO.add(new UsuarioDTO(usuario));
			}
			return usuariosDTO;
	}
	
	public UsuarioDTO inserir(UsuarioInserirDto usuarioInserirDto) throws EmailException, SenhaException {
		Usuario usuarioBanco = usuarioRepository.findByEmail(usuarioInserirDto.getEmail());
		if(!usuarioInserirDto.getSenha().equals(usuarioInserirDto.getConfirmaSenha())) {
			throw new SenhaException("Senhas não conferem");
		}
		if (usuarioBanco!=null) {
		throw new EmailException("O email "+ usuarioInserirDto.getEmail()+" já esta cadastrado no sistema.");
		}
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDto.getNome());
		usuario.setEmail(usuarioInserirDto.getEmail());
		usuario.setSenha(usuarioInserirDto.getSenha());
		return new UsuarioDTO(usuarioRepository.save(usuario));
		}

}

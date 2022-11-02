package br.org.serratec.backend.servicedto.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.servicedto.domain.Perfil;
import br.org.serratec.backend.servicedto.domain.Usuario;
import br.org.serratec.backend.servicedto.domain.UsuarioPerfil;
import br.org.serratec.backend.servicedto.dto.UsuarioDTO;
import br.org.serratec.backend.servicedto.dto.UsuarioInserirDTO;
import br.org.serratec.backend.servicedto.exception.EmailException;
import br.org.serratec.backend.servicedto.exception.SenhaException;
import br.org.serratec.backend.servicedto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioDTO> findAll() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Login do usuario SecurityContextHolder: " + userDetails.getUsername());
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		for (Usuario usuario : usuarios) {
			usuariosDTO.add(new UsuarioDTO(usuario));
		}
		// VERSÃO LAMBDA
		// return usuarios.stream().map(UsuarioDTO: :new).collect(Collectors.tolist());
		return usuariosDTO;
	}

	@Autowired
	private PerfilService perfilService;

	public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO) throws SenhaException, EmailException {
		Usuario usuarioBanco = usuarioRepository.findByEmail(usuarioInserirDTO.getEmail());
		if (!usuarioInserirDTO.getSenha().equals(usuarioInserirDTO.getConfirmaSenha())) {
			throw new SenhaException("Senhas não conferem");
		}
		if (usuarioBanco != null) {
			throw new EmailException("Lá existe um usuário com o e-mail " + usuarioInserirDTO.getEmail());
		}
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setSenha(usuarioInserirDTO.getSenha());

		Set<UsuarioPerfil> perfis = new HashSet<>();
		for (Perfil perfil : usuarioInserirDTO.getPerfis()) {
			perfil = perfilService.buscar(perfil.getId());
			UsuarioPerfil usuarioPerfil = new UsuarioPerfil(usuario, perfil, LocalDate.now());
			perfis.add(usuarioPerfil);
		}
		usuario.setUsuarioPerfis(perfis);
		usuario = usuarioRepository.save(usuario);
//		mailConfig.sendEmail(usuario.getEmail(), "Cadastro de Usuario!", usuario.toString());
		return new UsuarioDTO(usuarioRepository.save(usuario));
	}
}

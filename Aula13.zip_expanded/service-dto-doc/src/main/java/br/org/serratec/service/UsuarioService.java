package br.org.serratec.service;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.config.MailConfig;
import br.org.serratec.dto.UsuarioDTO;
import br.org.serratec.dto.UsuarioInserirDTO;
import br.org.serratec.exception.EmailException;
import br.org.serratec.model.Foto;
import br.org.serratec.model.Usuario;
import br.org.serratec.model.UsuarioPerfil;
import br.org.serratec.repository.FotoRepository;
import br.org.serratec.repository.UsuarioPerfilRepository;
import br.org.serratec.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UsuarioPerfilRepository usuarioPerfilRepository;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private MailConfig mailConfig;

	@Autowired
	private FotoService fotoService;
	
	@Autowired
	private FotoRepository fotoRepository;
	private UsuarioDTO inserirUriImagem(Usuario usuario) {
		Optional<Foto> foto = fotoRepository.findById(usuario.getIdUsuario());
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/usuarios/{id}/foto")
				.buildAndExpand(usuario.getIdUsuario()).toUri();
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNome(usuario.getNome());
		dto.setEmail(usuario.getEmail());
		dto.setUri(uri.toString());
		return dto;
	}

	public List<UsuarioDTO> listar() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();

		for (Usuario usuario : usuarios) {
			usuariosDTO.add(inserirUriImagem(usuario));
		}

		return usuariosDTO;
	}

	public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO, MultipartFile file) throws IOException {
		if (usuarioRepository.findByEmail(usuarioInserirDTO.getEmail()) != null) {
			throw new EmailException("Email já existe na base");
		}
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setSenha(bCryptPasswordEncoder.encode(usuarioInserirDTO.getSenha()));
		fotoService.inserir(usuarioRepository.save(usuario), file);
		//usuario = usuarioRepository.save(usuario);
		for (UsuarioPerfil up : usuarioInserirDTO.getUsuariosPerfil()) {
			up.setUsuario(usuario);
			up.setPerfil(perfilService.buscar(up.getPerfil().getIdPerfil()));
			up.setDataCriacao(LocalDate.now());
		}
		usuarioPerfilRepository.saveAll(usuarioInserirDTO.getUsuariosPerfil());
		//mailConfig.sendEmail(usuario.getEmail(), "Cadastro de Usuário", usuario.toString());
		return inserirUriImagem(usuario);
	}
}

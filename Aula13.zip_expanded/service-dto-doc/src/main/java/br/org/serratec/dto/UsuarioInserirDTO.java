package br.org.serratec.dto;

import java.util.HashSet;
import java.util.Set;

import br.org.serratec.model.Usuario;
import br.org.serratec.model.UsuarioPerfil;

//Usado na requisição
public class UsuarioInserirDTO {

	private String nome;
	private String email;
	private String senha;

	private Set<UsuarioPerfil> usuariosPerfil = new HashSet<>();

	public UsuarioInserirDTO() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioInserirDTO(Usuario usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

	public Set<UsuarioPerfil> getUsuariosPerfil() {
		return usuariosPerfil;
	}

	public void setUsuariosPerfil(Set<UsuarioPerfil> usuariosPerfil) {
		this.usuariosPerfil = usuariosPerfil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

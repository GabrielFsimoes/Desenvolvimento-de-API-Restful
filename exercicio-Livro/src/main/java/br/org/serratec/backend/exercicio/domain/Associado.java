package br.org.serratec.backend.exercicio.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Associado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_associado")
	private Long id;

	@NotBlank(message = "Campo nome não pode ficar em branco")
	@Column(name = "nome")
	@Size(max = 50)
	private String nome;

	@NotBlank(message = "Campo telefone não pode ficar em branco")
	@Column(name = "telefone")
	@Size(max = 15, message = "O numero de caracteres e no mininimo: {min} e no maximo: {max}")
	private String telefone;

	@NotBlank(message = "Campo Cpf não pode ficar em branco")
	@Column(name = "cpf")
	@CPF
	@Size(max = 11, min = 11, message = "O numero de caracteres é no mininimo: {min} e no maximo: {max}")
	private String cpf;

	@NotBlank(message = "Campo logradouro não pode ficar em branco")
	@Column(name = "logradouro")
	@Size(max = 80, message = "O numero de caracteres é no mininimo: {min} e no maximo: {max}")
	private String logradouro;

	@NotBlank(message = "Campo numero  não pode ficar em branco")
	@Column(name = "numero")
	@Size(max = 10, message = "O numero de caracteres é no mininimo: {min} e no maximo: {max}")
	private String numero;

	@NotBlank(message = "Campo complemento não pode ficar em branco")
	@Column(name = "complemento")
	@Size(max = 30, message = "O numero de caracteres é no mininimo: {min} e no maximo: {max}")
	private String complemento;

	@NotBlank(message = "Campo bairro não pode ficar em branco")
	@Column(name = "bairro")
	@Size(max = 50, message = "O numero de caracteres é no mininimo: {min} e no maximo: {max}")
	private String bairro;

	@NotBlank(message = "Campo cidade  não pode ficar em branco")
	@Column(name = "cidade ")
	@Size(max = 50, message = "O numero de caracteres é no mininimo: {min} e no maximo: {max}")
	private String cidade;

	@NotBlank(message = "Campo estado não pode ficar em branco")
	@Column(name = "estado ")
	@Size(min = 2, max = 2, message = "O numero de caracteres é no mininimo: {min} e no maximo: {max}")
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associado other = (Associado) obj;
		return Objects.equals(id, other.id);
	}

}

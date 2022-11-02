package br.org.serratec.exercicioCliente.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	@NotBlank(message = "Campo nome não pode ficar em branco")
	@Size(min = 5, max = 40, message = "mininimo: {min}, maximo: {max}")
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;

	@NotBlank(message = "Campo Cpf não pode ficar em branco")
	@CPF(message = "Cpf invalido")
	@Column(name = "cpf", length = 11)
	private String cpf;

	@NotBlank(message = "Campo email não pode ficar em branco")
	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "dataNasc")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNasc;

	@Embedded
	private Endereco endereco;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}

package br.org.serratec.ExerciosBancoH2.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Table(name = "funcionario")
@MappedSuperclass
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;

	@NotBlank(message = "O campo nome não pode estar em branco.")
	@Size(min = 1, max = 50, message = "O campo nome deve ter entre {min} e {max} caracteres.")
	@Column(name = "nome", nullable = false, length = 50)
	protected String nome;

	@NotBlank(message = "O campo cpf não pode estar em branco.")
	@CPF
	@Size(min = 11, max = 11, message = "O Cpf contém apenas 11 digitos sem contar os pontos(.) e hifen(-)")
	@Column(name = "cpf", nullable = false, length = 11)
	protected String cpf;

	@NotNull(message = "O campo salario não pode estar em branco")
	@Column(name = "salario", nullable = false)
	protected Double salario;
	@Column(name = "turno")
	protected String turno;

	public Funcionario() {
		super();
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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf);
	}

}

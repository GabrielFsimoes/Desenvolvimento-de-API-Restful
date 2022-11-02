package br.org.serratec.ExerciosBancoH2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Gerente extends Funcionario {

	@NotBlank(message = "O campo setor não pode estar em branco.")
	@Size(min = 1, max = 40, message = "O campo setor deve ter entre {min} e {max} caracteres.")
	@Column(name = "setor", nullable = false, length = 40)
	private String setor;

	public Gerente(
			@NotBlank(message = "O campo setor não pode estar em branco.") @Size(min = 1, max = 40, message = "O campo setor deve ter entre {min} e {max} caracteres.") String setor) {
		super();
		this.setor = setor;
	}

	public Gerente() {
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}

package br.org.serratec.exercicio02Produto.domain;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	@ApiModelProperty(value="identificador do produto")
	private Long id;

	// @Max(40)
	// @Min(5)
	// Size para as duas

	@NotBlank(message = "O campo descrição não pode ficar em branco")
	@Size(min = 5, max = 40, message = "O campo descrição deve ter no minino {min} e no máximo {max} caracteres")
	@Column(name = "descricao", nullable = false, length = 40)
	@ApiModelProperty(value="descrição do produto")
	private String descricao;
	
	@ApiModelProperty(value="valor do produto")
	@Column(name = "valor")
	private Double valor;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data")
	@ApiModelProperty(value="data de Cadastro do produto")
	private Date dataCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrição() {
		return descricao;
	}

	public void setDescrição(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}

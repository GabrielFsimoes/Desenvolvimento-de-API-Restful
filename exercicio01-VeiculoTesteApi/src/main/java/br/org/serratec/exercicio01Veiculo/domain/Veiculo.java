package br.org.serratec.exercicio01Veiculo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo {
@GeneratedValue(strategy =
GenerationType.IDENTITY)
	@Column(name="id_veiculo")
	private Integer id;

@Column(name="marca", nullable=false,
length=40)
	private String marca;

@Column(name="modelo", nullable=false,
length=40)

	private String modelo;
	public Veiculo(Integer id, String marca, String modelo) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public Veiculo() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}

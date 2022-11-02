package br.org.serratec.backend.exercicio.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="emprestimo")
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_emprestimo;
	
	@ManyToOne
	@JoinColumn(name="id_associado",nullable=false)
	private Associado associado;
	
	@Column(name="data_emprestimo")
	private LocalDate data_emprestimo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_emprestimo")
	private List<Emprestimo_Livro> emprestimo_Livro;

	public Long getId_emprestimo() {
		return id_emprestimo;
	}

	public void setId_emprestimo(Long id_emprestimo) {
		this.id_emprestimo = id_emprestimo;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public LocalDate getData_emprestimo() {
		return data_emprestimo;
	}

	public void setData_emprestimo(LocalDate data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}

	public List<Emprestimo_Livro> getEmprestimo_Livro() {
		return emprestimo_Livro;
	}

	public void setEmprestimo_Livro(List<Emprestimo_Livro> emprestimo_Livro) {
		this.emprestimo_Livro = emprestimo_Livro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_emprestimo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		return Objects.equals(id_emprestimo, other.id_emprestimo);
	}
	

}

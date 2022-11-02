package br.org.serratec.backend.exercicio.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="emprestimo_livro")
public class Emprestimo_Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_emprestimo_livro")
	private Long id_emprestimo_livro;
	
	@Column(name="observacoes_ato_emprestimo",length=200)
	private String observacoesAtoEmprestimo;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="id_livro")
	private Livro livro;

	public Long getId_emprestimo_livro() {
		return id_emprestimo_livro;
	}

	public void setId_emprestimo_livro(Long id_emprestimo_livro) {
		this.id_emprestimo_livro = id_emprestimo_livro;
	}

	public String getObservacoesAtoEmprestimo() {
		return observacoesAtoEmprestimo;
	}

	public void setObservacoesAtoEmprestimo(String observacoesAtoEmprestimo) {
		this.observacoesAtoEmprestimo = observacoesAtoEmprestimo;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_emprestimo_livro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo_Livro other = (Emprestimo_Livro) obj;
		return Objects.equals(id_emprestimo_livro, other.id_emprestimo_livro);
	}
	
	

}

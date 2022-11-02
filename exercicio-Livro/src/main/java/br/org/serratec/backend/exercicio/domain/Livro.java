package br.org.serratec.backend.exercicio.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "livro")
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livro")
	private Long id_livro;

	@NotBlank(message = "Campo titulo não pode ficar em branco")
	@Column(name = "titulo", nullable=false, length=40)
	@Length(min=1,max=40)
	private String titulo;

	@NotBlank(message = "Campo isbn não pode ficar em branco")
	@Column(name = "isbn", nullable=false, length=20, unique = true)
	@Length(min=1,max=20)
	private String isbn;

	@Column(name = "data_publicacao")
	private LocalDate data_publicacao;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@ManyToMany
	@JoinTable(name = "livro_autor",
	joinColumns = @JoinColumn(name = "id_livro"),
	inverseJoinColumns = @JoinColumn(name = "id_autor"))
	private List<Autor> autores;

	public Long getId_livro() {
		return id_livro;
	}

	public void setId_livro(Long id_livro) {
		this.id_livro = id_livro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getData_publicacao() {
		return data_publicacao;
	}

	public void setData_publicacao(LocalDate data_publicacao) {
		this.data_publicacao = data_publicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_livro, isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id_livro, other.id_livro) && Objects.equals(isbn, other.isbn);
	}

}

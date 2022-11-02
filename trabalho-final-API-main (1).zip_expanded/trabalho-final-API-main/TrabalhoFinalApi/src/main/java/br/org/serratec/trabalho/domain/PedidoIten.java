package br.org.serratec.trabalho.domain;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_pedido")
public class PedidoIten {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Long idPedidoIten;

	@NotNull
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@NotNull
	@Column(name = "preco_venda", nullable = false)
	private Double precoVenda;

	@NotNull
	@Column(name = "percentual_desconto", nullable = false)
	private Double percentualDesconto;

	@NotNull
	@Column(name = "valor_bruto", nullable = false)
	private Double valorBruto;

	@NotNull
	@Column(name = "valor_liquido", nullable = false)
	private Double valorLiquido;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	public Long getIdPedidoIten() {
		return idPedidoIten;
	}

	public void setIdPedidoIten(Long idPedidoIten) {
		this.idPedidoIten = idPedidoIten;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double ercentualDesconto) {
		this.percentualDesconto = ercentualDesconto;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedidoIten);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoIten other = (PedidoIten) obj;
		return Objects.equals(idPedidoIten, other.idPedidoIten);
	}

}

package com.phelipeprieto.skepsys.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido  implements Serializable{
	private  static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Double vl_desconto;
	private Double vl_unitario;
	private Integer quantidade;

	public ItemPedido() {
		
	}

	public ItemPedido(Pedido pedido, Produto produto ,Double vl_desconto, Double vl_total, Integer quantidade) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.vl_desconto = vl_desconto;
		this.vl_unitario = vl_total;
		this.quantidade = quantidade;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getVl_desconto() {
		return vl_desconto;
	}

	public void setVl_desconto(Double vl_desconto) {
		this.vl_desconto = vl_desconto;
	}

	public Double getVl_unitario() {
		return vl_unitario;
	}

	public void setVl_unitario(Double vl_unitario) {
		this.vl_unitario = vl_unitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
		
	
	
}

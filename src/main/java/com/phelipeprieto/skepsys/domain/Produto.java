package com.phelipeprieto.skepsys.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_prod;
	private String nm_prod;
	private Double vlprod;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA",
			   joinColumns = @JoinColumn(name = "id_prod"),
			   inverseJoinColumns = @JoinColumn(name = "id_categoria")
			)
	private List<Categoria> categorias  = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="id.produto")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Produto() {
		
	}

	public Produto(Integer id_prod, String nm_prod, Double vlprod) {
		super();
		this.id_prod = id_prod;
		this.nm_prod = nm_prod;
		this.vlprod = vlprod;
	}
	
	@JsonIgnore
	public List<Pedido> getPedidos(){
		List<Pedido> lista = new ArrayList<>();
		for(ItemPedido x: itens) {
			lista.add(x.getPedido());
			
		}
		return lista;
	} 

	public Integer getId_prod() {
		return id_prod;
	}

	public void setId_prod(Integer id_prod) {
		this.id_prod = id_prod;
	}

	public String getNm_prod() {
		return nm_prod;
	}

	public void setNm_prod(String nm_prod) {
		this.nm_prod = nm_prod;
	}

	public Double getVlprod() {
		return vlprod;
	}

	public void setVlprod(Double vlprod) {
		this.vlprod = vlprod;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_prod == null) ? 0 : id_prod.hashCode());
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
		Produto other = (Produto) obj;
		if (id_prod == null) {
			if (other.id_prod != null)
				return false;
		} else if (!id_prod.equals(other.id_prod))
			return false;
		return true;
	}

	
	

}

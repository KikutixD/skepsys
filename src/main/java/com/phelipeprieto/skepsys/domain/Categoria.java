package com.phelipeprieto.skepsys.domain;

import java.io.Serializable;

public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id_categoria;
	private String  nm_categoria;
	
	public Categoria() {
		
	}

	public Categoria(Integer id_categoria, String nm_categoria) {
		super();
		this.id_categoria = id_categoria;
		this.nm_categoria = nm_categoria;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNm_categoria() {
		return nm_categoria;
	}

	public void setNm_categoria(String nm_categoria) {
		this.nm_categoria = nm_categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_categoria == null) ? 0 : id_categoria.hashCode());
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
		Categoria other = (Categoria) obj;
		if (id_categoria == null) {
			if (other.id_categoria != null)
				return false;
		} else if (!id_categoria.equals(other.id_categoria))
			return false;
		return true;
	}
	
	
	
	

}

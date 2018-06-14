package com.phelipeprieto.skepsys.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_uf;
	private String nm_uf;
	
	@JsonIgnore
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades = new ArrayList<>();
	
	public Estado() {
		
	}

	public Estado(Integer id_uf, String nm_uf) {
		super();
		this.id_uf = id_uf;
		this.nm_uf = nm_uf;
	}

	public Integer getId_uf() {
		return id_uf;
	}

	public void setId_uf(Integer id_uf) {
		this.id_uf = id_uf;
	}

	public String getNm_uf() {
		return nm_uf;
	}

	public void setNm_uf(String nm_uf) {
		this.nm_uf = nm_uf;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_uf == null) ? 0 : id_uf.hashCode());
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
		Estado other = (Estado) obj;
		if (id_uf == null) {
			if (other.id_uf != null)
				return false;
		} else if (!id_uf.equals(other.id_uf))
			return false;
		return true;
	}
	
	
	
}

package com.phelipeprieto.skepsys.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_endereco;
	private String endereco_lagradouro;
	private String endereco_numero;
	private String endereco_complemento;
	private String endereco_bairrp;
	private String endereco_cep;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_cli")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private Cidade cidade;
	
	
	public Endereco() {
		
	}

	public Endereco(Integer id_endereco, String endereco_lagradouro, String endereco_numero,
			String endereco_complemento, String endereco_bairrp, String endereco_cep, Cliente cliente, Cidade cidade) {
		super();
		this.id_endereco = id_endereco;
		this.endereco_lagradouro = endereco_lagradouro;
		this.endereco_numero = endereco_numero;
		this.endereco_complemento = endereco_complemento;
		this.endereco_bairrp = endereco_bairrp;
		this.endereco_cep = endereco_cep;
		this.cliente = cliente;
		this.cidade = cidade;
	}

	public Integer getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(Integer id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getEndereco_lagradouro() {
		return endereco_lagradouro;
	}

	public void setEndereco_lagradouro(String endereco_lagradouro) {
		this.endereco_lagradouro = endereco_lagradouro;
	}

	public String getEndereco_numero() {
		return endereco_numero;
	}

	public void setEndereco_numero(String endereco_numero) {
		this.endereco_numero = endereco_numero;
	}

	public String getEndereco_complemento() {
		return endereco_complemento;
	}

	public void setEndereco_complemento(String endereco_complemento) {
		this.endereco_complemento = endereco_complemento;
	}

	public String getEndereco_bairrp() {
		return endereco_bairrp;
	}

	public void setEndereco_bairrp(String endereco_bairrp) {
		this.endereco_bairrp = endereco_bairrp;
	}

	public String getEndereco_cep() {
		return endereco_cep;
	}

	public void setEndereco_cep(String endereco_cep) {
		this.endereco_cep = endereco_cep;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_endereco == null) ? 0 : id_endereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (id_endereco == null) {
			if (other.id_endereco != null)
				return false;
		} else if (!id_endereco.equals(other.id_endereco))
			return false;
		return true;
	}
	
	

}

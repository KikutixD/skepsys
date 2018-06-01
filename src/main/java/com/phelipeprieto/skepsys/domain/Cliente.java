package com.phelipeprieto.skepsys.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.phelipeprieto.skepsys.domain.enuns.TipoCliente;

@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_cli;
	private String nm_cli;
	private String email_cli;
	private String cpfcnpj;
	private Integer tp_pessoa;
	
	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();
	
	public Cliente() {
		
	}

	public Cliente(Integer id_cli, String nm_cli, String email_cli, String cpfcnpj, TipoCliente tp_pessoa) {
		super();
		this.id_cli = id_cli;
		this.nm_cli = nm_cli;
		this.email_cli = email_cli;
		this.cpfcnpj = cpfcnpj;
		this.tp_pessoa = tp_pessoa.getId_Tppessoa();
	}

	public Integer getId_cli() {
		return id_cli;
	}

	public void setId_cli(Integer id_cli) {
		this.id_cli = id_cli;
	}

	public String getNm_cli() {
		return nm_cli;
	}

	public void setNm_cli(String nm_cli) {
		this.nm_cli = nm_cli;
	}

	public String getEmail_cli() {
		return email_cli;
	}

	public void setEmail_cli(String email_cli) {
		this.email_cli = email_cli;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tp_pessoa);
	}

	public void setTipo(TipoCliente tipo) {
		this.tp_pessoa = tipo.getId_Tppessoa();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_cli;
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
		Cliente other = (Cliente) obj;
		if (id_cli != other.id_cli)
			return false;
		return true;
	}
	
	
	
	

}

package com.phelipeprieto.skepsys.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_pv;
	private Date dt_emissao;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name="id_cli")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="id_endereco")
	private Endereco enderecoDeEntrega;
	
	public Pedido() {
		
	}

	public Pedido(Integer id_pv, Date dt_emissao, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.id_pv = id_pv;
		this.dt_emissao = dt_emissao;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public Integer getId_pv() {
		return id_pv;
	}

	public void setId_pv(Integer id_pv) {
		this.id_pv = id_pv;
	}

	public Date getDt_emissao() {
		return dt_emissao;
	}

	public void setDt_emissao(Date dt_emissao) {
		this.dt_emissao = dt_emissao;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_pv == null) ? 0 : id_pv.hashCode());
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
		Pedido other = (Pedido) obj;
		if (id_pv == null) {
			if (other.id_pv != null)
				return false;
		} else if (!id_pv.equals(other.id_pv))
			return false;
		return true;
	}
	
	
	
	
}

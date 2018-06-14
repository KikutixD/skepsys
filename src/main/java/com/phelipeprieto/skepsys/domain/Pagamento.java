package com.phelipeprieto.skepsys.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.phelipeprieto.skepsys.domain.enuns.EstadoPagamento;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pagamento implements Serializable{
	private  static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_pgto;
	private Integer estado_pgto;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name="id_pgto")
	@MapsId
	private Pedido pedido;
	
	public Pagamento() {
		
	}

	public Pagamento(Integer id_pgto, EstadoPagamento estado_pgto, Pedido pedido) {
		super();
		this.id_pgto = id_pgto;
		this.estado_pgto = estado_pgto.getId_Pgto();
		this.pedido = pedido;
	}

	public Integer getId_pgto() {
		return id_pgto;
	}

	public void setId_pgto(Integer id_pgto) {
		this.id_pgto = id_pgto;
	}

	public EstadoPagamento getEstado_pgto() {
		return EstadoPagamento.toEnum(estado_pgto);
	}

	public void setEstado_pgto(EstadoPagamento estado_pgto) {
		this.estado_pgto = estado_pgto.getId_Pgto();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_pgto == null) ? 0 : id_pgto.hashCode());
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
		Pagamento other = (Pagamento) obj;
		if (id_pgto == null) {
			if (other.id_pgto != null)
				return false;
		} else if (!id_pgto.equals(other.id_pgto))
			return false;
		return true;
	}
	
	
	

}

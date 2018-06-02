package com.phelipeprieto.skepsys.domain;

import javax.persistence.Entity;

import com.phelipeprieto.skepsys.domain.enuns.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id_pgto, EstadoPagamento estado_pgto, Pedido pedido, Integer numeroDeParcelas) {
		super(id_pgto, estado_pgto, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	

}

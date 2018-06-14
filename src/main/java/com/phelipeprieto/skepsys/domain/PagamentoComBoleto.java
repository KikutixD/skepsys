package com.phelipeprieto.skepsys.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.phelipeprieto.skepsys.domain.enuns.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagameto;
	
	public PagamentoComBoleto() {
	}

	public PagamentoComBoleto(Integer id_pgto, EstadoPagamento estado_pgto, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id_pgto, estado_pgto, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagameto = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagameto() {
		return dataPagameto;
	}

	public void setDataPagameto(Date dataPagameto) {
		this.dataPagameto = dataPagameto;
	}
	
	

}

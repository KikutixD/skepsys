package com.phelipeprieto.skepsys.domain.enuns;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(2, "Cancelado");
	
	private int id_pgto;
	private String estado_pgto;
	
	private EstadoPagamento (int id_pgto , String estado_pgto) {
		
		this.id_pgto = id_pgto;
		this.estado_pgto = estado_pgto;
	}
	
	public int getId_Pgto() {
		return id_pgto;
	}
	
	public String getEstado_Pgto() {
		return estado_pgto;
	}
	
	public static EstadoPagamento toEnum(Integer id_pgto) {
		if(id_pgto == null) {
			return null;
		}
		
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if(id_pgto.equals(x.getId_Pgto())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Invalido: "+id_pgto);
	}

}

package com.phelipeprieto.skepsys.domain.enuns;

public enum TipoCliente {

		PESSOAFISICA(1,"Pessoa Fisica"),
		PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private int id_tppessoa;
	private String nm_tppessoa;
	
	private TipoCliente (int id_tppessoa , String nm_tppessoa) {
		
		this.id_tppessoa = id_tppessoa;
		this.nm_tppessoa = nm_tppessoa;
	}
	
	public int getId_Tppessoa() {
		return id_tppessoa;
	}
	
	public String getNm_Tppessoa() {
		return nm_tppessoa;
	}
	
	public static TipoCliente toEnum(Integer id_tppessoa) {
		if(id_tppessoa == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) {
			if(id_tppessoa.equals(x.getId_Tppessoa())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Invalido: "+id_tppessoa);
	}
}

package com.phelipeprieto.skepsys.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phelipeprieto.skepsys.domain.Pedido;
import com.phelipeprieto.skepsys.repositories.PedidoRepository;
import com.phelipeprieto.skepsys.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
		
	public Pedido find(Integer id_pv) {
		Optional<Pedido> obj = repo.findById(id_pv);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Código: " + id_pv + ", Tipo: " + Pedido.class.getName()));
		}
	
 }


package com.phelipeprieto.skepsys.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phelipeprieto.skepsys.domain.Cliente;
import com.phelipeprieto.skepsys.repositories.ClienteRepository;
import com.phelipeprieto.skepsys.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
		
	public Cliente find(Integer id_cli) {
		Optional<Cliente> obj = repo.findById(id_cli);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Código: " + id_cli + ", Tipo: " + Cliente.class.getName()));
		}
	
 }


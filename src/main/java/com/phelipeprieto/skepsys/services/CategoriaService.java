package com.phelipeprieto.skepsys.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phelipeprieto.skepsys.domain.Categoria;
import com.phelipeprieto.skepsys.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id_categoria) {
		Optional<Categoria> obj = repo.findById(id_categoria);
		return obj.orElse(null);
	}
}

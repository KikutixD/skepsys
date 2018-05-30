package com.phelipeprieto.skepsys.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phelipeprieto.skepsys.domain.Categoria;
import com.phelipeprieto.skepsys.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
		

	@RequestMapping(value="/{id_categoria}" ,method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id_categoria) {
		Categoria obj = service.find(id_categoria);
		return ResponseEntity.ok().body(obj);
		
	}

}

package com.phelipeprieto.skepsys.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.jms.artemis.ArtemisNoOpBindingRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phelipeprieto.skepsys.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1, "Sistemas Web");
		Categoria cat2 = new Categoria(2, "Sistemas Desk Top");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);	
		lista.add(cat2);
		
		return lista;
	}

}

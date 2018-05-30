package com.phelipeprieto.skepsys;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phelipeprieto.skepsys.domain.Categoria;
import com.phelipeprieto.skepsys.domain.Produto;
import com.phelipeprieto.skepsys.repositories.CategoriaRepository;
import com.phelipeprieto.skepsys.repositories.ProdutoRepository;

@SpringBootApplication
public class SkepsysApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SkepsysApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "Sistemas Web");
		Categoria cat2 = new Categoria(null, "Sistemas Desk");
		
		Produto p1 = new Produto(null, "Ling.Programação",2000.00);
		Produto p2 = new Produto(null, "Ling.Front",800.00);
		Produto p3 = new Produto(null, "Software",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
	
	
}

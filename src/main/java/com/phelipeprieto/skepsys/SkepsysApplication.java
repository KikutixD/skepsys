package com.phelipeprieto.skepsys;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phelipeprieto.skepsys.domain.Categoria;
import com.phelipeprieto.skepsys.repositories.CategoriaRepository;

@SpringBootApplication
public class SkepsysApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SkepsysApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "Sistemas Web");
		Categoria cat2 = new Categoria(null, "Sistemas Desk");
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}
	
	
}

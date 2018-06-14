package com.phelipeprieto.skepsys;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phelipeprieto.skepsys.domain.Categoria;
import com.phelipeprieto.skepsys.domain.Cidade;
import com.phelipeprieto.skepsys.domain.Cliente;
import com.phelipeprieto.skepsys.domain.Endereco;
import com.phelipeprieto.skepsys.domain.Estado;
import com.phelipeprieto.skepsys.domain.ItemPedido;
import com.phelipeprieto.skepsys.domain.Pagamento;
import com.phelipeprieto.skepsys.domain.PagamentoComBoleto;
import com.phelipeprieto.skepsys.domain.PagamentoComCartao;
import com.phelipeprieto.skepsys.domain.Pedido;
import com.phelipeprieto.skepsys.domain.Produto;
import com.phelipeprieto.skepsys.domain.enuns.EstadoPagamento;
import com.phelipeprieto.skepsys.domain.enuns.TipoCliente;
import com.phelipeprieto.skepsys.repositories.CategoriaRepository;
import com.phelipeprieto.skepsys.repositories.CidadeRepository;
import com.phelipeprieto.skepsys.repositories.ClienteRepository;
import com.phelipeprieto.skepsys.repositories.EnderecoRepository;
import com.phelipeprieto.skepsys.repositories.EstadoRepository;
import com.phelipeprieto.skepsys.repositories.ItemPedidoRepository;
import com.phelipeprieto.skepsys.repositories.PagamentoRepository;
import com.phelipeprieto.skepsys.repositories.PedidoRepository;
import com.phelipeprieto.skepsys.repositories.ProdutoRepository;

@SpringBootApplication
public class SkepsysApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoReposytory;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Garça", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Phelipe Prieto", "Phelipe.prieto@skepsys.com.br", "464.870.258-10",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("14982238179", "1494713251"));
		Endereco e1 = new Endereco(null, "Rua Francisco Paranhos", "90", "Casa", "Frei Aurelio", "17400000", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:39"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoReposytory.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 2000.00, 1);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 80.00, 1);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 800.00, 2);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
	
	
}

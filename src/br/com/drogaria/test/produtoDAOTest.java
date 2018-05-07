package br.com.drogaria.test;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class produtoDAOTest {

	@Test
	@Ignore
	public void salvar(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(6L);
		
		Produto produto = new Produto();
		produto.setDescricao("Shampo");
		produto.setPreco(new BigDecimal(23.55D));
		produto.setQuantidade(30);
		produto.setFabricante(fabricante);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(3L);
		System.out.println(produto);
	}
	
	@Test
	@Ignore
	public void listar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtos = produtoDAO.listar();
		System.out.println(produtos);
	}
	
	@Test
	public void excluir(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(3L);
		produtoDAO.excluir(produto);
	}
}

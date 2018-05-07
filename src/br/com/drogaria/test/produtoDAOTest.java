package br.com.drogaria.test;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class produtoDAOTest {

	@Test
	public void inserir(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(6L);
		
		Produto produto = new Produto();
		produto.setDescricao("Shampo");
		produto.setPreco(new BigDecimal(23.55D));
		produto.setQuantidade(30);
		produto.setFabricante(fabricante);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.inserir(produto);
		
	}
}

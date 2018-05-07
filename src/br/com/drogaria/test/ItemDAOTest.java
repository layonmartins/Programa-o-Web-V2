package br.com.drogaria.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ItemDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drogaria.domain.Item;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.domain.Venda;

public class ItemDAOTest {

	@Test
	@Ignore
	public void salvar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(2L);
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(1L);
		
		Item item = new Item();
		item.setProduto(produto);
		item.setQuantidade(2);
		item.setValor(new BigDecimal(32.54D));
		item.setVenda(venda);
	
		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(item);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(1L);
		System.out.println(item);
	}

	@Test
	@Ignore
	public void listar() {
		ItemDAO itemDAO = new ItemDAO();
		List<Item> items = itemDAO.listar();
		System.out.println(items);
	}

	@Test
	@Ignore
	public void excluir() {
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(2L);
		itemDAO.excluir(item);
	}

	@Test
	@Ignore
	public void editar() {
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(1L);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(2L);
		
		item.setProduto(produto);
		item.setQuantidade(10);
		item.setValor(new BigDecimal(30.99));
		
		itemDAO.editar(item);
		
		
	}
	
}

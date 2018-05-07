package br.com.drogaria.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Venda;

public class VendaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(3L);
		
		Venda venda = new Venda();
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(34.34D));
		
		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(1L);
		System.out.println(venda);
	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> vendas = vendaDAO.listar();
		System.out.println(vendas);
	}

	@Test
	@Ignore
	public void excluir() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(2L);
		vendaDAO.excluir(venda);
	}

	@Test
	@Ignore
	public void editar() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(1L);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(4L);
		
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(50.00D));
		venda.setFuncionario(funcionario);	
		vendaDAO.editar(venda);
	}
}

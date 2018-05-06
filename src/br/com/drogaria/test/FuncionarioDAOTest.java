package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;

public class FuncionarioDAOTest {

	@Test
	@Ignore
	public void salvar(){
		Funcionario f1 = new Funcionario();
		f1.setNome("Giselle");
		f1.setCpf("11111111");
		f1.setSenha("1234");
		f1.setFuncao("Enfermeira");
		
		Funcionario f2 = new Funcionario();
		f2.setNome("Keynuella");
		f2.setCpf("2222222");
		f2.setSenha("1234");
		f2.setFuncao("Biomedica");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.salvar(f1);
		dao.salvar(f2);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();
		System.out.println(funcionarios);
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		FuncionarioDAO dao = new FuncionarioDAO(); 
		Funcionario f1 = new Funcionario();
		f1 = dao.buscarPorCodigo(1L);
		System.out.println(f1);
	}
	
	@Test
	@Ignore
	public void excluir(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario f1 = dao.buscarPorCodigo(2L);
		dao.excluir(f1);
	}
	
	@Test
	@Ignore
	public void editar(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario f1 = dao.buscarPorCodigo(3L);
		f1.setSenha("22222");
		dao.editar(f1);
	}
}

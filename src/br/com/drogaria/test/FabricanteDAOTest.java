package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	@Ignore
	public void salvar(){
		Fabricante f1 = new Fabricante();
		f1.setDescricao("descricao 1");
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("descricao 2");
		
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(f1);
		dao.salvar(f2);
	}
	
	@Test
	@Ignore
	public void listar(){
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();
		for(Fabricante fabricante : fabricantes){
			System.out.println(fabricante);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorCodigo(1L);
		Fabricante f2 = dao.buscarPorCodigo(7L);
		
		System.out.println(f1);
		System.out.println(f2);
	}
	
	@Test
	@Ignore
	public void excluir(){
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscarPorCodigo(1L);
		if(fabricante != null)
		dao.excluir(fabricante);
	}
	
	@Test
	//@Ignore
	public void excluirPorCodigo(){
		FabricanteDAO dao = new FabricanteDAO();
		dao.excluir(4L);
	}
}

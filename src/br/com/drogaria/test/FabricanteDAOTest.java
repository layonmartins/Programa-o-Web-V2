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
	public void listar(){
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();
		for(Fabricante fabricante : fabricantes){
			System.out.println(fabricante);
		}
	}
}

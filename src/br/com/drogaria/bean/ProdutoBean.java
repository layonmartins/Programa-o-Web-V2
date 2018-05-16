package br.com.drogaria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto produtoCadastro;
	private List<Produto> listaProdutos;
	private List<Produto> listaProdutosFiltrados;
	private String acao;
	private Long codigo;
	private List<Fabricante> listaFabricantes;
	
	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}
	
	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Produto> getListaProdutosFiltrados() {
		return listaProdutosFiltrados;
	}

	public void setListaProdutosFiltrados(List<Produto> listaProdutosFiltrados) {
		this.listaProdutosFiltrados = listaProdutosFiltrados;
	}

	public Produto getProdutoCadastro() {
		return produtoCadastro;
	}

	public void setProdutoCadastro(Produto produtoCadastro) {
		this.produtoCadastro = produtoCadastro;
	}

	public void novo() {
		produtoCadastro = new Produto();
	}

	public void salvar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.salvar(produtoCadastro);
			produtoCadastro = new Produto();
			FacesUtil.addMsgInfo("Produto salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar incluir um Produto: " + e.getMessage());
		}
	}
	
	public void carregarPesquisa() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			listaProdutos = produtoDAO.listar();
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar listar os Produtos: " + e.getMessage());
		}
	}
	
	public void carregarCadastro() {
		try {
			if(codigo != null) {
				ProdutoDAO produtoDAO = new ProdutoDAO();
				produtoCadastro = produtoDAO.buscarPorCodigo(codigo);
			} else {
				produtoCadastro = new Produto();
			}
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			listaFabricantes = fabricanteDAO.listar();
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar obter os dados do Produto: " + e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produtoCadastro);
			produtoCadastro = new Produto();
			FacesUtil.addMsgInfo("Produto excluido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar excluir um Produto: " + e.getMessage());
		}

	}
	
	public void editar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.editar(produtoCadastro);
			produtoCadastro = new Produto();
			FacesUtil.addMsgInfo("Produto editado com sucesso");
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar editar um Produto: " + e.getMessage());
		}
	}
	
}

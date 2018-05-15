package br.com.drogaria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricanteCadastro;
	private List<Fabricante> listaFabricantes;
	private List<Fabricante> listaFabricantesFiltrados;
	private String acao;
	private Long codigo;
	
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

	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	public List<Fabricante> getListaFabricantesFiltrados() {
		return listaFabricantesFiltrados;
	}

	public void setListaFabricantesFiltrados(List<Fabricante> listaFabricantesFiltrados) {
		this.listaFabricantesFiltrados = listaFabricantesFiltrados;
	}

	public Fabricante getFabricanteCadastro() {
		return fabricanteCadastro;
	}

	public void setFabricanteCadastro(Fabricante fabricanteCadastro) {
		this.fabricanteCadastro = fabricanteCadastro;
	}

	public void novo() {
		fabricanteCadastro = new Fabricante();
	}

	public void salvar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.salvar(fabricanteCadastro);
			fabricanteCadastro = new Fabricante();
			FacesUtil.addMsgInfo("Fabricante salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar incluir um Fabricante: " + e.getMessage());
		}
	}
	
	public void carregarPesquisa() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			listaFabricantes = fabricanteDAO.listar();
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar listar os Fabricantes: " + e.getMessage());
		}
	}
	
	public void carregarCadastro() {
		try {
			if(codigo != null) {
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				fabricanteCadastro = fabricanteDAO.buscarPorCodigo(codigo);
			} else {
				fabricanteCadastro = new Fabricante();
			}
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar obter os dados do Fabricante: " + e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricanteCadastro);
			fabricanteCadastro = new Fabricante();
			FacesUtil.addMsgInfo("Fabricante salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar incluir um Fabricante: " + e.getMessage());
		}

	}
	
	public void editar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.editar(fabricanteCadastro);
			fabricanteCadastro = new Fabricante();
			FacesUtil.addMsgInfo("Fabricante salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar editar um Fabricante: " + e.getMessage());
		}
	}
	
}

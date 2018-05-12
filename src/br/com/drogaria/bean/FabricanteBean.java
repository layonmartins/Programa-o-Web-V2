package br.com.drogaria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {
	
	private Fabricante fabricanteCadastro;
	
	public Fabricante getFabricanteCadastro() {
		if(fabricanteCadastro == null) {
			fabricanteCadastro = new Fabricante();
		}
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
}

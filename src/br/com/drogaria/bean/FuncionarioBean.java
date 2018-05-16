package br.com.drogaria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {

	private Funcionario funcionarioCadastro;
	private List<Funcionario> listaFuncionarios;
	private List<Funcionario> listaFuncionariosFiltrados;
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

	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	public List<Funcionario> getListaFuncionariosFiltrados() {
		return listaFuncionariosFiltrados;
	}

	public void setListaFuncionariosFiltrados(List<Funcionario> listaFuncionariosFiltrados) {
		this.listaFuncionariosFiltrados = listaFuncionariosFiltrados;
	}

	public Funcionario getFuncionariosCadastro() {
		return funcionarioCadastro;
	}

	public void setFuncionariosCadastro(Funcionario funcionarioCadastro) {
		this.funcionarioCadastro = funcionarioCadastro;
	}

	public void novo() {
		funcionarioCadastro = new Funcionario();
	}

	public void salvar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.salvar(funcionarioCadastro);
			funcionarioCadastro = new Funcionario();
			FacesUtil.addMsgInfo("Fabricante salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar incluir um Funcionario: " + e.getMessage());
		}
	}
	
	public void carregarPesquisa() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			listaFuncionarios = funcionarioDAO.listar();
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar listar os Funcionario: " + e.getMessage());
		}
	}
	
	public void carregarCadastro() {
		try {
			if(codigo != null) {
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				funcionarioCadastro = funcionarioDAO.buscarPorCodigo(codigo);
			} else {
				funcionarioCadastro = new Funcionario();
			}
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar obter os dados do Funcionario: " + e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.excluir(funcionarioCadastro);
			funcionarioCadastro = new Funcionario();
			FacesUtil.addMsgInfo("Funcionario salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar incluir um Funcionario: " + e.getMessage());
		}

	}
	
	public void editar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.editar(funcionarioCadastro);
			funcionarioCadastro = new Funcionario();
			FacesUtil.addMsgInfo("Funcionario editado com sucesso");
		} catch (Exception e) {
			FacesUtil.addMsgErro("Erro ao tentar editar um Funcionario: " + e.getMessage());
		}
	}
	
}

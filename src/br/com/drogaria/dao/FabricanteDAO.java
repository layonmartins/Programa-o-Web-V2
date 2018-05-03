package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.HibernateUtil;

public class FabricanteDAO {

	public void salvar(Fabricante fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(fabricante);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Fabricante> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Fabricante> fabricantes = null;
		try {
			Query<Fabricante> consulta = sessao.getNamedQuery("Fabricante.listar");
			fabricantes = consulta.list();
		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}
		return fabricantes;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Fabricante buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Fabricante fabricante = null;
		try {
			Query<Fabricante> consulta = sessao.getNamedQuery("Fabricante.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			fabricante = (Fabricante) consulta.uniqueResult();
		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}
		return fabricante;
	}

	public void excluir(Fabricante fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(fabricante);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			sessao.close();
		}
	}

	public void excluir(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			Fabricante fabricante = buscarPorCodigo(codigo);
			sessao.delete(fabricante);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			sessao.close();
		}
	}
	
	public void editar(Fabricante fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			
			//# Ter certeza que todos os dados do fabricante (transiente) estão preenchidos
			// Fabricante fabricanteEditar =
			// buscarPorCodigo(fabricante.getCodigo());
			// fabricanteEditar.setDescricao(fabricante.getDescricao());
			// sessao.update(fabricanteEditar);
			
			sessao.update(fabricante);
			
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			sessao.close();
		}
	}

}

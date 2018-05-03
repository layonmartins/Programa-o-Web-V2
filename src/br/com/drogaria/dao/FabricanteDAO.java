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

}

package br.senac.criancaemfoco.modelo.dao.papel;

import br.senac.criancaemfoco.modelo.entidade.papel.Papel;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

import org.hibernate.Session;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public class PapelDAOImpl implements PapelDAO {

	private final ConexaoFactory fabrica;

	public PapelDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	private void erroSessao(Session sessao, Exception exception) {
		exception.printStackTrace();
		if (sessao.getTransaction() != null) {
			sessao.getTransaction().rollback();
		}
	}

	private void fecharSessao(Session sessao) {
		if (sessao != null) {
			sessao.close();
		}
	}

	private Session abrirSessao(Session sessao) {
		sessao = fabrica.getConexao().openSession();
		sessao.beginTransaction();
		return sessao;
	}

	public void inserirPapel(Papel Papel) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(Papel);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarPapel(Papel Papel) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(Papel);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarPapel(Papel Papel) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(Papel);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}


	public Papel recuperarPapel(Papel papel) {
		Session sessao = null;
		Papel papelRecuperado = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Papel> criteria = construtor.createQuery(Papel.class);
			Root<Papel> raizPapel = criteria.from(Papel.class);
			criteria.select(raizPapel);
			ParameterExpression<Long> idPapel = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizPapel.get("id"), idPapel));
			papelRecuperado = sessao.createQuery(criteria).setParameter(idPapel, papel.getId()).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}

		return papelRecuperado;
	}


	public List<Papel> recuperarPapeis() {
		Session sessao = null;
		List<Papel> papeis = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Papel> criteria = construtor.createQuery(Papel.class);
			Root<Papel> raizCliente = criteria.from(Papel.class);
			criteria.select(raizCliente);
			papeis = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return papeis;
	}
}

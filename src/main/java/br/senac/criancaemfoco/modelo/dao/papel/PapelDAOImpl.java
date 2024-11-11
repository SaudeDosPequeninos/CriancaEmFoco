package br.senac.criancaemfoco.modelo.dao.papel;

import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;
import br.senac.criancaemfoco.modelo.entidade.papel.Papel;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

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

	public Papel recuperarPapel(Long id) {
		Session sessao = null;
		Papel papel = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Papel> criteria = construtor.createQuery(Papel.class);
			Root<Papel> raizCliente = criteria.from(Papel.class);
			criteria.select(raizCliente).where(construtor.equal(raizCliente.get("id"), id));
			papel = sessao.createQuery(criteria).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return papel;
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

package br.senac.criancaemfoco.modelo.dao.estoque;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.criancaemfoco.modelo.entidade.estoque.Estoque;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

public class EstoqueDAOImpl implements EstoqueDAO {

	private final ConexaoFactory fabrica;

	public EstoqueDAOImpl() {
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

	public void inserirEstoque(Estoque estoque) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(estoque);
			sessao.getTransaction().commit();

		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarEstoque(Estoque estoque) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(estoque);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarEstoque(Estoque estoque) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(estoque);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public List<Estoque> recuperarEstoques() {
		Session sessao = null;
		List<Estoque> estoques = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Estoque> criteria = construtor.createQuery(Estoque.class);
			Root<Estoque> raizCliente = criteria.from(Estoque.class);
			criteria.select(raizCliente);
			estoques = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return estoques;
	}
}
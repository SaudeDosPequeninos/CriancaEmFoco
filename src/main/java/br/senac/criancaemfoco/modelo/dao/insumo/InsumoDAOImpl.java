package br.senac.criancaemfoco.modelo.dao.insumo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.criancaemfoco.modelo.entidade.insumo.Insumo;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

public class InsumoDAOImpl implements InsumoDAO {

	private final ConexaoFactory fabrica;

	public InsumoDAOImpl() {
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

	public void inserirInsumo(Insumo insumo) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(insumo);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarInsumo(Insumo insumo) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(insumo);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarInsumo(Insumo insumo) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(insumo);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public Insumo recuperarInsumo(Insumo insumo) {
		Session sessao = null;
		Insumo insumoRecuperado = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Insumo> criteria = construtor.createQuery(Insumo.class);
			Root<Insumo> raizInsumo = criteria.from(Insumo.class);
			criteria.select(raizInsumo);
			ParameterExpression<Long> idInsumo = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizInsumo.get("id"), idInsumo));
			insumoRecuperado = sessao.createQuery(criteria).setParameter(idInsumo, insumo.getId()).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return insumoRecuperado;
	}

	public List<Insumo> recuperarInsumos() {
		Session sessao = null;
		List<Insumo> insumos = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Insumo> criteria = construtor.createQuery(Insumo.class);
			Root<Insumo> raizCliente = criteria.from(Insumo.class);
			criteria.select(raizCliente);
			insumos = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return insumos;
	}
}
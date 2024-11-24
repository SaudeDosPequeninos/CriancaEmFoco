package br.senac.criancaemfoco.modelo.dao.procedimento;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.criancaemfoco.modelo.entidade.procedimento.Procedimento;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

public class ProcedimentoDAOImpl implements ProcedimentoDAO {

	private ConexaoFactory fabrica;

	public ProcedimentoDAOImpl() {
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

	public void inserirProcedimento(Procedimento procedimento) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(procedimento);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void removerProcedimento(Procedimento procedimento) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(procedimento);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarProcedimento(Procedimento procedimento) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(procedimento);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public Procedimento recuperarProcedimento(Procedimento procedimento) {
		Session sessao = null;
		Procedimento procedimentoRecuperado = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Procedimento> criteria = construtor.createQuery(Procedimento.class);
			Root<Procedimento> raizProcedimento = criteria.from(Procedimento.class);
			criteria.select(raizProcedimento);
			ParameterExpression<Long> idProcedimento = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizProcedimento.get("id"), idProcedimento));
			procedimentoRecuperado = sessao.createQuery(criteria).setParameter(idProcedimento, procedimento.getId()).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return procedimentoRecuperado;
	}

	public List<Procedimento> recuperarProcedimentos() {
		Session sessao = null;
		List<Procedimento> procedimentos = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Procedimento> criteria = construtor.createQuery(Procedimento.class);
			Root<Procedimento> raizProcedimento = criteria.from(Procedimento.class);
			criteria.select(raizProcedimento);
			procedimentos = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return procedimentos;
	}
}
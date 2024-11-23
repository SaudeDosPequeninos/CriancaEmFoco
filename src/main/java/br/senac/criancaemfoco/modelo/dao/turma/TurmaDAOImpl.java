package br.senac.criancaemfoco.modelo.dao.turma;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.criancaemfoco.modelo.entidade.turma.Turma;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

public class TurmaDAOImpl implements TurmaDAO {

	private final ConexaoFactory fabrica;

	public TurmaDAOImpl() {
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

	public void inserirTurma(Turma turma) {
		Session sessao = null;

		try {
			sessao = abrirSessao(sessao);
			sessao.save(turma);
			sessao.getTransaction().commit();

		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarTurma(Turma turma) {
		Session sessao = null;

		try {
			sessao = abrirSessao(sessao);
			sessao.delete(turma);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarTurma(Turma turma) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(turma);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public Turma recuperarTurma(Turma turma) {
		Session sessao = null;
		Turma turmaRecuperado = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Turma> criteria = construtor.createQuery(Turma.class);
			Root<Turma> raizTurma = criteria.from(Turma.class);
			criteria.select(raizTurma);
			ParameterExpression<Long> idTurma = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizTurma.get("id"), idTurma));
			turmaRecuperado = sessao.createQuery(criteria).setParameter(idTurma, turma.getId()).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return turmaRecuperado;
	}

	public List<Turma> recuperarTurmas() {
		Session sessao = null;
		List<Turma> turmas = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Turma> criteria = construtor.createQuery(Turma.class);
			Root<Turma> raizTurma = criteria.from(Turma.class);
			criteria.select(raizTurma);
			turmas = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return turmas;
	}
}
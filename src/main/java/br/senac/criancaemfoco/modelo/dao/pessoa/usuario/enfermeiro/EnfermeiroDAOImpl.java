package br.senac.criancaemfoco.modelo.dao.pessoa.usuario.enfermeiro;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.criancaemfoco.modelo.entidade.agendamento.Agendamento;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.enfermeiro.Enfermeiro;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

public class EnfermeiroDAOImpl implements EnfermeiroDAO {

	private final ConexaoFactory fabrica;

	public EnfermeiroDAOImpl() {
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

	public void inserirEnfermeiro(Enfermeiro enfermeiro) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(enfermeiro);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarEnfermeiro(Enfermeiro enfermeiro) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(enfermeiro);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarEnfermeiro(Enfermeiro enfermeiro) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(enfermeiro);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public Enfermeiro recuperarEnfermeiro(Enfermeiro enfermeiro) {
		Session sessao = null;
		Enfermeiro enfermeiroRecuperado = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Enfermeiro> criteria = construtor.createQuery(Enfermeiro.class);
			Root<Enfermeiro> raizEnfermeiro = criteria.from(Enfermeiro.class);
			criteria.select(raizEnfermeiro);
			ParameterExpression<Long> idEnfermeiro = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizEnfermeiro.get("id"), idEnfermeiro));
			enfermeiroRecuperado = sessao.createQuery(criteria).setParameter(idEnfermeiro, enfermeiro.getId()).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return enfermeiroRecuperado;
	}

	public List<Enfermeiro> recuperarEnfermeiros() {
		Session sessao = null;
		List<Enfermeiro> enfermeiro = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Enfermeiro> criteria = construtor.createQuery(Enfermeiro.class);
			Root<Enfermeiro> raizCliente = criteria.from(Enfermeiro.class);
			criteria.select(raizCliente);
			enfermeiro = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return enfermeiro;
	}

	public List<Enfermeiro> recuperarEnfermeirosAgendamento(Agendamento agendamento) {
		Session sessao = null;
		List<Enfermeiro> enfermeiros = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Enfermeiro> criteria = construtor.createQuery(Enfermeiro.class);
			Root<Enfermeiro> raizEnfermeiro = criteria.from(Enfermeiro.class);
			Join<Enfermeiro, Agendamento> juncaoAgendamento = raizEnfermeiro.join("agendamento");
			criteria.where(construtor.equal(juncaoAgendamento.get("id"), agendamento.getId()));
			enfermeiros = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return enfermeiros;
	}
}

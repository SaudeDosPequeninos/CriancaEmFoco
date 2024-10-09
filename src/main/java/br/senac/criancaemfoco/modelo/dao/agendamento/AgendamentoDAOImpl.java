package br.senac.criancaemfoco.modelo.dao.agendamento;

import br.senac.criancaemfoco.modelo.entidade.agendamento.Agendamento;
import br.senac.criancaemfoco.modelo.entidade.agendamento.Agendamento_;
import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;
import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno_;
import br.senac.criancaemfoco.modelo.entidade.pessoa.enfermeiro.Enfermeiro;
import br.senac.criancaemfoco.modelo.entidade.pessoa.enfermeiro.Enfermeiro_;
import br.senac.criancaemfoco.modelo.entidade.procedimento.Procedimento;
import br.senac.criancaemfoco.modelo.entidade.procedimento.Procedimento_;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class AgendamentoDAOImpl implements AgendamentoDAO {

	private final ConexaoFactory fabrica;

	public AgendamentoDAOImpl() {
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

	public void inserirAgendamento(Agendamento agendamento) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(agendamento);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarAgendamento(Agendamento agendamento) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(agendamento);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarAgendamento(Agendamento agendamento) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(agendamento);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public List<Agendamento> recuperarAgendamentos() {
		Session sessao = null;
		List<Agendamento> agendamentos = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Agendamento> criteria = construtor.createQuery(Agendamento.class);
			Root<Agendamento> raizAgendamento = criteria.from(Agendamento.class);

			criteria.select(raizAgendamento);
			agendamentos = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return agendamentos;
	}

	public Agendamento recuperarAgendamentoAluno(Aluno aluno) {
		Session sessao = null;
		Agendamento agendamento = null;
		try {
			sessao = abrirSessao(sessao);

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Agendamento> criteria = construtor.createQuery(Agendamento.class);
			Root<Agendamento> raizAgendamento = criteria.from(Agendamento.class);

			Join<Agendamento, Aluno> juncaoAluno = raizAgendamento.join(Agendamento_.aluno);
			ParameterExpression<String> cpfAluno = construtor.parameter(String.class);

			criteria.where(construtor.equal(juncaoAluno.get(Aluno_.CPF), cpfAluno));
			agendamento = sessao.createQuery(criteria).setParameter(cpfAluno, aluno.getCpf()).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return agendamento;
	}

	public Agendamento recuperarAgendamentoEnfermeiro(Enfermeiro enfermeiro) {
		Session sessao = null;
		Agendamento agendamento = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Agendamento> criteria = construtor.createQuery(Agendamento.class);
			Root<Agendamento> raizAgendamento = criteria.from(Agendamento.class);
			Join<Agendamento, Enfermeiro> juncaoEnfermeiro = raizAgendamento.join(Agendamento_.enfermeiro);
			ParameterExpression<String> cpfEnfermeiro = construtor.parameter(String.class);
			criteria.where(construtor.equal(juncaoEnfermeiro.get(Enfermeiro_.CPF), cpfEnfermeiro));
			agendamento = sessao.createQuery(criteria).setParameter(cpfEnfermeiro, enfermeiro.getCpf())
					.getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return agendamento;
	}

	public List<Agendamento> recuperarAgendamentosProcedimento(Procedimento procedimento) {
		Session sessao = null;
		List<Agendamento> agendamentos = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Agendamento> criteria = construtor.createQuery(Agendamento.class);
			Root<Agendamento> raizAgendamento = criteria.from(Agendamento.class);
			Join<Agendamento, Procedimento> juncaoProcedimento = raizAgendamento.join(Agendamento_.procedimentos);
			ParameterExpression<Long> idProcedimento = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoProcedimento.get(Procedimento_.ID), idProcedimento));
			agendamentos = sessao.createQuery(criteria).setParameter(idProcedimento, procedimento.getId())
					.getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return agendamentos;
	}
}
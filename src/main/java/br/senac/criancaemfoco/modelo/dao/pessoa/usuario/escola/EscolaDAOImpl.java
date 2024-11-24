package br.senac.criancaemfoco.modelo.dao.pessoa.usuario.escola;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.endereco.Endereco;
import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.enfermeiro.Enfermeiro;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.escola.Escola;
import br.senac.criancaemfoco.modelo.entidade.turma.Turma;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

public class EscolaDAOImpl implements EscolaDAO {

	private final ConexaoFactory fabrica;

	public EscolaDAOImpl() {
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

	public void inserirEscola(Escola escola) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(escola);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarEscola(Escola escola) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(escola);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarEscola(Escola escola) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(escola);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public Escola recuperarEscola(Escola escola) {
		Session sessao = null;
		Escola escolaRecuperado = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Escola> criteria = construtor.createQuery(Escola.class);
			Root<Escola> raizEscola = criteria.from(Escola.class);
			criteria.select(raizEscola);
			ParameterExpression<Long> idEscola = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizEscola.get("id"), idEscola));
			escolaRecuperado = sessao.createQuery(criteria).setParameter(idEscola, escola.getId()).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return escolaRecuperado;
	}

	public List<Escola> recuperarEscolas() {
		Session sessao = null;
		List<Escola> escolas = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Escola> criteria = construtor.createQuery(Escola.class);
			Root<Escola> raizEscola = criteria.from(Escola.class);
			criteria.select(raizEscola);
			escolas = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return escolas;
	}

	public List<Escola> recuperarEscolasAluno(Aluno aluno) {
		Session sessao = null;
		List<Escola> escolas = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Escola> criteria = construtor.createQuery(Escola.class);
			Root<Escola> raizEscola = criteria.from(Escola.class);
			Join<Escola, Aluno> juncaoAluno = raizEscola.join("aluno");
			criteria.where(construtor.equal(juncaoAluno.get("id"), aluno.getId()));
			escolas = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return escolas;
	}

	public List<Escola> recuperarEscolasEndereco(Endereco endereco) {
		Session sessao = null;
		List<Escola> escolas = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Escola> criteria = construtor.createQuery(Escola.class);
			Root<Escola> raizEscola = criteria.from(Escola.class);
			criteria.where(construtor.equal(raizEscola.get("endereco"), endereco));
			escolas = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return escolas;
	}

	public List<Escola> recuperarEscolasTurma(Turma turma) {
		Session sessao = null;
		List<Escola> escolas = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Escola> criteria = construtor.createQuery(Escola.class);
			Root<Escola> raizEscola = criteria.from(Escola.class);
			Join<Escola, Turma> juncaoTurma = raizEscola.join("turma");
			criteria.where(construtor.equal(juncaoTurma.get("id"), turma.getId()));
			escolas = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return escolas;
	}

	public List<Escola> recuperarEscolasEnfermeiro(Enfermeiro enfermeiro) {
		Session sessao = null;
		List<Escola> escolas = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Escola> criteria = construtor.createQuery(Escola.class);
			Root<Escola> raizEscola = criteria.from(Escola.class);
			Join<Escola, Enfermeiro> juncaoEnfermeiro = raizEscola.join("enfermeiro");
			criteria.where(construtor.equal(juncaoEnfermeiro.get("id"), enfermeiro.getId()));
			escolas = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return escolas;
	}

	public List<Escola> recuperarEscolasContato(Contato contato) {
		Session sessao = null;
		List<Escola> escolas = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Escola> criteria = construtor.createQuery(Escola.class);
			Root<Escola> raizEscola = criteria.from(Escola.class);
			criteria.where(construtor.equal(raizEscola.get("contato"), contato));
			escolas = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return escolas;
	}
}
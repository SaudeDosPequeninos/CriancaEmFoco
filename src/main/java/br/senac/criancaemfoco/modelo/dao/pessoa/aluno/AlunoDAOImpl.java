package br.senac.criancaemfoco.modelo.dao.pessoa.aluno;

import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;
import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;
import br.senac.criancaemfoco.modelo.entidade.pessoa.responsavel.Responsavel;
import br.senac.criancaemfoco.modelo.entidade.escola.Escola;
import br.senac.criancaemfoco.modelo.entidade.turma.Turma;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {

	private ConexaoFactory fabrica;

	public AlunoDAOImpl() {
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

	public void inserirAluno(Aluno aluno) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(aluno);
			sessao.getTransaction().commit();

		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarAluno(Aluno aluno) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(aluno);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarAluno(Aluno aluno) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(aluno);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public List<Aluno> recuperarAlunoTurma(Turma turma) {
		Session sessao = null;
		List<Aluno> alunos = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);
			Join<Aluno, Turma> juncaoTurma = raizAluno.join("turma");
			criteria.where(construtor.equal(juncaoTurma.get("id"), turma.getId()));
			alunos = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return alunos;
	}

	public List<Aluno> recuperarAlunoResponsavel(Responsavel responsavel) {
		Session sessao = null;
		List<Aluno> alunos = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);
			Join<Aluno, Responsavel> juncaoResponsavel = raizAluno.join("responsavel");
			criteria.where(construtor.equal(juncaoResponsavel.get("id"), responsavel.getId()));
			alunos = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return alunos;
	}

	public List<Aluno> recuperarAlunoEscola(Escola escola) {
		Session sessao = null;
		List<Aluno> alunos = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);
			Join<Aluno, Escola> juncaoEscola = raizAluno.join("escola");
			criteria.where(construtor.equal(juncaoEscola.get("id"), escola.getId()));
			alunos = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return alunos;
	}
}
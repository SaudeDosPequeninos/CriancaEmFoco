package br.senac.criancaemfoco.modelo.dao.pessoa.responsavel;

import org.hibernate.Session;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.senac.criancaemfoco.modelo.entidade.pessoa.responsavel.Responsavel;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

public class ResponsavelDAOImpl implements ResponsavelDAO {

	private ConexaoFactory fabrica;

	public ResponsavelDAOImpl() {
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

	public void inserirResponsavel(Responsavel responsavel) {
		Session sessao = null;

		try {
			sessao = abrirSessao(sessao);
			sessao.save(responsavel);
			sessao.getTransaction().commit();

		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}

	}

	public void deletarResponsavel(Responsavel responsavel) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(responsavel);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarResponsavel(Responsavel responsavel) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(responsavel);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public List<Responsavel> recuperarResponsavel() {

		Session sessao = null;
		List<Responsavel> responsavel = null;

		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Responsavel> criteria = construtor.createQuery(Responsavel.class);
			Root<Responsavel> raizResponsavel = criteria.from(Responsavel.class);
			criteria.select(raizResponsavel);
			responsavel = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		}  catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return responsavel;
	}
}
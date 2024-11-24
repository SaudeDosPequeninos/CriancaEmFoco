package br.senac.criancaemfoco.modelo.dao.contato;

import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

import org.hibernate.Session;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public class ContatoDAOImpl implements ContatoDAO {

	private final ConexaoFactory fabrica;

	public ContatoDAOImpl() {
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

	public void inserirContato(Contato contato) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(contato);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarContato(Contato contato) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(contato);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarContato(Contato contato) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(contato);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public Contato recuperarContato(Contato contato) {
		Session sessao = null;
		Contato contatoRecuperado = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
			Root<Contato> raizContato = criteria.from(Contato.class);
			criteria.select(raizContato);
			ParameterExpression<Long> idContato = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizContato.get("id"), idContato));
			contatoRecuperado = sessao.createQuery(criteria).setParameter(idContato, contato.getId()).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return contatoRecuperado;
	}

	public List<Contato> recuperarContatos() {
		Session sessao = null;
		List<Contato> contatos = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
			Root<Contato> raizCliente = criteria.from(Contato.class);
			criteria.select(raizCliente);
			contatos = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return contatos;
	}
}

package br.senac.criancaemfoco.modelo.dao.pessoa;

import br.senac.criancaemfoco.modelo.entidade.pessoa.Pessoa;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

public class PessoaDAOImpl implements PessoaDAO {

	private final ConexaoFactory fabrica;

	PessoaDAOImpl() {
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

	public void inserirPessoa(Pessoa pessoa) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(pessoa);
			sessao.getTransaction().commit();

		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarPessoa(Pessoa pessoa) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(pessoa);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarPessoa(Pessoa pessoa) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(pessoa);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public List<Pessoa> recuperarPessoas() {
		Session sessao = null;
		List<Pessoa> pessoas = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Pessoa> criteria = construtor.createQuery(Pessoa.class);
			Root<Pessoa> raizCliente = criteria.from(Pessoa.class);
			criteria.select(raizCliente);
			pessoas = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return pessoas;
	}
}
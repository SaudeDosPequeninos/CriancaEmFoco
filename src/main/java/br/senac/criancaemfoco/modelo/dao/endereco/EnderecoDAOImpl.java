package br.senac.criancaemfoco.modelo.dao.endereco;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.criancaemfoco.modelo.entidade.endereco.Endereco;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

public class EnderecoDAOImpl implements EnderecoDAO {

	private ConexaoFactory fabrica;

	public EnderecoDAOImpl() {
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

	public void inserirEndereco(Endereco endereco) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(endereco);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarEndereco(Endereco endereco) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(endereco);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarEndereco(Endereco endereco) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(endereco);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public Endereco recuperarEndereco(Endereco endereco) {
		Session sessao = null;
		Endereco enderecoRecuperado = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
			Root<Endereco> raizEndereco = criteria.from(Endereco.class);
			criteria.select(raizEndereco);
			ParameterExpression<Long> idEndereco = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizEndereco.get("id"), idEndereco));
			enderecoRecuperado = sessao.createQuery(criteria).setParameter(idEndereco, endereco.getId()).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return enderecoRecuperado;
	}

	public List<Endereco> recuperarEnderecos() {
		Session sessao = null;
		List<Endereco> enderecos = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
			Root<Endereco> raizEndereco = criteria.from(Endereco.class);
			criteria.select(raizEndereco);
			enderecos = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return enderecos;
	}
}
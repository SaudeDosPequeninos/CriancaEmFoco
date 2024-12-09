package br.senac.criancaemfoco.modelo.dao.foto;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.criancaemfoco.modelo.entidade.foto.Foto;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

public class FotoDAOImpl implements FotoDAO {

	private final ConexaoFactory fabrica;
	
	public FotoDAOImpl() {
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

	public void inserirFoto(Foto foto) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(foto);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarFoto(Foto foto) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(foto);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarFoto(Foto foto) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(foto);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public Foto recuperarFoto(Foto foto) {
		Session sessao = null;
		Foto fotoRecuperada = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
			Root<Foto> raizFoto = criteria.from(Foto.class);
			criteria.select(raizFoto);
			ParameterExpression<Long> idFoto = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizFoto.get("id"), idFoto));
			fotoRecuperada = sessao.createQuery(criteria).setParameter(idFoto, foto.getId()).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return fotoRecuperada;
	}

	public List<Foto> recuperarFotos() {
		Session sessao = null;
		List<Foto> fotos = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
			Root<Foto> raizFoto = criteria.from(Foto.class);
			criteria.select(raizFoto);
			fotos = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return fotos;
	}

}
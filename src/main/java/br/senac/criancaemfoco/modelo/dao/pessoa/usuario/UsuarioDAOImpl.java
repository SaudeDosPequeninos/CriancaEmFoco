package br.senac.criancaemfoco.modelo.dao.pessoa.usuario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.Usuario;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.enfermeiro.Enfermeiro;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.escola.Escola;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.responsavel.Responsavel;
import br.senac.criancaemfoco.modelo.factory.ConexaoFactory;

public class UsuarioDAOImpl implements UsuarioDAO {

	private ConexaoFactory fabrica;

	public UsuarioDAOImpl() {
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

	public void inserirUsuario(Usuario usuario) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(usuario);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}

	}

	public void deletarUsuario(Usuario usuario) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.remove(usuario);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}

	}

	public void atualizarUsuario(Usuario usuario) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(usuario);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}

	}

	public List<Usuario> recuperarUsuarios() {
		Session sessao = null;
		List<Usuario> usuarios = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
			criteria.select(raizUsuario);
			usuarios = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return usuarios;
	}

	public boolean usuarioResponsavelExistente(String email, String senha) {
		Session sessao = null;
		try {
 
				sessao = abrirSessao(sessao);
				
				CriteriaBuilder construtor = sessao.getCriteriaBuilder();
				
				CriteriaQuery<Long> criteriaUsuario = construtor.createQuery(Long.class);
				Root<Usuario> raizUsuario = criteriaUsuario.from(Usuario.class);
				Root<Responsavel> raizResponsavel = criteriaUsuario.from(Responsavel.class);
				
				
				criteriaUsuario.select(construtor.count(raizUsuario))
					.where(construtor.equal(raizUsuario.get("id"), raizResponsavel.get("id")),
					construtor.equal(raizUsuario.get("email"), email),
					construtor.equal(raizUsuario.get("senha"), senha));
				
				Long totalUsuarios = sessao.createQuery(criteriaUsuario).getSingleResult();
				
				if (totalUsuarios > 0) {
					return true;
				}
				
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		}finally {
			fecharSessao(sessao);
		}
		
		return false;
	}
	
	public boolean usuarioEnfermeiroExistente(String email, String senha) {
		Session sessao = null;
		try {
 
				sessao = abrirSessao(sessao);
				
				CriteriaBuilder construtor = sessao.getCriteriaBuilder();
				
				CriteriaQuery<Long> criteriaUsuario = construtor.createQuery(Long.class);
				Root<Usuario> raizUsuario = criteriaUsuario.from(Usuario.class);
				Root<Enfermeiro> raizEnfermeiro = criteriaUsuario.from(Enfermeiro.class);
				
				
				criteriaUsuario.select(construtor.count(raizUsuario))
					.where(construtor.equal(raizUsuario.get("id"), raizEnfermeiro.get("id")),
					construtor.equal(raizUsuario.get("email"), email),
					construtor.equal(raizUsuario.get("senha"), senha));
				
				Long totalUsuarios = sessao.createQuery(criteriaUsuario).getSingleResult();
				
				if (totalUsuarios > 0) {
					return true;
				}
				
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		}finally {
			fecharSessao(sessao);
		}
		
		return false;
	}
	
	public boolean usuarioEscolaExistente(String email, String senha) {
		Session sessao = null;
		try {
 
				sessao = abrirSessao(sessao);
				
				CriteriaBuilder construtor = sessao.getCriteriaBuilder();
				
				CriteriaQuery<Long> criteriaUsuario = construtor.createQuery(Long.class);
				Root<Usuario> raizUsuario = criteriaUsuario.from(Usuario.class);
				Root<Escola> raizEscola= criteriaUsuario.from(Escola.class);
				
				
				criteriaUsuario.select(construtor.count(raizUsuario))
					.where(construtor.equal(raizUsuario.get("id"), raizEscola.get("id")),
					construtor.equal(raizUsuario.get("email"), email),
					construtor.equal(raizUsuario.get("senha"), senha));
				
				Long totalUsuarios = sessao.createQuery(criteriaUsuario).getSingleResult();
				
				if (totalUsuarios > 0) {
					return true;
				}
				
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		}finally {
			fecharSessao(sessao);
		}
		
		return false;
	}

}
package br.senac.criancaemfoco.modelo.dao.pessoa.usuario;
 
import java.util.List;
 
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
 
import org.hibernate.Session;
 
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.Usuario;
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

	public Usuario recuperarUsuario(Usuario usuario) {
		Session sessao = null;
		Usuario usuarioRecuperado = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
			criteria.select(raizUsuario);
			ParameterExpression<Long> idUsuario = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizUsuario.get("id"), idUsuario));
			usuarioRecuperado = sessao.createQuery(criteria).setParameter(idUsuario, usuario.getId()).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return usuarioRecuperado;
	}

	public Usuario recuperarUsuario(String email) {
		Session sessao = null;
		Usuario usuarioRecuperado = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
			criteria.select(raizUsuario);
			ParameterExpression<String> emailUsuario = construtor.parameter(String.class);
			criteria.where(construtor.equal(raizUsuario.get("email"), emailUsuario));
			usuarioRecuperado = sessao.createQuery(criteria).setParameter(emailUsuario, email).getSingleResult();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return usuarioRecuperado;
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
 
	public boolean usuarioExistente(String email, String senha) {
		Session sessao = null;
		try {
				sessao = abrirSessao(sessao);
				CriteriaBuilder construtor = sessao.getCriteriaBuilder();
				CriteriaQuery<Long> criteriaUsuario = construtor.createQuery(Long.class);
				Root<Usuario> raizUsuario = criteriaUsuario.from(Usuario.class);
 
				criteriaUsuario.select(construtor.count(raizUsuario))
				.where(construtor.equal(raizUsuario.get("email"), email), 
						construtor.equal(raizUsuario.get("senha"), senha));
				Long totalUsuarios = sessao.createQuery(criteriaUsuario).getSingleResult();
 
				return totalUsuarios > 0 ? true: false;
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		}finally {
			fecharSessao(sessao);
		}
		return false;
	}

 
}	
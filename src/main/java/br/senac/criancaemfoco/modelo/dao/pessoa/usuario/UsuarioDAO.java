package br.senac.criancaemfoco.modelo.dao.pessoa.usuario;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.Usuario;

public interface UsuarioDAO {

	void inserirUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	void atualizarUsuario(Usuario usuario);
	
	Usuario recuperarUsuario(String email);
	
	boolean usuarioExistente(String email, String senha);

	List<Usuario> recuperarUsuarios();

}
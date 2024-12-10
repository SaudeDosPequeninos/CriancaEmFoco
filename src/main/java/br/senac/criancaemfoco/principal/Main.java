package br.senac.criancaemfoco.principal;

import br.senac.criancaemfoco.modelo.dao.papel.PapelDAOImpl;
import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.UsuarioDAOImpl;
import br.senac.criancaemfoco.modelo.entidade.papel.Papel;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.Usuario;

public class Main {

	public static void main(String[] args) {
		
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		PapelDAOImpl papelDAO = new PapelDAOImpl();
		
		Usuario usuario = usuarioDAO.recuperarUsuario("enfermeiro.silva@gmail.com");
		
		Papel papel = papelDAO.recuperarPapel(usuario.getPapel().getId());
		
		papel.setNomePapel("enfermeiro");
		
		papelDAO.atualizarPapel(papel);
		
		System.out.println(papel.getNomePapel());

	}

}

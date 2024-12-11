package br.senac.criancaemfoco.controle.servlet.usuario;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.criancaemfoco.modelo.dao.papel.PapelDAO;
import br.senac.criancaemfoco.modelo.dao.papel.PapelDAOImpl;
import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.UsuarioDAO;
import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.UsuarioDAOImpl;
import br.senac.criancaemfoco.modelo.entidade.papel.Papel;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.Usuario;


@WebServlet(urlPatterns = {"/login", "/logar-usuario"})
public class UsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private UsuarioDAO daoUsuario;	
    private PapelDAO daoPapel;

    public void init() {
        daoUsuario = new UsuarioDAOImpl();
        daoPapel = new PapelDAOImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		
		try {

			switch (action) {

			case "/login":
				mostrarLogin(request, response);
				break;
			
			case "/logar-usuario":
				logarUsuario(request, response);
				break;

			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void logarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		String email = request.getParameter("email-user");
		String senha = request.getParameter("senha-user");
		Papel papel = new Papel();
		
		if(daoUsuario.usuarioExistente(email, senha)) {
			
			HttpSession session = request.getSession();
			
			Usuario usuarioRecuperado = daoUsuario.recuperarUsuario(email);
			papel.setId(usuarioRecuperado.getPapel().getId());
			Papel papelRecuperado = daoPapel.recuperarPapel(papel);
			
			if(papelRecuperado.getNomePapel().equals("enfermeiro")) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/enfermeiro/perfil-enfermeiro.jsp");
				dispatcher.forward(request, response);
			
			}else if(papelRecuperado.getNomePapel().equals("escola")) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/escola/perfil-escola.jsp");
				dispatcher.forward(request, response);
			
			}else if(papelRecuperado.getNomePapel().equals("responsavel")) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/responsavel/perfil-responsavel.jsp");
				dispatcher.forward(request, response);
			
			}else {
				
				System.out.println("Papel inválido");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				return;
			}
			
			session.setAttribute("usuario", usuarioRecuperado);
			return;
		
		}else {
			
			System.out.println("email ou senha não incorretos");
			return;
		}
		
		
		
	}

}

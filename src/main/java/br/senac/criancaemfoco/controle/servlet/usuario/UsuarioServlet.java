package br.senac.criancaemfoco.controle.servlet.usuario;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.UsuarioDAO;
import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.UsuarioDAOImpl;


@WebServlet(urlPatterns = {"/login", "/logar-usuario"})
public class UsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private UsuarioDAO daoUsuario;	

    public void init() {
        daoUsuario = new UsuarioDAOImpl();
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
		
		if (daoUsuario.usuarioResponsavelExistente(email, senha)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/responsavel/home-responsavel.jsp");
			dispatcher.forward(request, response);
		}else if(daoUsuario.usuarioEscolaExistente(email, senha)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/escola/home-escola.jsp");
			dispatcher.forward(request, response);
		}else if(daoUsuario.usuarioEnfermeiroExistente(email, senha)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/enfermeiro/home-enfermeiro.jsp");
			dispatcher.forward(request, response);
		}else {
			System.out.println("Usuario Não existe");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}

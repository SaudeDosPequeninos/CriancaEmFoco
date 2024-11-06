package controle.servelet;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.criancaemfoco.modelo.dao.escola.EscolaDAOImpl;
import br.senac.criancaemfoco.modelo.dao.turma.TurmaDAO;
import br.senac.criancaemfoco.modelo.dao.turma.TurmaDAOImpl;
import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.endereco.Endereco;
import br.senac.criancaemfoco.modelo.entidade.escola.Escola;
import br.senac.criancaemfoco.modelo.entidade.turma.Turma;

@WebServlet("/")
public class TurmaServelet extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;
	private TurmaDAO dao;

	public void init() {
		dao = new TurmaDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {

			switch (action) {

			case "/inserir":
				inserirTurma(request, response);
				break;

			case "/salvo":
				salvoTurma(request, response);
				break;

			case "deletar":
				deletarTurma(request,response);
				break;

			case "atualizar":
				atualizarTurma(request,response);
				break;

			default:
				formularioTurma(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void formularioTurma(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("form-turma.jsp");
		dispatcher.forward(request, response);
	}

	private void inserirTurma(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

	    Escola escola = new Escola();

	    String anoTurma = request.getParameter("ano-turma");
	    String numeroTurma = request.getParameter("numero-turma");
	    
	    Turma turma = new Turma(numeroTurma, anoTurma);
	    dao.inserirTurma(turma); 
		response.sendRedirect("salvo");
	}
	
	private void atualizarTurma(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// recuperar uma turma por id para atualizar a mesma pelo id
		long id = Long.parseLong(request.getParameter("id"));
	    String anoTurma = request.getParameter("ano-turma");
	    String numeroTurma = request.getParameter("numero-turma");
	    Turma turma = new Turma(id,numeroTurma, anoTurma);
		dao.atualizarTurma(turma);
		response.sendRedirect("listar"); //
	}

	private void deletarTurma(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		Contato contato = dao.recuperarContato(new Contato(id)); // recuperar uma turma por id
		dao.deletarContato(contato);
		response.sendRedirect("listar");
		
	}
		
	
	private void salvoTurma(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("salvo.jsp");
		dispatcher.forward(request, response);
	}

}

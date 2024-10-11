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

import br.senac.criancaemfoco.modelo.dao.turma.TurmaDAO;
import br.senac.criancaemfoco.modelo.dao.turma.TurmaDAOImpl;
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

		// criar uma escola e salvar ela no banco. depois vicular a turma a escola criada
		Escola escola = new Escola();
			
		String turma1 = request.getParameter("nomeTurma");
		String turno = request.getParameter("turnoTurma");
		String anoTurma = request.getParameter("anoLetivo"); 
		Turma turma = new Turma(turma1, turno, anoTurma);
		dao.inserirTurma(turma);
		response.sendRedirect("salvo");
	}
	
	private void salvoTurma(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("salvo.jsp");
		dispatcher.forward(request, response);
	}

}

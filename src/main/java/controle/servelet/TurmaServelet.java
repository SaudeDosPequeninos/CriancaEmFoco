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
	    Endereco endereco = new Endereco(); 
	    endereco.setLogradouro("Rua"); 
	    endereco.setNumero((short) 123);

	    Contato contato = new Contato(); 
	    contato.setEmail("contato@a.com");
	    contato.setNumCelular("123456789"); 

	    Escola escola = new Escola();
	    escola.setNomeEscola("Escola Top");
	    escola.setEndereco(endereco);
	    escola.setContato(contato);
	    escola.setCnpjEscola("12.345.678/0001-95"); 

	    EscolaDAOImpl escolaDao = new EscolaDAOImpl();
	    escolaDao.inserirEscola(escola);

	    String turma1 = request.getParameter("nomeTurma");
	    String turno = request.getParameter("turnoTurma");
	    String anoTurma = request.getParameter("anoLetivo");
	    
	    Turma turma = new Turma(turma1, turno, anoTurma, escola);
	    TurmaDAOImpl turmaDAO = new TurmaDAOImpl();
	    turmaDAO.inserirTurma(turma); 
		response.sendRedirect("salvo");
	}
	
	private void salvoTurma(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("salvo.jsp");
		dispatcher.forward(request, response);
	}

}

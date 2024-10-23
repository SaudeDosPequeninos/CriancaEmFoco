package controle.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.criancaemfoco.modelo.dao.pessoa.aluno.AlunoDAO;
import br.senac.criancaemfoco.modelo.dao.pessoa.aluno.AlunoDAOImpl;
import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;


@WebServlet(urlPatterns = {"/aluno", "/cadastrar-aluno", "/inserir-aluno"})
public class AlunoServlet extends HttpServlet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private AlunoDAO daoAluno;
	
	public void init() {
		daoAluno = new AlunoDAOImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		try {
			
			switch (action) {
			
			case "/cadastrar-aluno":
				mostrarCadastroAluno(request, response);
				break;
			
			case "/inserir-aluno":
				inserirAluno(request, response);
				break;
			
			default:
				retornarMenu(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void mostrarCadastroAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/aluno/cadastrar-aluno.jsp");
		dispatcher.forward(request, response);
	}
	
	private void retornarMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void inserirAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Aluno aluno = new Aluno();
		
		aluno.setNomeId(request.getParameter("nome-user"));
		aluno.setSobrenome(request.getParameter("sobrenome-user"));
		aluno.setIdFiscal(formatCPF(request.getParameter("cpf-user")));
		aluno.setDataNascimento(LocalDate.parse(request.getParameter("data-nascimento-user")));
		aluno.setMatricula(Float.parseFloat(request.getParameter("id-aluno")));
		
		daoAluno.inserirAluno(aluno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}

	public static String formatCPF(String cpf) {

        return cpf.substring(0, 3) + "." + 
               cpf.substring(3, 6) + "." + 
               cpf.substring(6, 9) + "-" + 
               cpf.substring(9, 11);
    }
	

}

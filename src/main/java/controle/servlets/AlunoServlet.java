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

import java.util.List;
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
			
			case "/editar-aluno":
				mostrarEdicaoAluno(request, response);
				break;
				
			case "/inserir-aluno":
				inserirAluno(request, response);
				break;
				
			case "/atualizar-aluno":
				atualizarAluno(request, response);
				break;
				
			case "/deletar-aluno":
				deletarAluno(request, response);
				break;
				
			case "/listar-aluno":
				listarAlunos(request, response);
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
	
	
	private void mostrarEdicaoAluno(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		Long idAluno = Long.parseLong(request.getParameter("id-aluno"));
		List<Aluno> alunos = daoAluno.recuperarAlunos();
		Aluno alunoRecuperado = null;
		for (Aluno aluno : alunos) {
			if (aluno.getId() == idAluno) {
				alunoRecuperado = aluno ;
				break;
			}
		}
		
		request.setAttribute("aluno", alunoRecuperado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/aluno/editar-aluno.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
	private void inserirAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Aluno aluno = new Aluno();
		
		String nome = request.getParameter("nome-user");
		String sobrenome = request.getParameter("sobrenome-user");
		String cpf = request.getParameter("cpf-user");
		LocalDate dtNascimento = LocalDate.parse(request.getParameter("data-nascimento-user"));
		Float matricula = Float.parseFloat(request.getParameter("id-aluno"));
		
		aluno.setNomeId(nome);
		aluno.setSobrenome(sobrenome);
		aluno.setIdFiscal(cpf);
		aluno.setDataNascimento(dtNascimento);
		aluno.setMatricula(matricula);
		
		daoAluno.inserirAluno(aluno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}


	private void atualizarAluno(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		Long idAluno = Long.parseLong(request.getParameter("id-aluno"));
		
		Aluno aluno = new Aluno();
		
		String nome = request.getParameter("nome-user");
		String sobrenome = request.getParameter("sobrenome-user");
		String cpf = request.getParameter("cpf-user");
		LocalDate dtNascimento = LocalDate.parse(request.getParameter("data-nascimento-user"));
		Float matricula = Float.parseFloat(request.getParameter("id-aluno"));
		
		aluno.setId(idAluno);
		aluno.setNomeId(nome);
		aluno.setSobrenome(sobrenome);
		aluno.setIdFiscal(cpf);
		aluno.setDataNascimento(dtNascimento);
		aluno.setMatricula(matricula);
		
		daoAluno.inserirAluno(aluno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deletarAluno(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		Long idAluno = Long.parseLong(request.getParameter("id-aluno"));
		List<Aluno> alunos = daoAluno.recuperarAlunos();
		Aluno alunoRecuperado = null;
		for (Aluno aluno : alunos) {
			if (aluno.getId() == idAluno) {
				alunoRecuperado = aluno ;
				break;
			}
		}
		
		daoAluno.deletarAluno(alunoRecuperado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/aluno/cadastrar-aluno.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void listarAlunos(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Aluno> alunos= daoAluno.recuperarAlunos();
		request.setAttribute("alunos", alunos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/aluno/listar-aluno.jsp");
		dispatcher.forward(request, response);
	}
}

package br.senac.criancaemfoco.controle.servlet.agendamento;
 
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import br.senac.criancaemfoco.modelo.dao.agendamento.AgendamentoDAO;
import br.senac.criancaemfoco.modelo.dao.agendamento.AgendamentoDAOImpl;
import br.senac.criancaemfoco.modelo.entidade.agendamento.Agendamento;
 
@WebServlet(urlPatterns = {"/cadastrar-agendamento", "/inserir-agendamento"})
public class AgendamentoServlet extends HttpServlet implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private AgendamentoDAO daoAgendamento;
 
	public void init() {
		daoAgendamento = new AgendamentoDAOImpl();
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
 
			case "/cadastrar-agendamento":
				mostrarCadastroAgendamento(request, response);
				break;
 
			case "/inserir-agendamento":
				inserirAgendamento(request, response);
				break;
 
			default:
				retornarMenu(request, response);
				break;
			}
 
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
 
	private void mostrarCadastroAgendamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/agendamento/cadastrar-agendamento.jsp");
		dispatcher.forward(request, response);
	}
 
	private void retornarMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
 
	private void inserirAgendamento(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Agendamento agendamento = new Agendamento();
 
		String[] dataTempo = request.getParameter("data-agendamento").split("T");
		LocalDate data = LocalDate.parse(dataTempo[0]);
		LocalTime horario = LocalTime.parse(dataTempo[1]);
		LocalTime tempoDuracao = LocalTime.parse("00:15:00");
 
		agendamento.setData(data);
		agendamento.setHorario(horario);
		agendamento.setTempoDuracao(tempoDuracao);
 
		daoAgendamento.inserirAgendamento(agendamento);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}
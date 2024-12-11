package br.senac.criancaemfoco.console.servlet;
 
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import br.senac.criancaemfoco.modelo.dao.contato.ContatoDAO;
import br.senac.criancaemfoco.modelo.dao.contato.ContatoDAOImpl;
import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.enfermeiro.EnfermeiroDAO;
import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.enfermeiro.EnfermeiroDAOImpl;
import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.enfermeiro.Enfermeiro;
 
@WebServlet(urlPatterns = {"/cadastrar-enfermeiro", "/inserir-enfermeiro", "/editar-enfermeiro", "/deletar-enfermeiro", "/atualizar-enfermeiro", "/listar-enfermeiros"})
public class EnfermeiroServlet extends HttpServlet implements Serializable {
	private static final long serialVersionUID = 1L;
	private EnfermeiroDAO daoEnfermeiro;
	private ContatoDAO daoContato;
	public void init() {
		daoEnfermeiro = new EnfermeiroDAOImpl();
		daoContato = new ContatoDAOImpl();
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
			
			case "/cadastrar-enfermeiro":
				cadastrarEnfermeiro(request, response);
				break;
				
			case "/inserir-enfermeiro":
				inserirEnfermeiro(request, response);
				
				break;
				
			case "/editar-enfermeiro":
				editarEnfermeiro(request, response);
				break;
				
			case "/atualizar-enfermeiro":
				atualizarEnfermeiro(request, response);
				break;
				
			case "/deletar-enfermeiro":
				deletarEnfermeiro(request, response);
				break;
				
			case "/listar-enfermeiro":
				listarEnfermeiro(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void cadastrarEnfermeiro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/enfermeiro/cadastro-enfermeiro.jsp");
		dispatcher.forward(request, response);
	}
	private void editarEnfermeiro(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
		Long idEnfermeiro = Long.parseLong(request.getParameter("id-enfermeiro"));
		Long idContato = Long.parseLong(request.getParameter("id-contato"));
		Enfermeiro enfermeiro = new Enfermeiro();
		enfermeiro.setId(idEnfermeiro);
		Contato contato = new Contato();
		contato.setId(idContato);
		Enfermeiro enfermeiroRecuperado = daoEnfermeiro.recuperarEnfermeiro(enfermeiro);
		Contato contatoRecuperado = daoContato.recuperarContato(contato);
		request.setAttribute("enfermeiro", enfermeiroRecuperado);
		request.setAttribute("contato", contatoRecuperado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/enfermeiro/cadastro-enfermeiro.jsp");
		dispatcher.forward(request, response);
		
	}
	private void inserirEnfermeiro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
		 Contato contato = new Contato();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        String nome = request.getParameter("nome-user");
        String sobrenome = request.getParameter("sobrenome-user");
        String idFiscal = request.getParameter("cpf-user");
        String registroCoren = request.getParameter("coren-user");
        String senha = request.getParameter("confirmar-senha-user");
        String numeroCelular = request.getParameter("telefone-user");
        String email = request.getParameter("email-user");
        String dataNascimentoParam = request.getParameter("data-de-nascimento-user");
        LocalDate dataNascimento = null;
        if (dataNascimentoParam != null && !dataNascimentoParam.isEmpty()) {
            try {
                dataNascimento = LocalDate.parse(dataNascimentoParam);
            } catch (DateTimeParseException e) {
                System.err.println("Erro ao parsear a data: " + e.getMessage());
            }
        }
       
        contato.setNumCelular(numeroCelular);
        daoContato.inserirContato(contato);
        enfermeiro.setContato(contato);
        enfermeiro.setNomeId(nome);
        enfermeiro.setSobrenome(sobrenome);
        enfermeiro.setIdFiscal(idFiscal);
        enfermeiro.setDataNascimento(dataNascimento);
        enfermeiro.setRegistroCoren(registroCoren);
        enfermeiro.setSenha(senha);
        enfermeiro.setEmail(email);
        
        daoEnfermeiro.inserirEnfermeiro(enfermeiro);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    private void atualizarEnfermeiro(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	
    	Long idEnfermeiro = Long.parseLong(request.getParameter("id-enfermeiro"));
    	Long idContato = Long.parseLong(request.getParameter("id-contato"));
        Enfermeiro enfermeiro = new Enfermeiro();
        Contato contato = new Contato();
        
        String nome = request.getParameter("nome-user");
        String sobrenome = request.getParameter("sobrenome-user");
        String idFiscal = request.getParameter("cpf-user");
        String registroCoren = request.getParameter("coren-user");
        String senha = request.getParameter("confirmar-senha-user");
        String numeroCelular = request.getParameter("telefone-user");
        String email = request.getParameter("email-user");
        String dataNascimentoParam = request.getParameter("data-de-nascimento-user");
        LocalDate dataNascimento = null;
        if (dataNascimentoParam != null && !dataNascimentoParam.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                dataNascimento = LocalDate.parse(dataNascimentoParam, formatter);
            } catch (DateTimeParseException e) {
                System.err.println("Erro ao parsear a data: " + e.getMessage());
            }
        }
        contato.setId(idContato);
        enfermeiro.setId(idEnfermeiro);
        contato.setNumCelular(numeroCelular);
        enfermeiro.setContato(contato);
        enfermeiro.setNomeId(nome);
        enfermeiro.setSobrenome(sobrenome);
        enfermeiro.setIdFiscal(idFiscal);
        enfermeiro.setDataNascimento(dataNascimento);
        enfermeiro.setRegistroCoren(registroCoren);
        enfermeiro.setSenha(senha);
        enfermeiro.setEmail(email);
        contato.setId(idContato);
      
        daoContato.atualizarContato(contato);
        daoEnfermeiro.atualizarEnfermeiro(enfermeiro);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
	private void deletarEnfermeiro(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException , IOException {
		Long idEnfermeiro = Long.parseLong(request.getParameter("id-enfermeiro"));
		Long idContato = Long.parseLong(request.getParameter("id-contato"));
		Enfermeiro enfermeiro = new Enfermeiro();
		enfermeiro.setId(idEnfermeiro);
		Contato contato = new Contato();
		contato.setId(idContato);
		Enfermeiro enfermeiroRecuperado = daoEnfermeiro.recuperarEnfermeiro(enfermeiro);
		Contato contatoRecuperado = daoContato.recuperarContato(contato);
		daoEnfermeiro.deletarEnfermeiro(enfermeiroRecuperado);
		daoContato.deletarContato(contatoRecuperado);
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
}
	private void listarEnfermeiro(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Enfermeiro> enfermeiros = daoEnfermeiro.recuperarEnfermeiros();
		request.setAttribute("enfermeiro", enfermeiros);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/enfermeiro/listar-enfermeiro.jsp");
		dispatcher.forward(request, response);
}
}
 
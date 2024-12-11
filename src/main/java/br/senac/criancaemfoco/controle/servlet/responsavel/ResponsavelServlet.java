package br.senac.criancaemfoco.controle.servlet.responsavel;

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

import br.senac.criancaemfoco.modelo.dao.contato.ContatoDAO;
import br.senac.criancaemfoco.modelo.dao.contato.ContatoDAOImpl;
import br.senac.criancaemfoco.modelo.dao.endereco.EnderecoDAO;
import br.senac.criancaemfoco.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.criancaemfoco.modelo.dao.papel.PapelDAO;
import br.senac.criancaemfoco.modelo.dao.papel.PapelDAOImpl;
import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.responsavel.ResponsavelDAO;
import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.responsavel.ResponsavelDAOImpl;
import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.endereco.Endereco;
import br.senac.criancaemfoco.modelo.entidade.papel.Papel;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.responsavel.Responsavel;

@WebServlet(urlPatterns = {"/cadastrar-responsavel", "/inserir-responsavel" })
public class ResponsavelServlet extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;

	private PapelDAO daoPapel;
	private ContatoDAO daoContato;
	private EnderecoDAO daoEndereco;
	private ResponsavelDAO daoResponsavel;

	public void init() {
		daoPapel = new PapelDAOImpl();
		daoContato = new ContatoDAOImpl();
		daoEndereco = new EnderecoDAOImpl();
		daoResponsavel = new ResponsavelDAOImpl();
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

			case "/cadastrar-responsavel":
				mostrarCadastroResponsavel(request, response);
				break;

			case "/inserir-responsavel":
				inserirResponsavel(request, response);
				break;

			default:
				retornarMenu(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void mostrarCadastroResponsavel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/responsavel/cadastrar-responsavel.jsp");
		dispatcher.forward(request, response);
	}

	private void retornarMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void inserirResponsavel(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Papel papel = new Papel();
		papel.setNomePapel("Usuario");
		
		Contato contato = new Contato();
		String numCelular = request.getParameter("telefone-user");
		contato.setNumCelular(numCelular);
		
		Endereco endereco = new Endereco();
		
		String bairro = request.getParameter("bairro");
		int cep = Integer.parseInt(request.getParameter("cep"));
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String logadouro = request.getParameter("logadouro");
		short numero = Short.parseShort(request.getParameter("numero"));
		String tipo = request.getParameter("tipo");
		
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setLogradouro(logadouro);
		endereco.setNumero(numero);
		endereco.setTipo(tipo);
		
		Responsavel responsavel = new Responsavel();
		
		LocalDate dtNascimento = LocalDate.parse(request.getParameter("data-nascimento-user"));
		String email = request.getParameter("email-user");
		String idFiscal = request.getParameter("cpf-user");
		String nome = request.getParameter("nome-user");
		String senha = request.getParameter("senha");
		String sobrenome = request.getParameter("sobrenome-user");
		
		responsavel.setContato(contato);
		responsavel.setEndereco(endereco);
		responsavel.setPapel(papel);
		responsavel.setDataNascimento(dtNascimento);
		responsavel.setEmail(email);
		responsavel.setIdFiscal(idFiscal);
		responsavel.setNomeId(nome);
		responsavel.setSenha(senha);
		responsavel.setSobrenome(sobrenome);
		
		
		daoPapel.inserirPapel(papel);
		daoContato.inserirContato(contato);
		daoEndereco.inserirEndereco(endereco);
		daoResponsavel.inserirResponsavel(responsavel);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}

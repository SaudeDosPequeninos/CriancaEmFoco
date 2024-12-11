package br.senac.criancaemfoco.controle.servlet.escola;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

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
import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.escola.EscolaDAO;
import br.senac.criancaemfoco.modelo.dao.pessoa.usuario.escola.EscolaDAOImpl;
import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.endereco.Endereco;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.escola.Escola;

@WebServlet(urlPatterns = {"/cadastrar-escola", "/editar-escola", "/inserir-escola", "/atualizar-escola", "/deletar-escola", "/listar-escola"})
public class EscolaServlet extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;
	private EscolaDAO daoEscola;
	private ContatoDAO daoContato;
	private EnderecoDAO daoEndereco;

	public void init() {
		daoEscola = new EscolaDAOImpl();
		daoContato = new ContatoDAOImpl();
		daoEndereco = new EnderecoDAOImpl();
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

			case "/cadastrar-escola":
				mostrarCadastroEscola(request, response);
				break;

			case "/editar-escola":
				mostrarEdicaoEscola(request, response);
				break;

			case "/inserir-escola":
				inserirEscola(request, response);
				break;

			case "/atualizar-escola":
				atualizarEscola(request, response);
				break;

			case "/deletar-escola":
				deletarEscola(request, response);
				break;

			case "/listar-escola":
				listarEscolas(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void mostrarCadastroEscola(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/escola/cadastrar-escola.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarEdicaoEscola(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Long idEscola = Long.parseLong(request.getParameter("id-escola"));
		Long idContato = Long.parseLong(request.getParameter("id-contato"));
		Long idEndereco = Long.parseLong(request.getParameter("id-endereco"));
		Escola escola = new Escola();
		escola.setId(idEscola);
		Contato contato = new Contato();
		contato.setId(idContato);
		Endereco endereco = new Endereco();
		endereco.setId(idEndereco);
		Escola escolaRecuperada = daoEscola.recuperarEscola(escola);
		Contato contatoRecuperado = daoContato.recuperarContato(contato);
		Endereco enderecoRecuperado = daoEndereco.recuperarEndereco(endereco);
		request.setAttribute("escola", escolaRecuperada);
		request.setAttribute("contato", contatoRecuperado);
		request.setAttribute("endereco", enderecoRecuperado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/escola/cadastrar-escola.jsp");
		dispatcher.forward(request, response);
	}

	private void inserirEscola(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Escola escola = new Escola();
		Contato contato = new Contato();
		Endereco endereco = new Endereco();

		String razaoSocial = request.getParameter("razao-social-user");
		String nomeFantasia = request.getParameter("nome-fantasia-user");
		String cnpj = request.getParameter("cnpj-user");
		String telefone = request.getParameter("tel-user");
		String email = request.getParameter("email-user");
		String estado = request.getParameter("estado-user");
		String cidade = request.getParameter("cidade-user");
		String logradouro = request.getParameter("logradouro-user");
		int cep = Integer.parseInt(request.getParameter("cep-user"));
		String bairro = request.getParameter("bairro-user");
		short numero = Short.parseShort(request.getParameter("numero-user"));
		String tipo = request.getParameter("tipo-user");
		String senha = request.getParameter("senha-user");

		contato.setNumCelular(telefone);
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setTipo(tipo);
		escola.setContato(contato);
		escola.setEndereco(endereco);
		escola.setEmail(email);
		escola.setIdFiscal(cnpj);
		escola.setNomeId(razaoSocial);
		escola.setSenha(senha);
		escola.setSobrenome(nomeFantasia);

		daoContato.inserirContato(contato);
		daoEndereco.inserirEndereco(endereco);
		daoEscola.inserirEscola(escola);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void atualizarEscola(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Long idEscola = Long.parseLong(request.getParameter("id-escola"));
		Long idContato = Long.parseLong(request.getParameter("id-contato"));
		Long idEndereco = Long.parseLong(request.getParameter("id-endereco"));
		Escola escola = new Escola();
		Contato contato = new Contato();
		Endereco endereco = new Endereco();

		String razaoSocial = request.getParameter("razao-social-user");
		String nomeFantasia = request.getParameter("nome-fantasia-user");
		String cnpj = request.getParameter("cnpj-user");
		String telefone = request.getParameter("tel-user");
		String email = request.getParameter("email-user");
		String estado = request.getParameter("estado-user");
		String cidade = request.getParameter("cidade-user");
		String logradouro = request.getParameter("logradouro-user");
		int cep = Integer.parseInt(request.getParameter("cep-user"));
		String bairro = request.getParameter("bairro-user");
		short numero = Short.parseShort(request.getParameter("numero-user"));
		String tipo = request.getParameter("tipo-user");
		String senha = request.getParameter("senha-user");

		contato.setNumCelular(telefone);
		contato.setId(idContato);
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setTipo(tipo);
		endereco.setId(idEndereco);
		escola.setContato(contato);
		escola.setEndereco(endereco);
		escola.setEmail(email);
		escola.setIdFiscal(cnpj);
		escola.setNomeId(razaoSocial);
		escola.setSenha(senha);
		escola.setSobrenome(nomeFantasia);
		escola.setId(idEscola);

		daoContato.atualizarContato(contato);
		daoEndereco.atualizarEndereco(endereco);
		daoEscola.atualizarEscola(escola);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void deletarEscola(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Long idEscola = Long.parseLong(request.getParameter("id-escola"));
		Long idContato = Long.parseLong(request.getParameter("id-contato"));
		Long idEndereco = Long.parseLong(request.getParameter("id-endereco"));
		Escola escola = new Escola();
		escola.setId(idEscola);
		Contato contato = new Contato();
		contato.setId(idContato);
		Endereco endereco = new Endereco();
		endereco.setId(idEndereco);
		Escola escolaRecuperada = daoEscola.recuperarEscola(escola);
		Contato contatoRecuperado = daoContato.recuperarContato(contato);
		Endereco enderecoRecuperado = daoEndereco.recuperarEndereco(endereco);
		daoEscola.deletarEscola(escolaRecuperada);
		daoContato.deletarContato(contatoRecuperado);
		daoEndereco.deletarEndereco(enderecoRecuperado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void listarEscolas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Escola> escolas = daoEscola.recuperarEscolas();
		request.setAttribute("escolas", escolas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/escola/listar-escola.jsp");
		dispatcher.forward(request, response);
	}
}
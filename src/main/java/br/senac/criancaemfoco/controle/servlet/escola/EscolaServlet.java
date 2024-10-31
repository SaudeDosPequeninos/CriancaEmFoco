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

@WebServlet(urlPatterns = {"/cadastrar-escola", "/inserir-escola", "/listar-escola"})
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

			case "/inserir-escola":
				inserirEscola(request, response);
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

	private void inserirEscola(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		Escola escola = new Escola();
		Contato contato = new Contato();
		Endereco endereco = new Endereco();

		String razaoSocial = request.getParameter("razao_social_cadastro");
		String nomeFantasia = request.getParameter("nome_fantasia_cadastro");
		String cnpj = request.getParameter("cnpj_cadastro");
		String telefone = request.getParameter("tel_cadastro");
		String email = request.getParameter("email_cadastro");
		String estado = request.getParameter("estado_cadastro");
		String cidade = request.getParameter("cidade_cadastro");
		String logradouro = request.getParameter("logradouro_cadastro");
		int cep = Integer.parseInt(request.getParameter("cep_cadastro"));
		String bairro = request.getParameter("bairro_cadastro");
		short numero = Short.parseShort(request.getParameter("numero_cadastro"));
		String tipo = "Instituição";
		String senha = request.getParameter("senha_cadastro");

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

	private void listarEscolas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Escola> escolas = daoEscola.recuperarEscolas();
		request.setAttribute("escola", escolas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/escola/listar-escola.jsp");
		dispatcher.forward(request, response);
	}
}
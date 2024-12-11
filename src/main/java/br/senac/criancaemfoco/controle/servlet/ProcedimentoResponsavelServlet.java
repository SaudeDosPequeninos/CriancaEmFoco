package br.senac.criancaemfoco.controle.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.criancaemfoco.modelo.dao.insumo.InsumoDAO;
import br.senac.criancaemfoco.modelo.dao.insumo.InsumoDAOImpl;
import br.senac.criancaemfoco.modelo.dao.procedimento.ProcedimentoDAO;
import br.senac.criancaemfoco.modelo.dao.procedimento.ProcedimentoDAOImpl;
import br.senac.criancaemfoco.modelo.entidade.insumo.Insumo;
import br.senac.criancaemfoco.modelo.entidade.procedimento.Procedimento;

@WebServlet(urlPatterns = {"/cadastrar-procedimento", "/inserir-procedimento", "/editar-procedimento","/deletar-procedimento","/atualizar-procedimento", "/listar-procedimento"})
public class ProcedimentoResponsavelServlet extends HttpServlet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ProcedimentoDAO daoProcedimento;
	private InsumoDAO daoInsumo;
	
	public void init() {
		daoProcedimento = new ProcedimentoDAOImpl();
		daoInsumo = new InsumoDAOImpl();
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
			
			case"/cadastrar-procedimento":
				 formularioProcedimento(request, response);
				 break;
			
			case "/inserir-procedimento":
				inserirProcedimento(request, response);
				
				 break;
			
			case"/editar-procedimento":
				 editarProcedimento(request, response);
				 break;
			
			case "/atualizar-procedimento":
				atualizarProcedimento(request, response);
				
				 break;
				 
			case"/deletar-procedimento":
				 deletarProcedimento(request, response);
				 break;
				 
			case"/listar-procedimento":
				listarProcedimento(request, response);
				break;
			
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void formularioProcedimento(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/procedimento/cadastro-procedimento.jsp");
		dispatcher.forward(request, response);
	}
	private void editarProcedimento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		Long idProcedimento = Long.parseLong(request.getParameter("id-procedimento"));
		Long idInsumo = Long.parseLong(request.getParameter("id-procedimento"));
		Procedimento procedimento = new Procedimento();
		procedimento.setId(idProcedimento);
		Insumo insumo = new Insumo();
		insumo.setId(idInsumo);
		Procedimento procedimentoRecuperado = daoProcedimento.recuperarProcedimento(procedimento);
		Insumo insumoRecuperado = daoInsumo.recuperarInsumo(insumo);
		request.setAttribute("procedimento", procedimentoRecuperado);
		request.setAttribute("insumo", insumoRecuperado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/procedimento/cadastro-procedimento.jsp");
	}
	private void inserirProcedimento (HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException, SQLException {
		
		Procedimento procedimento = new Procedimento();
		Insumo insumo = new Insumo();
		
		String nomeProcedimento = request.getParameter("nome-procedimento");
		String medicamentoNecessario = request.getParameter("medicamento-necessario");
		String materiaisNecessarios = request.getParameter("materiais-necessarios");
		String doseQuantidade = request.getParameter("dose-quantidade");
		String descricaoProcedimento = request.getParameter("descricao");
		
		procedimento.setNomeProcedimento(nomeProcedimento);
		insumo.setNomeInsumo(materiaisNecessarios);
		insumo.setDataValidade(LocalDate.of(2025, 12, 31)); 
	    insumo.setDescricao("Águlha para caneta de insulina");
		procedimento.setDescricaoProcedimento(descricaoProcedimento);
		
		daoInsumo.inserirInsumo(insumo);
		daoProcedimento.inserirProcedimento(procedimento);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void atualizarProcedimento(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, ServletException, IOException {
		
		Long idProcedimento = Long.parseLong(request.getParameter("id-procedimento"));
		Long idInsumo = Long.parseLong(request.getParameter("id-procedimento"));
		Procedimento procedimento = new Procedimento();
		Insumo insumo = new Insumo();
		
		String nomeProcedimento = request.getParameter("nome-procedimento");
		String medicamentoNecessario = request.getParameter("medicamento-necessario");
		String materiaisNecessarios = request.getParameter("materiais-necessarios");
		String doseQuantidade = request.getParameter("dose-quantidade");
		String descricaoProcedimento = request.getParameter("descricao");
		
		procedimento.setId(idProcedimento);
		procedimento.setNomeProcedimento(nomeProcedimento);
		insumo.setNomeInsumo(materiaisNecessarios);
		insumo.setDataValidade(LocalDate.of(2100, 12, 31)); 
	    insumo.setDescricao("Águlha para caneta de insulina");
		procedimento.setDescricaoProcedimento(descricaoProcedimento);
		
		daoInsumo.inserirInsumo(insumo);
		daoProcedimento.atualizarProcedimento(procedimento);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deletarProcedimento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException , IOException {
		
		Long idProcedimento = Long.parseLong(request.getParameter("id-procedimento"));
		Long idInsumo = Long.parseLong(request.getParameter("id-procedimento"));
		Procedimento procedimento = new Procedimento();
		procedimento.setId(idProcedimento);
		Insumo insumo = new Insumo();
		insumo.setId(idInsumo);
		Procedimento procedimentoRecuperado = daoProcedimento.recuperarProcedimento(procedimento);
		Insumo insumoRecuperado = daoInsumo.recuperarInsumo(insumo);
		daoInsumo.deletarInsumo(insumoRecuperado);
		daoProcedimento.removerProcedimento(procedimentoRecuperado);
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	private void listarProcedimento(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		List<Procedimento> procedimentos = daoProcedimento.recuperarProcedimentos();
		request.setAttribute("procedimentos", procedimentos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/procedimento/listar-procedimento.jsp");
		dispatcher.forward(request, response);
	}
}
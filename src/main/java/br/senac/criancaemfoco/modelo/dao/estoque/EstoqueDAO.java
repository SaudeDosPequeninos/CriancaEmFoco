package br.senac.criancaemfoco.modelo.dao.estoque;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.estoque.Estoque;

public interface EstoqueDAO {

	void inserirEstoque(Estoque estoque);

	void deletarEstoque(Estoque estoque);

	void atualizarEstoque(Estoque estoque);

	List<Estoque> recuperarEstoques();

}
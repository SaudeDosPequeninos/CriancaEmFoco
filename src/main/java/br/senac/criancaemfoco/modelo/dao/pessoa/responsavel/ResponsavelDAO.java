package br.senac.criancaemfoco.modelo.dao.pessoa.responsavel;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.pessoa.responsavel.Responsavel;

public interface ResponsavelDAO {

	void inserirResponsavel (Responsavel responsavel);

	void atualizarResponsavel (Responsavel responsavel);

	void deletarResponsavel (Responsavel responsavel);

	List<Responsavel> recuperarResponsavel();

}
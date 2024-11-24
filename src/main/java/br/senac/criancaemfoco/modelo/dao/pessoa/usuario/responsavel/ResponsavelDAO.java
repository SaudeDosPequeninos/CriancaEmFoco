package br.senac.criancaemfoco.modelo.dao.pessoa.usuario.responsavel;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.responsavel.Responsavel;

public interface ResponsavelDAO {

	void inserirResponsavel (Responsavel responsavel);

	void atualizarResponsavel (Responsavel responsavel);

	void deletarResponsavel (Responsavel responsavel);

	Responsavel recuperarResponsavel(Responsavel responsavel);

	List<Responsavel> recuperarResponsaveis();

}
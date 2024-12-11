package br.senac.criancaemfoco.modelo.dao.papel;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.papel.Papel;

public interface PapelDAO {

	void inserirPapel(Papel papel);

	void deletarPapel(Papel papel);

	void atualizarPapel(Papel papel);

	Papel recuperarPapel(Papel papel);

	List<Papel> recuperarPapeis();

}
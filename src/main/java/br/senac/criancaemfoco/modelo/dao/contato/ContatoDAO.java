package br.senac.criancaemfoco.modelo.dao.contato;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.contato.Contato;

public interface ContatoDAO {

	void inserirContato(Contato contato);

	void deletarContato(Contato contato);

	void atualizarContato(Contato contato);

	List<Contato> recuperarContatos();

}
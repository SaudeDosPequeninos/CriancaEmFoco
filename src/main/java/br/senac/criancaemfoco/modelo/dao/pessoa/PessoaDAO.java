package br.senac.criancaemfoco.modelo.dao.pessoa;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.pessoa.Pessoa;

public interface PessoaDAO {

	void inserirPessoa(Pessoa pessoa);

	void deletarPessoa(Pessoa pessoa);

	void atualizarPessoa(Pessoa pessoa);

	Pessoa recuperarPessoa(Pessoa pessoa);

	List<Pessoa> recuperarPessoas();

}
package br.senac.criancaemfoco.modelo.dao.escola;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;
import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.endereco.Endereco;
import br.senac.criancaemfoco.modelo.entidade.escola.Escola;
import br.senac.criancaemfoco.modelo.entidade.pessoa.enfermeiro.Enfermeiro;
import br.senac.criancaemfoco.modelo.entidade.turma.Turma;

public interface EscolaDAO {

	void inserirEscola(Escola escola);

	void deletarEscola(Escola escola);

	void atualizarEscola(Escola escola);

	List<Escola> recuperarEscolas();

	List<Escola> recuperarEscolasAluno(Aluno aluno);

	List<Escola> recuperarEscolasEndereco(Endereco endereco);

	List<Escola> recuperarEscolasTurma(Turma turma);

	List<Escola> recuperarEscolasEnfermeiro(Enfermeiro enfermeiro);

	List<Escola> recuperarEscolasContato(Contato contato);

}
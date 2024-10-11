package br.senac.criancaemfoco.modelo.dao.pessoa.aluno;

import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.escola.Escola;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.responsavel.Responsavel;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.turma.Turma;

public interface AlunoDAO {

	List<Aluno> recuperarAlunoTurma(Turma turma);

	List<Aluno> recuperarAlunoResponsavel(Responsavel responsavel);

	List<Aluno> recuperarAlunoEscola(Escola escola);

}
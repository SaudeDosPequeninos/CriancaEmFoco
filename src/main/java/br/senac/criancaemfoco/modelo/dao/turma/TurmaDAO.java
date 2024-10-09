package br.senac.criancaemfoco.modelo.dao.turma;

import java.util.List;
import br.senac.criancaemfoco.modelo.entidade.turma.Turma;

public interface TurmaDAO {

	void inserirTurma(Turma turma);

	void deletarTurma(Turma turma);

	void atualizarTurma(Turma turma);

	List<Turma> recuperarTurmas();

}
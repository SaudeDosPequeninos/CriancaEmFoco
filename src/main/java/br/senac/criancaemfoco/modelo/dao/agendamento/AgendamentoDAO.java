package br.senac.criancaemfoco.modelo.dao.agendamento;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.agendamento.Agendamento;
import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.enfermeiro.Enfermeiro;
import br.senac.criancaemfoco.modelo.entidade.procedimento.Procedimento;

public interface AgendamentoDAO {

	void inserirAgendamento(Agendamento agendamento);

	void deletarAgendamento(Agendamento agendamento);

	void atualizarAgendamento(Agendamento agendamento);

	List<Agendamento> recuperarAgendamentos();

	List<Agendamento> recuperarAgendamentoAluno(Aluno aluno);

	List<Agendamento> recuperarAgendamentoEnfermeiro(Enfermeiro enfermeiro);

	List<Agendamento> recuperarAgendamentosProcedimento(Procedimento procedimento);

}

package br.senac.criancaemfoco.modelo.dao.pessoa.usuario.enfermeiro;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.agendamento.Agendamento;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.enfermeiro.Enfermeiro;

public interface EnfermeiroDAO {

	void inserirEnfermeiro(Enfermeiro enfermeiro);

	void deletarEnfermeiro(Enfermeiro enfermeiro);

	void atualizarEnfermeiro(Enfermeiro enfermeiro);

	List<Enfermeiro> recuperarEnfermeiros();

	List<Enfermeiro> recuperarEnfermeirosAgendamento(Agendamento agendamento);

}
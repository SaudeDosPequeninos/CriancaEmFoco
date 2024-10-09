package br.senac.criancaemfoco.modelo.dao.procedimento;

import java.util.List;
import br.senac.criancaemfoco.modelo.entidade.procedimento.Procedimento;

public interface ProcedimentoDAO {

	void inserirProcedimento(Procedimento procedimento);

	void removerProcedimento(Procedimento procedimento);

	void atualizarProcedimento(Procedimento procedimento);

	List<Procedimento> recuperarProcedimento();

}
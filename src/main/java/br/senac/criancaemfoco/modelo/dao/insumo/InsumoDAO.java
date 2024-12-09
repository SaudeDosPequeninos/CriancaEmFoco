package br.senac.criancaemfoco.modelo.dao.insumo;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.insumo.Insumo;

public interface InsumoDAO {

	void inserirInsumo(Insumo insumo);

	void deletarInsumo(Insumo insumo);

	void atualizarInsumo(Insumo insumo);

	Insumo recuperarInsumo(Insumo insumo);

	List<Insumo> recuperarInsumos();

}

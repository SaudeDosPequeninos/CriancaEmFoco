package br.senac.criancaemfoco.modelo.dao.foto;

import java.util.List;

import br.senac.criancaemfoco.modelo.entidade.foto.Foto;

public interface FotoDAO {

	void inserirFoto(Foto foto);

	void deletarFoto(Foto foto);

	void atualizarFoto(Foto foto);

	Foto recuperarFoto(Foto foto);

	List<Foto> recuperarFotos();

}

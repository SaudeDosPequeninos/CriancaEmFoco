package br.senac.criancaemfoco.modelo.entidade.foto;

import java.io.Serializable;

public class Foto implements Serializable{

	private static final long serialVersionUID = 1L;

	private byte[] conteudo;

	private String extensao;

	public Foto() {}

	public Foto(byte[] conteudo, String extensao) {
		setConteudo(conteudo);
		setExtensao(extensao);
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

}

package br.senac.criancaemfoco.modelo.entidade.foto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foto")
public class Foto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_foto")
	private Long id;

	@Column(name = "conteudo_foto", nullable = false, columnDefinition = "LONGBLOB")
	private byte[] conteudo;

	@Column(name = "extensao_foto", nullable = false)
	private String extensao;

	public Foto() {}

	public Foto(byte[] conteudo, String extensao) {
		setConteudo(conteudo);
		setExtensao(extensao);
	}

	public Foto(Long id, byte[] conteudo, String extensao) {
		setId(id);
		setConteudo(conteudo);
		setExtensao(extensao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

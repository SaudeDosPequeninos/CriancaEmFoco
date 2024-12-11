package br.senac.criancaemfoco.modelo.entidade.insumo;

import java.time.LocalDate;

import javax.persistence.Column;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insumo")
public class Insumo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_insumo")
	private Long id;

	@Column(name = "nome_insumo", length = 25, nullable = false)
	private String nomeInsumo;

	@Column(name = "data_validade_insumo", nullable = false)
	private LocalDate dataValidade;

	@Column(name = "descrição_insumo", length = 200, nullable = false)
	private String descricao;

	public Insumo() {}

	public Insumo(Long id, String nomeInsumo, LocalDate dataValidade, String descricao) {
		setId(id);
		setNomeInsumo(nomeInsumo);
		setDataValidade(dataValidade);
		setDescricao(descricao);
	}

	public Insumo(String nomeInsumo, LocalDate dataValidade, String descricao) {
		setNomeInsumo(nomeInsumo);
		setDataValidade(dataValidade);
		setDescricao(descricao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeInsumo() {
		return nomeInsumo;
	}

	public void setNomeInsumo(String nomeInsumo) {
		this.nomeInsumo = nomeInsumo;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
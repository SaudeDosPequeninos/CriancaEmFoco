package br.senac.criancaemfoco.modelo.entidade.papel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "papel")
public class Papel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_papel")
	private Long id;

	@Column(name = "nome_papel", length = 45, nullable = false)
	private String nomePapel;

	public Papel() {}

	public Papel(Long id, String nomePapel) {
		setId(id);
		setNomePapel(nomePapel);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePapel() {
		return nomePapel;
	}

	public void setNomePapel(String nomePapel) {
		this.nomePapel = nomePapel;
	}

}
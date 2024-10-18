package br.senac.criancaemfoco.modelo.entidade.contato;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Long id;

	@Column(name = "numero_celular", length = 9, nullable = false)
	private String numeroCelular;

	public Contato() {}

	public Contato(String numCelular, String email) {
		setNumCelular(numCelular);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumCelular() {
		return numeroCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numeroCelular = numCelular;
	}

}
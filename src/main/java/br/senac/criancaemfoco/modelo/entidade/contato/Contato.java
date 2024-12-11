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
public class Contato implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Long id;

	@Column(name = "numero_celular", length = 9, nullable = false)
	private String numeroCelular;

	@Column(name = "email", length = 45, nullable = false)
	private String email;

	public Contato() {}

	public Contato(String numCelular, String email) {
		setNumCelular(numCelular);
		setEmail(email);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
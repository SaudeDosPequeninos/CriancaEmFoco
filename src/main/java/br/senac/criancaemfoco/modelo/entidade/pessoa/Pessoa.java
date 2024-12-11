package br.senac.criancaemfoco.modelo.entidade.pessoa;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.criancaemfoco.modelo.entidade.contato.Contato;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name = "Pessoa")
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Long id;

	@Column(name = "nome_id", length = 25, nullable = false, unique = false)
	private String nomeId;

	@Column(name = "sobrenome", length = 45, unique = false)
	private String sobrenome;

	@Column(name= "id_fiscal", length = 14, nullable = false, unique = true)
	private String idFiscal;

	@Column(name= "data_nascimento", unique = false)
	private LocalDate dataNascimento;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contato")
	private Contato contato;

	public Pessoa() {}

	public Pessoa(String nomeId, String sobrenome, String idFiscal,LocalDate dataNascimento, Contato contato) {
		setNomeId(nomeId);
		setSobrenome(sobrenome);
		setIdFiscal(idFiscal);
		setDataNascimento(dataNascimento);
		setContato(contato);
	}

	public Pessoa(String nomeId, String idFiscal, Contato contato) {
		setNomeId(nomeId);
		setIdFiscal(idFiscal);
		setContato(contato);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeId() {
		return nomeId;
	}

	public void setNomeId(String nomeId) {
		this.nomeId = nomeId;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getIdFiscal() {
		return idFiscal;
	}

	public void setIdFiscal(String idFiscal) {
		this.idFiscal = idFiscal;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa outro = (Pessoa) obj;
		return id == outro.id;
	}

}

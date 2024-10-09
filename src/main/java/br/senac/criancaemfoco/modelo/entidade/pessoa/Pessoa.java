package br.senac.criancaemfoco.modelo.entidade.pessoa;
 
import java.io.Serializable;
import java.time.LocalDate;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.papel.Papel;
import br.senac.criancaemfoco.modelo.entidade.usuario.Usuario;

@Entity
@Table (name = "Pessoa")

public abstract class Pessoa extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome_pessoa", length = 25, nullable = false, unique = false)
	private String nome;

	@Column(name = "sobrenome_pessoa", length = 45, nullable = false, unique = false)
	private String sobrenome;

	@Column(name= "cpf", length = 14, nullable = false, unique = true)
	private String cpf;

	@Column(name= "data_nascimento", nullable = false, unique = false)
	private LocalDate dataNascimento;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contato")
	private Contato contato;

	public Pessoa() {}

	public Pessoa(Long id, String email, String senha, Papel papel, String nome, String sobrenome, String cpf,LocalDate dataNascimento, Contato contato) {
		super(id, email, senha, papel);
		setNome(nome);
		setSobrenome(sobrenome);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setContato(contato);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

}

package br.senac.criancaemfoco.modelo.entidade.pessoa.usuario;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.foto.Foto;
import br.senac.criancaemfoco.modelo.entidade.papel.Papel;
import br.senac.criancaemfoco.modelo.entidade.pessoa.Pessoa;

@Entity
@Table(name = "usuario")
public abstract class Usuario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "email", length = 30, nullable = false)
	private String email;

	@Column(name = "senha", length = 16, nullable = false)
	private String senha;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_papel")
	private Papel papel;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_foto")
	private Foto foto;

	public Usuario() {}

	public Usuario(String nomeId, String sobrenome, String idFiscal, LocalDate dataNascimento, Contato contato, String email, String senha, Papel papel, Foto foto) {
		super(nomeId, sobrenome, idFiscal, dataNascimento, contato);
		setEmail(email);
		setSenha(senha);
		setPapel(papel);
		setFoto(foto);
	}

	public Usuario(String nomeId, String idFiscal, Contato contato, String email, String senha, Papel papel, Foto foto) {
		super(nomeId, idFiscal, contato);
		setEmail(email);
		setSenha(senha);
		setPapel(papel);
		setFoto(foto);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

}

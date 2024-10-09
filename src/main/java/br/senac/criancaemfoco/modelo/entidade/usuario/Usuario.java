package br.senac.criancaemfoco.modelo.entidade.usuario;

import java.io.Serializable;
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
import br.senac.criancaemfoco.modelo.entidade.papel.Papel;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "email", length = 30, nullable = false)
	private String email;

	@Column(name = "senha", length = 16, nullable = false)
	private String senha;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_papel")
	private Papel papel;

	public Usuario() {}

	public Usuario(Long id, String email, String senha, Papel papel) {
		setId(id);
		setEmail(email);
		setSenha(senha);
		setPapel(papel);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario outro = (Usuario) obj;
		return id == outro.id;
	}

}

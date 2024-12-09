package br.senac.criancaemfoco.modelo.entidade.turma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.criancaemfoco.modelo.entidade.foto.Foto;
import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.escola.Escola;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turma")
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "turma")
	private List<Aluno> alunosTurma = new ArrayList<Aluno>();

	@Column(name = "ano_turma", nullable = false, length = 10)
	private byte anoTurma;

	@Column(name = "numero_turma", nullable = false, length = 2)
	private String numeroTurma;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_escola", referencedColumnName = "id_pessoa")
	private Escola escola;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_foto")
	private Foto foto;

	public Turma() {}

	public Turma(List<Aluno> alunosTurma, byte anoTurma, String numeroTurma, Escola escola, Foto foto) {
		setAnoTurma(anoTurma);
		setNumeroTurma(numeroTurma);
		setEscola(escola);
		setFoto(foto);
	}

	public Turma(Long id, List<Aluno> alunosTurma, byte anoTurma, String numeroTurma, Escola escola) {
		setId(id);
		setAnoTurma(anoTurma);
		setNumeroTurma(numeroTurma);
		setEscola(escola);
		setFoto(foto);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Aluno> getAlunosTurma() {
		return alunosTurma;
	}

	public boolean inserirAlunoTurma(Aluno aluno) {
		return alunosTurma.add(aluno);
	}

	public boolean removerAlunoTurma(Aluno aluno) {
		return alunosTurma.remove(aluno);
	}

	public byte getAnoTurma() {
		return anoTurma;
	}

	public void setAnoTurma(byte anoTurma) {
		this.anoTurma = anoTurma;
	}

	public String getNumeroTurma() {
		return numeroTurma;
	}

	public void setNumeroTurma(String numeroTurma) {
		this.numeroTurma = numeroTurma;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

}
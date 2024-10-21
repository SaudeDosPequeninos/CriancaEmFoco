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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.criancaemfoco.modelo.entidade.escola.Escola;
import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turma")
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "turma_aluno", 
	joinColumns = @JoinColumn(name = "id_turma"), 
	inverseJoinColumns = @JoinColumn(name = "id_usuario"))
	private List<Aluno> alunosTurma = new ArrayList<Aluno>();

	@Column(name = "ano_turma", nullable = false, length = 10)
	private String anoTurma;

	@Column(name = "numero_turma", nullable = false, length = 2)	
	private String numeroTurma;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_escola")
	private Escola escola;

	public Turma() {}

	public Turma(List<Aluno> alunosTurma, String anoTurma, String numeroTurma, Escola escola) {
		setAnoTurma(anoTurma);
		setNumeroTurma(numeroTurma);
		setEscola(escola);
	}

	public Turma(Long id, List<Aluno> alunosTurma, String anoTurma, String numeroTurma, Escola escola) {
		setId(id);
		setAnoTurma(anoTurma);
		setNumeroTurma(numeroTurma);
		setEscola(escola);
	}

    public Turma(String anoTurma, String numeroTurma) {
        this.anoTurma = anoTurma;
        this.numeroTurma = numeroTurma;
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

	public void setAlunosTurma(List<Aluno> alunosTurma) {
		this.alunosTurma = alunosTurma;
	}

	public String getAnoTurma() {
		return anoTurma;
	}

	public void setAnoTurma(String anoTurma) {
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

}
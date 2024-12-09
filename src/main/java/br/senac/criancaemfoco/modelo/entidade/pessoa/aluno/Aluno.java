package br.senac.criancaemfoco.modelo.entidade.pessoa.aluno;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.pessoa.Pessoa;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.responsavel.Responsavel;
import br.senac.criancaemfoco.modelo.entidade.procedimento.Procedimento;
import br.senac.criancaemfoco.modelo.entidade.turma.Turma;

@Entity
@Table(name = "Aluno")
public class Aluno extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "matricula_aluno", length = 20, nullable = false, unique=false)
	private String matricula;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_responsavel", referencedColumnName = "id_pessoa")
	private Responsavel responsavel;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_turma", referencedColumnName = "id_turma")
	private Turma turma;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "id_aluno")
	private List<Procedimento> procedimentos = new ArrayList<Procedimento>();

	public Aluno() {}

	public Aluno(String nomeId, String sobrenome, String idFiscal, LocalDate dataNascimento, Contato contato, String matricula, Responsavel responsavel, Turma turma) {
		super(nomeId, sobrenome, idFiscal, dataNascimento, contato);
		setMatricula(matricula);
		setResponsavel(responsavel);
		setTurma(turma);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Procedimento> getHistoricoProcedimentos() {
		return procedimentos;
	}

	public boolean inserirHistoricoProcedimento(Procedimento procedimento) {
		return procedimentos.add(procedimento);
	}

	public boolean removerHistoricoProcedimento(Procedimento procedimento) {
		return procedimentos.remove(procedimento);
	}

}
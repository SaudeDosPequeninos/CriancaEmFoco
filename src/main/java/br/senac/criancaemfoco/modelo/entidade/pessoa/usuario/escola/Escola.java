package br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.escola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.endereco.Endereco;
import br.senac.criancaemfoco.modelo.entidade.estoque.Estoque;
import br.senac.criancaemfoco.modelo.entidade.papel.Papel;
import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.Usuario;
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.enfermeiro.Enfermeiro;
import br.senac.criancaemfoco.modelo.entidade.procedimento.Procedimento;
import br.senac.criancaemfoco.modelo.entidade.turma.Turma;

@Entity
@Table(name = "escola")
public class Escola extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "escola_enfermeiro",
	joinColumns = @JoinColumn(name = "id_pessoa"),
	inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
	private List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "escola_estoque",
	joinColumns = @JoinColumn(name = "id_pessoa"),
	inverseJoinColumns = @JoinColumn(name = "id_estoque"))
	private List<Estoque> estoques = new ArrayList<Estoque>();

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "escola_aluno",
	joinColumns = @JoinColumn(name = "id_pessoa"),
	inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
	private List<Aluno> alunos = new ArrayList<Aluno>();

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "escola_turma",
	joinColumns = @JoinColumn(name = "id_pessoa"),
	inverseJoinColumns = @JoinColumn(name = "id_turma"))
	private List<Turma> turmas = new ArrayList<Turma>();

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "escola_procedimento",
	joinColumns = @JoinColumn(name = "id_pessoa"),
	inverseJoinColumns = @JoinColumn(name = "id_procedimento"))
	private List<Procedimento> tipoProcedimentos = new ArrayList<Procedimento>();

	public Escola() {}

	public Escola(String nomeId, String idFiscal, Contato contato, String email, String senha, Papel papel, Endereco endereco) {
		super(nomeId, idFiscal, contato, email, senha, papel);
		setEndereco(endereco);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Enfermeiro> getEnfermeiros() {
		return enfermeiros;
	}

	public boolean inserirEnfermeiro(Enfermeiro enfermeiro) {
		return enfermeiros.add(enfermeiro);
	}

	public boolean removerEnfermeiro(Enfermeiro enfermeiro) {
		return enfermeiros.remove(enfermeiro);
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public boolean inserirAluno(Aluno aluno) {
		return alunos.add(aluno);
	}

	public boolean removerAluno(Aluno aluno) {
		return alunos.remove(aluno);
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public boolean inserirTurma(Turma turma) {
		return turmas.add(turma);
	}

	public boolean removerTurma(Turma turma) {
		return turmas.remove(turma);
	}

	public List<Estoque> getEstoques() {
		return estoques;
	}

	public boolean inserirEstoque(Estoque estoque) {
		return estoques.add(estoque);
	}

	public boolean removerEstoque(Estoque estoque) {
		return estoques.remove(estoque);
	}

	public List<Procedimento> getProcedimento() {
		return tipoProcedimentos;
	}

	public boolean inserirProcedimento(Procedimento procedimento) {
		return tipoProcedimentos.add(procedimento);
	}

	public boolean removerProcedimento(Procedimento procedimento) {
		return tipoProcedimentos.remove(procedimento);
	} 
}
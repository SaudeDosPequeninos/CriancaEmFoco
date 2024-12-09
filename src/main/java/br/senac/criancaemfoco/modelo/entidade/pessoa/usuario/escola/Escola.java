package br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.escola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.endereco.Endereco;
import br.senac.criancaemfoco.modelo.entidade.estoque.Estoque;
import br.senac.criancaemfoco.modelo.entidade.foto.Foto;
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
	@JoinColumn(name = "id_escola")
	private List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "id_escola")
	private List<Estoque> estoques = new ArrayList<Estoque>();

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "id_escola")
	private List<Aluno> alunos = new ArrayList<Aluno>();

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="escola")
	private List<Turma> turmas = new ArrayList<Turma>();

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "id_escola")
	private List<Procedimento> tipoProcedimentos = new ArrayList<Procedimento>();

	public Escola() {}

	public Escola(String nomeId, String idFiscal, Contato contato, String email, String senha, Papel papel, Foto foto, Endereco endereco) {
		super(nomeId, idFiscal, contato, email, senha, papel, foto);
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
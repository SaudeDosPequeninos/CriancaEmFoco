package br.senac.criancaemfoco.modelo.entidade.escola;
 
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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.endereco.Endereco;
import br.senac.criancaemfoco.modelo.entidade.estoque.Estoque;
import br.senac.criancaemfoco.modelo.entidade.papel.Papel;
import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;
import br.senac.criancaemfoco.modelo.entidade.pessoa.enfermeiro.Enfermeiro;
import br.senac.criancaemfoco.modelo.entidade.turma.Turma;
 
@Entity
@Table(name = "escola")
public class Escola implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_escola")
	private Long id;

	@Column(name = "nome_escola", length = 45, nullable = false, unique = true)
	private String nomeEscola;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_contato")
	private Contato contato;

	@Column (name = "cnpj_escola", length = 18, nullable = false, unique = true)
	private String cnpjEscola;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "escola_enfermeiro",
	joinColumns = @JoinColumn(name = "id_escola"),
	inverseJoinColumns = @JoinColumn(name = "id_enfermeiro"))
	private List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "escola_estoque",
	joinColumns = @JoinColumn(name = "id_escola"),
	inverseJoinColumns = @JoinColumn(name = "id_estoque"))
	private List<Estoque> estoques = new ArrayList<Estoque>();

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "escola_aluno",
	joinColumns = @JoinColumn(name = "id_escola"),
	inverseJoinColumns = @JoinColumn(name = "id_aluno"))
	private List<Aluno> alunos = new ArrayList<Aluno>();

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "escola_turma",
	joinColumns = @JoinColumn(name = "id_escola"),
	inverseJoinColumns = @JoinColumn(name = "id_turma"))
	private List<Turma> turmas = new ArrayList<Turma>();

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id_papel")
	private Papel papel;

	public Escola() {}

	public Escola(Long id, String nomeEscola, Endereco endereco, Contato contato, String cnpjEscola, Estoque estoque, Papel papel) {
		setId(id);
		setNomeEscola(nomeEscola);
		setEndereco(endereco);
		setContato(contato);
		setCnpjEscola(cnpjEscola);
		setPapel(papel);
	}

	public Escola(String nomeEscola, Endereco endereco, Contato contato, String cnpjEscola, Estoque estoque, Papel papel) {
		setNomeEscola(nomeEscola);
		setEndereco(endereco);
		setContato(contato);
		setCnpjEscola(cnpjEscola);
		setPapel(papel);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCnpjEscola() {
		return cnpjEscola;
	}

	public void setCnpjEscola(String cnpjEscola) {
		this.cnpjEscola = cnpjEscola;
	}

	public List<Enfermeiro> getEnfermeiros() {
		return enfermeiros;
	}

	public void setEnfermeiros(List<Enfermeiro> enfermeiros) {
		this.enfermeiros = enfermeiros;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Estoque> getEstoques() {
		return estoques;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

}
package br.senac.criancaemfoco.modelo.entidade.pessoa.responsavel;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.criancaemfoco.modelo.entidade.pessoa.Pessoa;
import br.senac.criancaemfoco.modelo.entidade.pessoa.aluno.Aluno;
import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.endereco.Endereco;
import br.senac.criancaemfoco.modelo.entidade.papel.Papel;

@Entity
@Table(name = "responsavel")
public class Responsavel extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id_endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "responsavel")
    private List<Aluno> dependente = new ArrayList<Aluno>();

	public Responsavel () {}

	public Responsavel (Long id, String email, String senha, Papel papel, String nome, String sobrenome, String cpf, LocalDate dataNascimento, Contato contato, Endereco endereco, Aluno dependente) {
		super(id, email, senha, papel, nome, sobrenome, cpf, dataNascimento, contato);
		setEndereco(endereco);
		inserirDependente(dependente);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Aluno> getDependente() {
		return dependente;
	}

	public boolean inserirDependente(Aluno aluno) {
		return dependente.add(aluno);
	}

	public boolean deletarDependente(Aluno aluno) {
		return dependente.remove(aluno);
	}

}

package br.senac.criancaemfoco.modelo.entidade.procedimento;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.criancaemfoco.modelo.entidade.insumo.Insumo;

@Entity
@Table(name="procedimento")
public class Procedimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_procedimento")
	private Long id;

	@Column(name = "nome_procedimento", length = 30, nullable = false)
    private String nomeProcedimento;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "procedimento_insumo", 
	joinColumns = @JoinColumn(name = "id_procedimento"), 
	inverseJoinColumns = @JoinColumn(name = "id_insumo"))
    private List<Insumo> insumos = new ArrayList<Insumo>();;

	public Procedimento() {}

    public Procedimento(String procedimento) {
    	setNomeProcedimento(nomeProcedimento);
    }

	public String getNomeProcedimento() {
		return nomeProcedimento;
	}

	public void setNomeProcedimento(String nomeProcedimento) {
		this.nomeProcedimento = nomeProcedimento;
	}

	public List<Insumo> getInsumos() {
		return insumos;
	}

	public boolean inserirInsumo (List<Insumo> insumo) {
		return false;
	}

	public boolean removerInsumo (List<Insumo> insumo) {
		return false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
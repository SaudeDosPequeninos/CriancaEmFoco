package br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.enfermeiro;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.Usuario;
import br.senac.criancaemfoco.modelo.entidade.agendamento.Agendamento;
import br.senac.criancaemfoco.modelo.entidade.papel.Papel;
import br.senac.criancaemfoco.modelo.entidade.contato.Contato;
import br.senac.criancaemfoco.modelo.entidade.foto.Foto;

@Entity
@Table(name = "enfermeiro")
public class Enfermeiro extends Usuario implements Serializable { 

	private static final long serialVersionUID = 1L;

	@Column(name = "registro_coren", length = 45, nullable = false, unique = true)
	private String registroCoren;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "enfermeiro")
	private List<Agendamento> agendamentos = new ArrayList<Agendamento>();

	public Enfermeiro() {}

	public Enfermeiro(String nomeId, String sobrenome, String idFiscal, LocalDate dataNascimento, Contato contato, String email, String senha, Papel papel, Foto foto, String registroCoren) {
		super(nomeId, sobrenome, idFiscal, dataNascimento, contato, email, senha, papel, foto);
		setRegistroCoren(registroCoren);
	}

	public String getRegistroCoren() {
		return registroCoren;
	}

	public void setRegistroCoren(String registroCoren) {
		this.registroCoren = registroCoren;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public boolean inserirAgendamento(Agendamento agendamento) {
		return agendamentos.add(agendamento);
	}

	public boolean removerAgendamento(Agendamento agendamento) {
		return agendamentos.remove(agendamento);
	}

}

package br.senac.criancaemfoco.modelo.entidade.agendamento;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import br.senac.criancaemfoco.modelo.entidade.pessoa.usuario.enfermeiro.Enfermeiro;
import br.senac.criancaemfoco.modelo.entidade.procedimento.Procedimento;
import br.senac.criancaemfoco.modelo.enumeracao.status.Status;

@Entity
@Table(name = "agendamento")
public class Agendamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agendamento")
	private Long id;

	@Column(name = "data_agendamento", nullable = false, unique = false)
	private LocalDate data;

	@Column(name = "horario_agendamento", nullable = false, unique = false)
	private LocalTime horario;

	@Column(name = "tempo_duracao_agendamento", nullable = false, unique = false)
	private LocalTime tempoDuracao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_enfermeiro")
	private Enfermeiro enfermeiro;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_agendamento")
	private List<Procedimento> procedimentos = new ArrayList<Procedimento>();

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_foto")
	private Foto foto;

	public Agendamento() {}

	public Agendamento(LocalDate data, LocalTime horario, LocalTime tempoDuracao, Aluno aluno, Enfermeiro enfermeiro, Foto foto) {
		setData(data);
		setHorario(horario);
		setTempoDuracao(tempoDuracao);
		setAluno(aluno);
		setEnfermeiro(enfermeiro);
		setFoto(foto);
	}

	public Agendamento(Long id,LocalDate data, LocalTime horario, LocalTime tempoDuracao, Aluno aluno, Enfermeiro enfermeiro, Foto foto) {
		setId(id);
		setData(data);
		setHorario(horario);
		setTempoDuracao(tempoDuracao);
		setAluno(aluno);
		setEnfermeiro(enfermeiro);
		setFoto(foto);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public LocalTime getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(LocalTime tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Enfermeiro getEnfermeiro() {
		return enfermeiro;
	}

	public void setEnfermeiro(Enfermeiro enfermeiro) {
		this.enfermeiro = enfermeiro;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public boolean inserirProcedimento(Procedimento procedimento) {
		if (procedimento == null)
			return false;

		if (procedimento.getClass().getName() != "Procedimento")
			return false;

		if (procedimentos.contains(procedimento))
			return false;

		return procedimentos.add(procedimento);
	}

	public boolean removerProcedimento(Procedimento procedimento) {
		if (procedimentos.contains(procedimento))
			return false;

		int i = procedimentos.indexOf(procedimento);

		if (i < 0)
			return false;

		this.procedimentos.remove(i);

		return true;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

}
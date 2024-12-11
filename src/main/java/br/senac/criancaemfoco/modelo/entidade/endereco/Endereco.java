package br.senac.criancaemfoco.modelo.entidade.endereco;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;

	@Column(name = "logradouro", nullable = false, length = 100)
	private String logradouro;

	@Column(name = "numero", nullable = false, length = 4)
	private short numero;

	@Column(name = "tipo", nullable = false, length = 45)
	private String tipo;

	@Column(name = "cep", nullable = false, length = 9)
	private int cep;

	@Column(name = "bairro", nullable = false, length = 45)
	private String bairro;

	@Column(name = "cidade", nullable = false, length = 45)
	private String cidade;

	@Column(name = "estado", nullable = false, length = 45)
	private String estado;

	public Endereco() {}

	public Endereco(String logradouro, short numero, String tipo, int cep, String bairro, String cidade, String estado) {
		super();
		setLogradouro(logradouro);
		setNumero(numero);
		setTipo(tipo);
		setCep(cep);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
	}

	public Long getID() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
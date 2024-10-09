package br.senac.criancaemfoco.modelo.entidade.estoque;
 
import br.senac.criancaemfoco.modelo.entidade.insumo.Insumo;
 
import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estoque")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_insumo")
	private Insumo insumo;

	@Column(name = "quantidade", length = 100, nullable = false)
	private byte quantidade;

	public Estoque() {}

	public Estoque(Long id, Insumo insumo, byte quantidade) {
		setId(id);
		setInsumo(insumo);
		setQuantidade(quantidade);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public byte getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(byte quantidade) {
		this.quantidade = quantidade;
	}

}
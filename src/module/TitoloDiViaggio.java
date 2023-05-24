package module;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class TitoloDiViaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer biglietto_id;

	@Column(nullable = false)
	private boolean valido = true;

	@Column(nullable = false)
	private LocalDateTime data_emissione;

	@ManyToOne
	private PuntiVendita punto_emissione;

	

	public TitoloDiViaggio(PuntiVendita punto_emissione) {
		super();
		this.punto_emissione = punto_emissione;
		this.data_emissione = LocalDateTime.now();
	}

	public TitoloDiViaggio() {
		super();
	}

	@Override
	public String toString() {
		return "TitoloDiViaggio [biglietto_id=" + biglietto_id + ", valido=" + valido + ", data_emissione="
				+ data_emissione.format(DateTimeFormatter.ISO_DATE) + "]";
	}

	public Integer getBiglietto_id() {
		return biglietto_id;
	}

	public void setBiglietto_id(Integer biglietto_id) {
		this.biglietto_id = biglietto_id;
	}

	public PuntiVendita getPunto_emissione() {
		return punto_emissione;
	}

	public void setPunto_emissione(PuntiVendita punto_emissione) {
		this.punto_emissione = punto_emissione;
	}

	public boolean getValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public LocalDateTime getData_emissione() {
		return data_emissione;
	}

	public void setData_emissione(LocalDateTime data_emissione) {
		this.data_emissione = data_emissione;
	}

}

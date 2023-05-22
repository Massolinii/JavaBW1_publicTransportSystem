package module;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class TitoloDiViaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer biglietto_id;
	
	@Column (nullable = false)
	private boolean valido = true;
	
	@Column (nullable = false)
	private LocalDateTime data_emissione ;
	
	public TitoloDiViaggio() {
		super();
	}

	public TitoloDiViaggio(LocalDateTime data_emissione) {
		super();
		this.data_emissione = data_emissione;
	}

	@Override
	public String toString() {
		return "TitoloDiViaggio [biglietto_id=" + biglietto_id + ", valido=" + valido + ", data_emissione="
				+ data_emissione + "]";
	}

	public Integer getBiglietto_id() {
		return biglietto_id;
	}

	public void setBiglietto_id(Integer biglietto_id) {
		this.biglietto_id = biglietto_id;
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

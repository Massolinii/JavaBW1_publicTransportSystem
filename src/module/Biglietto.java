package module;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "biglietti")
public class Biglietto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer biglietto_id;
	
	@Column (nullable = false)
	private LocalDate data_emissione;
	
	@Column (nullable = false)
	private boolean valido = true;

	public Biglietto() {
		super();
	}

	public Biglietto(LocalDate data_emissione, boolean valido) {
		super();
		this.data_emissione = data_emissione;
		this.valido = valido;
	}

	@Override
	public String toString() {
		return "Biglietto [biglietto_id=" + biglietto_id + ", data_emissione=" + data_emissione + ", valido=" + valido
				+ "]";
	}

	

	
	
	
	

}

package module;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PuntiVendita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer punto_vendita_id;
	
	private List<Biglietto> biglietti_stampati;
	
	private String localita;
	

	public List<Biglietto> getBiglietti_stampati() {
		return biglietti_stampati;
	}

	public void setBiglietti_stampati(List<Biglietto> biglietti_stampati) {
		this.biglietti_stampati = biglietti_stampati;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public PuntiVendita(List<Biglietto> biglietti_stampati, String localita) {
		super();
		this.biglietti_stampati = biglietti_stampati;
		this.localita = localita;
	}
	
	
	
	

}

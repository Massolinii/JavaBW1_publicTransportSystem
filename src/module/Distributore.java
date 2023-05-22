package module;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Enums.Funzione;

public class Distributore extends PuntiVendita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cardId;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	protected Funzione funzione;

	public Distributore(List<Biglietto> biglietti_stampati, String localita, Funzione funzione) {
		super(biglietti_stampati, localita);
		this.funzione = funzione;
	}

	public Distributore(List<Biglietto> biglietti_stampati, String localita) {
		super(biglietti_stampati, localita);
	}

	@Override
	public String toString() {
		return "Distributore [cardId=" + cardId + ", funzione=" + funzione + "]";
	}
	
	

}

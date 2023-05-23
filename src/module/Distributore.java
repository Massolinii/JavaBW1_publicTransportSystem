package module;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import Enums.FunzioneDistributore;

@Entity
@DiscriminatorValue(value = "distributore")
public class Distributore extends PuntiVendita {

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	protected FunzioneDistributore funzione;

	public Distributore(String localita, FunzioneDistributore funzione) {
		super(localita);
		this.funzione = funzione;
	}

	public Distributore() {
		super();
	}

	public FunzioneDistributore getFunzione() {
		return funzione;
	}

	public void setFunzione(FunzioneDistributore funzione) {
		this.funzione = funzione;
	}

	@Override
	public String toString() {
		return "Distributore [ funzione=" + funzione + "]" + super.toString();
	}

}

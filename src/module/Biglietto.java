package module;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "biglietto")
public class Biglietto extends TitoloDiViaggio {
	
	
	private LocalDateTime orario_validazione;
	
	public Biglietto() {
		super();
	}
	
	public Biglietto(LocalDateTime data_emissione) {
		super(data_emissione);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	public LocalDateTime getOrario_validazione() {
		return orario_validazione;
	}

	public void setOrario_validazione(LocalDateTime orario_validazione) {
		this.orario_validazione = orario_validazione;
	}
	
}

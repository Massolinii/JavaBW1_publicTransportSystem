package module;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "biglietto")
public class Biglietto extends TitoloDiViaggio {
	
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

	
}

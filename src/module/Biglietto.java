package module;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "biglietto")
public class Biglietto extends TitoloDiViaggio {
	
	public Biglietto() {
		super();
	}

	@Override
	public String toString() {
		return "Biglietto []";
	}

	
}

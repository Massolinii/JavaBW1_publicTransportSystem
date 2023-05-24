package module;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value = "bus")
public class Bus extends Mezzo {
	
	
	@Id
	private String targa;
	
	
	
}

package module;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value = "tram")
public class Tram extends Mezzo {
	
	@Id
	private String targa;
	
}

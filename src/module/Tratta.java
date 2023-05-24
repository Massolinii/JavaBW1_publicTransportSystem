package module;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@DiscriminatorValue(value = "tratte")
public class Tratta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer n_tratta;
	
	@Column(nullable = false)
	private String punto_partenza;
	
	@Column(nullable = false)
	private String capolinea;

	
	
}

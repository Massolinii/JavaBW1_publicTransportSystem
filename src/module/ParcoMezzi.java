package module;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ParcoMezzi {
	
	@Id
	private String targa;
	
	private Integer capienza_mezzo;

	private Integer velocita_media;
	
	

}

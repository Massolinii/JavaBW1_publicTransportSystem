package module;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Enums.StatusMezzo;

@Entity
@DiscriminatorValue(value = "tram")
public class Tram extends Parco_Mezzi {

	public Tram() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tram(String targa, Integer capienza, StatusMezzo status, LocalDateTime startStatus,
			LocalDateTime endStatus) {
		super(targa, capienza, status, startStatus, endStatus);
		// TODO Auto-generated constructor stub
	}

	
}

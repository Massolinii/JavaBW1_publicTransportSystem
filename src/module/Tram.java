package module;

import java.time.LocalDate;

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

	public Tram(String targa, Integer capienza, StatusMezzo status, LocalDate startStatus) {
		super(targa, capienza, status, startStatus);
		// TODO Auto-generated constructor stub
	}

	public Tram(String targa, Integer capienza, StatusMezzo status) {
		super(targa, capienza, status);
		// TODO Auto-generated constructor stub
	}

}

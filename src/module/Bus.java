package module;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Enums.StatusMezzo;

@Entity
@DiscriminatorValue(value = "bus")
public class Bus extends Parco_Mezzi {

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(String targa, Integer capienza, StatusMezzo status, LocalDate startStatus) {
		super(targa, capienza, status, startStatus);
		// TODO Auto-generated constructor stub
	}

	public Bus(String targa, Integer capienza, StatusMezzo status) {
		super(targa, capienza, status);
		// TODO Auto-generated constructor stub
	}

}

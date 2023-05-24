package module;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

	public Bus(String targa, Integer capienza, StatusMezzo status, LocalDateTime startStatus, LocalDateTime endStatus) {
		super(targa, capienza, status, startStatus, endStatus);
		
	}

	
}

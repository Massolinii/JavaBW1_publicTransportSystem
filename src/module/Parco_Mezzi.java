package module;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import Enums.StatusMezzo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Parco_Mezzi {

	@Id
	private String targa;

	@Column(nullable = false)
	private Integer capienza;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusMezzo status;

	// null
	@Column(name = "inizio_manutenzione")
	private LocalDate startStatus;
	@Column(name = "fine_manutenzione")
	private LocalDate endStatus;

	public Parco_Mezzi() {
		super();
	}

	public Parco_Mezzi(String targa, Integer capienza, StatusMezzo status) {
		this.targa = targa;
		this.capienza = capienza;
		this.status = status;

	}

	public Parco_Mezzi(String targa, Integer capienza, StatusMezzo status, LocalDate startStatus) {
		super();
		this.targa = targa;
		this.capienza = capienza;
		this.status = status;
		this.startStatus = startStatus;
		this.endStatus = startStatus.plusDays(5);
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Integer getCapienza() {
		return capienza;
	}

	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	public StatusMezzo getStatus() {
		return status;
	}

	public void setStatus(StatusMezzo status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Mezzo [targa=" + targa + ", capienza=" + capienza + ", status=" + status + ", startStatus="
				+ startStatus + ", endStatus=" + endStatus + "]";
	}

}

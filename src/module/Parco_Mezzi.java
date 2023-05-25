package module;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

import Enums.StatusMezzo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
@NamedQuery(name = "mezzi.getAll", query = "SELECT m FROM Parco_Mezzi m")
@NamedQuery(name = "mezzi.getInManutenzione", query = "SELECT m FROM Parco_Mezzi m WHERE m.status =Enums.StatusMezzo.IN_MANUTENZIONE")
@NamedQuery(name = "mezzi.getInServizio", query = "SELECT m FROM Parco_Mezzi m WHERE m.status =Enums.StatusMezzo.IN_SERVIZIO")

public class Parco_Mezzi {

	@Id
	private String targa;

	@Column(nullable = false)
	private Integer capienza;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusMezzo status;

	// null
	@Column(name = "inizio_status")
	private LocalDateTime startStatus;
	@Column(name = "fine_status")
	private LocalDateTime endStatus;

	private Integer countPassanger;

	public Parco_Mezzi() {
		super();
	}

	public Parco_Mezzi(String targa, Integer capienza, StatusMezzo status, LocalDateTime startStatus,
			LocalDateTime endStatus) {
		super();
		this.targa = targa;
		this.capienza = capienza;
		this.status = status;
		this.startStatus = startStatus;
		this.endStatus = endStatus;
		this.countPassanger = 0;
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

	public Integer getCountPassanger() {
		return countPassanger;
	}

	public void setCountPassanger(Integer countPassanger) {
		this.countPassanger = countPassanger;
	}

	public LocalDateTime getStartStatus() {
		return startStatus;
	}

	public void setStartStatus(LocalDateTime startStatus) {
		this.startStatus = startStatus;
	}

	public LocalDateTime getEndStatus() {
		return endStatus;
	}

	public void setEndStatus(LocalDateTime endStatus) {
		this.endStatus = endStatus;
	}

}

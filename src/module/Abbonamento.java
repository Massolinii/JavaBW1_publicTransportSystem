package module;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import Enums.DurataAbbonamento;

@Entity
//@DiscriminatorValue(value = "abbonamento")
public class Abbonamento extends TitoloDiViaggio {

	@Column
	@Enumerated(EnumType.STRING)
	protected DurataAbbonamento durata;

	private LocalDateTime scadenza_abbonameto;

	public Abbonamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Abbonamento(PuntiVendita puntoDiEmissione, DurataAbbonamento durata) {
		super(puntoDiEmissione);
		this.durata = durata;
		// TODO Auto-generated constructor stub
	}

	public DurataAbbonamento getDurata() {
		return durata;
	}

	public void setDurata(DurataAbbonamento durata) {
		this.durata = durata;
	}

	public LocalDateTime getScadenza_abbonameto() {
		return scadenza_abbonameto;
	}

	public void setScadenza_abbonameto(LocalDateTime scadenza_abbonameto) {
		this.scadenza_abbonameto = scadenza_abbonameto;
	}

	@Override
	public String toString() {
		return "Abbonamento [durata=" + durata + ", scadenza="
				+ this.scadenza_abbonameto.format(DateTimeFormatter.ISO_DATE) + "][" + super.toString() + "]";
	}

}

package module;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Enums.DurataAbbonamento;
import net.bytebuddy.asm.Advice.Local;

@Entity
@DiscriminatorValue(value = "abbonamento")
public class Abbonamento extends TitoloDiViaggio {

	@Column
	protected DurataAbbonamento durata;
	
	private LocalDateTime scadenza_abbonameto;

	public Abbonamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Abbonamento(DurataAbbonamento durata) {
		super();
		this.durata = durata;
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
		return "Abbonamento [durata=" + durata + ", scadenza="+this.scadenza_abbonameto.format(DateTimeFormatter.ISO_DATE)+"]["+super.toString()+"]";
	}


}

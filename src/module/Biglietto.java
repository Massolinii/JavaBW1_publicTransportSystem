package module;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "biglietto")
@NamedQuery(name = "biglietto.getAll", query = "SELECT b FROM Biglietto b")
public class Biglietto extends TitoloDiViaggio {

	private LocalDateTime orario_validazione;

	@OneToOne
	private Parco_Mezzi mezzo;

	// hibernate
	public Biglietto() {
		super();
	}

//il biglietto viene validato e fatto l'update, scusate l'italiano
	public Biglietto(PuntiVendita punto_emissione, LocalDateTime orario_validazione, Parco_Mezzi mezzo) {
		super(punto_emissione);
		this.orario_validazione = orario_validazione;
		this.mezzo = mezzo;
	}

//questo costruttore è per il biglietto emesso dal distributore!
	public Biglietto(PuntiVendita punto_emissione) {
		super(punto_emissione);

	}

	@Override
	public String toString() {
		return super.toString();
	}

	public LocalDateTime getOrario_validazione() {
		return orario_validazione;
	}

	public void setOrario_validazione(LocalDateTime orario_validazione) {
		this.orario_validazione = orario_validazione;
	}

	public Parco_Mezzi getMezzo() {
		return mezzo;
	}

	public void setMezzo(Parco_Mezzi mezzo) {
		this.mezzo = mezzo;
	}

}

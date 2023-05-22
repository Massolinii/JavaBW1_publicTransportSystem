package module;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tessera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tessera_id;
	
	@Column(nullable = false)
	private Utente utente;
	
	@Column(nullable = false)
	private LocalDate data_inizio;
	
	@Column(nullable = false)
	private LocalDate data_scadenza = data_inizio.plusMonths(12);
	
	public Tessera() {
		super();
	}

	public Tessera(Utente utente, LocalDate data_inizio, LocalDate data_scadenza) {
		super();
		this.utente = utente;
		this.data_inizio = data_inizio;
		this.data_scadenza = data_scadenza;
	}

	@Override
	public String toString() {
		return "Tessera [tessera_id=" + tessera_id + ", utente=" + utente + ", data_inizio=" + data_inizio
				+ ", data_scadenza=" + data_scadenza + "]";
	}

	
	
}

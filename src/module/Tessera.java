package module;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Tessera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tessera_id;

	@Column(nullable = false)
	@OneToOne
	private Utente utente;

	@Column(nullable = false)
	private LocalDate data_inizio;

	@Column(nullable = false)
	private LocalDate data_scadenza = data_inizio.plusMonths(12);

	@OneToOne
	@Column(nullable = false)
	Abbonamento abbonamento;

	public Tessera() {
		super();
	}

	public Tessera(Integer tessera_id, Utente utente, LocalDate data_inizio, LocalDate data_scadenza,
			Abbonamento abbonamento) {
		super();
		this.tessera_id = tessera_id;
		this.utente = utente;
		this.data_inizio = data_inizio;
		this.data_scadenza = data_inizio.plusYears(1);
		this.abbonamento = abbonamento;
	}

	@Override
	public String toString() {
		return "Tessera [tessera_id=" + tessera_id + ", utente=" + utente + ", data_inizio=" + data_inizio
				+ ", data_scadenza=" + data_scadenza + "]";
	}

}

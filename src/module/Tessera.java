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
	private String nome;

	@Column(nullable = false)
	private String cognome;

	@Column(nullable = false)
	private LocalDate birthday;

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

	public Tessera(String nome, String cognome, LocalDate birthday, LocalDate data_inizio, LocalDate data_scadenza,
			Abbonamento abbonamento) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.birthday = birthday;
		this.data_inizio = data_inizio;
		this.data_scadenza = data_inizio.plusYears(1);
		this.abbonamento = abbonamento;
	}

	@Override
	public String toString() {
		return "Tessera [tessera_id=" + tessera_id + ", nome=" + nome + ", cognome=" + cognome + ", birthday="
				+ birthday + ", data_inizio=" + data_inizio + ", data_scadenza=" + data_scadenza + ", abbonamento="
				+ abbonamento + "]";
	}

}

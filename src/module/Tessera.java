package module;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tessere")
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

	@Column(nullable = true)
	private LocalDate data_scadenza;

	@OneToOne
	private Abbonamento abbonamento;

	public Tessera() {
		super();
	}

	public Tessera(String nome, String cognome, LocalDate birthday, LocalDate data_inizio, Abbonamento abbonamento) {
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

	public Integer getTessera_id() {
		return tessera_id;
	}

	public void setTessera_id(Integer tessera_id) {
		this.tessera_id = tessera_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public LocalDate getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(LocalDate data_inizio) {
		this.data_inizio = data_inizio;
	}

	public LocalDate getData_scadenza() {
		return data_scadenza;
	}

	public void setData_scadenza(LocalDate data_scadenza) {
		this.data_scadenza = data_scadenza;
	}

	public Abbonamento getAbbonamento() {
		return abbonamento;
	}

	public void setAbbonamento(Abbonamento abbonamento) {
		this.abbonamento = abbonamento;
	}

}

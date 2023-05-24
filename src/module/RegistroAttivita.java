package module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(name = "registroAttivita.corsePerMezzoSuTratta", query = "SELECT a FROM RegistroAttivita a WHERE a.mezzo.targa= :targaMezzo AND a.tratta.n_tratta= :idTratta ")
public class RegistroAttivita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_attivita;

	private Integer tempoEffettivo;
	@OneToOne
	private Parco_Mezzi mezzo;

	@OneToOne
	private Tratta tratta;

	public RegistroAttivita(Parco_Mezzi mezzo, Tratta tratta) {
		super();
		this.mezzo = mezzo;
		this.tratta = tratta;
	}

	public RegistroAttivita() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_partenza() {
		return id_attivita;
	}

	public void setId_partenza(Integer id_partenza) {
		this.id_attivita = id_partenza;
	}

	public Parco_Mezzi getMezzo() {
		return mezzo;
	}

	public void setMezzo(Parco_Mezzi mezzo) {
		this.mezzo = mezzo;
	}

	public Tratta getTratta() {
		return tratta;
	}

	public void setTratta(Tratta tratta) {
		this.tratta = tratta;
	}

	public Integer getTempoEffettivo() {
		return tempoEffettivo;
	}

	public void setTempoEffettivo(Integer tempoEffettivo) {
		this.tempoEffettivo = tempoEffettivo;
	}

	@Override
	public String toString() {
		return "Registro [id_partenza=" + id_attivita + ", mezzo=" + mezzo + ", tratta=" + ", tempoEffettivo="
				+ tempoEffettivo + "]";
	}

}

package module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tratte")
public class Tratta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer n_tratta;

	@Column(nullable = false)
	private String punto_partenza;

	@Column(nullable = false)
	private String capolinea;

	@Column(nullable = false)
	private Integer tempoMedio;

	@Column(nullable = false)
	private Integer lunghezzaPercorso;

	public Tratta(String punto_partenza, String capolinea, Integer tempoMedio, Integer lunghezzaPercorso) {
		super();
		this.punto_partenza = punto_partenza;
		this.capolinea = capolinea;
		this.tempoMedio = tempoMedio;
		this.lunghezzaPercorso = lunghezzaPercorso;
	}

	public Tratta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getN_tratta() {
		return n_tratta;
	}

	public void setN_tratta(Integer n_tratta) {
		this.n_tratta = n_tratta;
	}

	public String getPunto_partenza() {
		return punto_partenza;
	}

	public void setPunto_partenza(String punto_partenza) {
		this.punto_partenza = punto_partenza;
	}

	public String getCapolinea() {
		return capolinea;
	}

	public void setCapolinea(String capolinea) {
		this.capolinea = capolinea;
	}

	public Integer getTempoMedio() {
		return tempoMedio;
	}

	public void setTempoMedio(Integer tempoMedio) {
		this.tempoMedio = tempoMedio;
	}

	@Override
	public String toString() {
		return "Tratta [n_tratta=" + n_tratta + ", punto_partenza=" + punto_partenza + ", capolinea=" + capolinea
				+ ", tempoMedio=" + tempoMedio + "]";
	}

}

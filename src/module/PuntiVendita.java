package module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "punti_vendita")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PuntiVendita {

	@Id
	@GeneratedValue // (strategy = GenerationType.IDENTITY)
	private Integer punto_vendita_id;

	private String localita;

	public Integer getPunto_vendita_id() {
		return punto_vendita_id;
	}

	public void setPunto_vendita_id(Integer punto_vendita_id) {
		this.punto_vendita_id = punto_vendita_id;
	}

	public PuntiVendita() {
		super();
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public PuntiVendita(String localita) {
		super();
		this.localita = localita;
	}

	@Override
	public String toString() {
		return "PuntiVendita [punto_vendita_id=" + punto_vendita_id + ", localita=" + localita + "]";
	}

}

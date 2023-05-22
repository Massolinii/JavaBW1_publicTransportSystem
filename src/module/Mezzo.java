package module;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import Enums.StatusMezzi;

public class Mezzo {
	
	@Id
	private Integer targa;
	
	@Column(nullable = false)
	private Integer capienza;
	
	@Column(nullable = false)
	private StatusMezzi status;
	
	@Column(nullable = false)
	private List<Biglietto> bigliettiTimbrati;

	public Mezzo() {
		super();
	}

	public Mezzo(Integer targa, Integer capienza, StatusMezzi status, List<Biglietto> bigliettiTimbrati) {
		super();
		this.targa = targa;
		this.capienza = capienza;
		this.status = status;
		this.bigliettiTimbrati = bigliettiTimbrati;
	}

	public Integer getTarga() {
		return targa;
	}

	public void setTarga(Integer targa) {
		this.targa = targa;
	}

	public Integer getCapienza() {
		return capienza;
	}

	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	public StatusMezzi getStatus() {
		return status;
	}

	public void setStatus(StatusMezzi status) {
		this.status = status;
	}

	public List<Biglietto> getBigliettiTimbrati() {
		return bigliettiTimbrati;
	}

	public void setBigliettiTimbrati(List<Biglietto> bigliettiTimbrati) {
		this.bigliettiTimbrati = bigliettiTimbrati;
	}

	@Override
	public String toString() {
		return "Mezzo [targa=" + targa + ", capienza=" + capienza + ", status=" + status + ", bigliettiTimbrati="
				+ bigliettiTimbrati + "]";
	}

	
	
}

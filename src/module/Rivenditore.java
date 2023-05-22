package module;

import java.time.LocalTime;
import java.util.List;

public class Rivenditore extends PuntiVendita {
	
	private String nome;

	private LocalTime orario_apertura;
	
	private LocalTime orario_chiusura = orario_apertura.plusHours(8);

	public Rivenditore(List<Biglietto> biglietti_stampati, String localita, String nome, LocalTime orario_apertura,
			LocalTime orario_chiusura) {
		super(biglietti_stampati, localita);
		this.nome = nome;
		this.orario_apertura = orario_apertura;
		this.orario_chiusura = orario_chiusura;
	}

	public Rivenditore(List<Biglietto> biglietti_stampati, String localita) {
		super(biglietti_stampati, localita);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalTime getOrario_apertura() {
		return orario_apertura;
	}

	public void setOrario_apertura(LocalTime orario_apertura) {
		this.orario_apertura = orario_apertura;
	}

	public LocalTime getOrario_chiusura() {
		return orario_chiusura;
	}

	public void setOrario_chiusura(LocalTime orario_chiusura) {
		this.orario_chiusura = orario_chiusura;
	}

	@Override
	public String toString() {
		return "Rivenditore [nome=" + nome + ", orario_apertura=" + orario_apertura + ", orario_chiusura="
				+ orario_chiusura + "]";
	}
	
	
	
	
}

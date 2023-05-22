package module;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userID;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private LocalDate birthday;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Tessera tessera;

	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, LocalDate birthday, Tessera tessera) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.birthday = birthday;
		this.tessera = tessera;
	}

	@Override
	public String toString() {
		return "Utente [userID=" + userID + ", nome=" + nome + ", cognome=" + cognome + ", birthday=" + birthday
				+ ", tessera=" + tessera + "]";
	}
	
	/*
	 CLASSE tessera 
string utente
LocalDate now = LocalDate.now()
public static Prestito createForNow(Utente utente , ElementoCatalogo elementoPrestato) {
        LocalDate now = LocalDate.now();
        Prestito result = new Prestito();
        result.utente = utente;
        result.elementoPrestato = elementoPrestato;
        result.dataInizioPrestito = now.format(DateTimeFormatter.ISO_DATE);
        result.dataRestituzionePrevista = now.plusDays(30).format(DateTimeFormatter.ISO_DATE);
        result.dataRestituzioneEffettiva = null;
        return result;
    };
localdate scadenza = inizio.plusmonth(12)
localdate inizio = 
@id
@generatedvalue
int codiceunivoc
-----------------------------
distributore EX BIGLIETTO
Enum funziona? . ENUM
----------------------------
rivenDITORI EX BIGLIETTO
LocalDate apertura;
LocalDate chiusura;
	 */

}

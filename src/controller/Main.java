package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import Enums.DurataAbbonamento;
import Enums.FunzioneDistributore;
import Enums.StatusMezzo;
import dao.AbbonametoDAO;
import dao.BigliettoDAO;
import dao.IAbbonamentiDAO;
import dao.IBigliettoDAO;
import dao.IParcoMezziDao;
import dao.IPuntoVenditaDAO;
import dao.IRegistroAttivitaDAO;
import dao.ITesseraDAO;
import dao.ITrattaDAO;
import dao.ParcoMezziDao;
import dao.PuntiVenditaDAO;
import dao.RegistroAttivitaDAO;
import dao.TesseraDAO;
import dao.TrattaDAO;
import module.Abbonamento;
import module.Biglietto;
import module.Bus;
import module.Distributore;
import module.RegistroAttivita;
import module.Rivenditore;
import module.Tessera;
import module.Tram;
import module.Tratta;

public class Main {

	static protected IBigliettoDAO bigliettoDAO = new BigliettoDAO();
	static protected IAbbonamentiDAO abbonamentoDAO = new AbbonametoDAO();
	static protected IPuntoVenditaDAO puntiVenditaDAO = new PuntiVenditaDAO();
	static protected ITesseraDAO tesseraDAO = new TesseraDAO();
	static protected IParcoMezziDao parcoMezziDao = new ParcoMezziDao();
	static protected IRegistroAttivitaDAO registroAttivitaDAO = new RegistroAttivitaDAO();
	static protected ITrattaDAO trattaDAO = new TrattaDAO();

	public static void main(String[] args) {

//		Abbonamento a1 = new Abbonamento(DurataAbbonamento.MENSILE,);
//		a1.setScadenza_abbonameto(LocalDateTime.of(LocalDate.of(2023, 3, 10), LocalTime.now()));
//		Biglietto b1 = new Biglietto();
//		System.out.println(b1.toString()); 
		try {
			/*
			 * BIGLIETTI bigliettoDAO.save(b1); bigliettoDAO.convalida(1);
			 * bigliettoDAO.convalida(1); bigliettoDAO.convalida(2);
			 */
			start();
//			ABBONAMENTI
//			abbonamentoDAO.save(a1);
//			abbonamentoDAO.checkScadenza(1);
			// abbonamentoDAO.rinnovo(1);

//			Punti Vendita
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void start() {
		Distributore d1 = new Distributore("Napoli", FunzioneDistributore.IN_SERVIZIO);
		Distributore d2 = new Distributore("Roma", FunzioneDistributore.IN_SERVIZIO);
		Distributore d3 = new Distributore("Torino", FunzioneDistributore.FUORI_SERVIZIO);
		Rivenditore rv1 = new Rivenditore("Napoli", "Bossetti", LocalTime.of(9, 0), LocalTime.of(18, 30));
		Rivenditore rv2 = new Rivenditore("Roma", "Totti", LocalTime.of(9, 0), LocalTime.of(18, 30));
		Rivenditore rv3 = new Rivenditore("Torino", "Vittorio Emanuele Umberto", LocalTime.of(9, 0),
				LocalTime.of(9, 1));
		puntiVenditaDAO.save(d1);
		puntiVenditaDAO.save(d2);
		puntiVenditaDAO.save(d3);
		puntiVenditaDAO.save(rv1);
		puntiVenditaDAO.save(rv2);
		puntiVenditaDAO.save(rv3);
		Biglietto b1 = new Biglietto(d1);
		Biglietto b2 = new Biglietto(d2);
		Biglietto b3 = new Biglietto(d3);
		Biglietto b4 = new Biglietto(d1);
		bigliettoDAO.save(b1);
		bigliettoDAO.save(b2);
		bigliettoDAO.save(b3);
		bigliettoDAO.save(b4);
		Abbonamento abb1 = new Abbonamento(d1, DurataAbbonamento.MENSILE);
		Abbonamento abb2 = new Abbonamento(d2, DurataAbbonamento.MENSILE);
		Abbonamento abb3 = new Abbonamento(d2, DurataAbbonamento.SETTIMANALE);
		Abbonamento abb4 = new Abbonamento(d3, DurataAbbonamento.SETTIMANALE);
		abbonamentoDAO.save(abb1);
		abbonamentoDAO.save(abb2);
		abbonamentoDAO.save(abb3);
		abbonamentoDAO.save(abb4);
		Tessera tess1 = new Tessera("Antonio", "Cancemi", LocalDate.of(2002, 5, 17), LocalDate.now(), abb4);
		Tessera tess2 = new Tessera("Luigi", "Cervo", LocalDate.of(1999, 9, 13), LocalDate.now(), abb2);
		Tessera tess3 = new Tessera("Massimiliao", "Esposito", LocalDate.of(1999, 1, 29), LocalDate.of(2021, 1, 1),
				abb3);
		Tessera tess4 = new Tessera("Davide", "March", LocalDate.of(2002, 7, 30), LocalDate.now(), abb1);
		tesseraDAO.save(tess1);
		tesseraDAO.save(tess2);
		tesseraDAO.save(tess3);
		tesseraDAO.save(tess4);

//		tesseraDAO.checkAbb(1);
//		tesseraDAO.rinnovoTessera(3);

//		Abbonamento ab1=new Abbonamento()
		Bus bus1 = new Bus("DA523MF", 2, StatusMezzo.IN_SERVIZIO, LocalDateTime.now(),
				LocalDateTime.now().plusHours(8));
		Bus bus4 = new Bus("DZ523MF", 2, StatusMezzo.IN_SERVIZIO, LocalDateTime.now(),
				LocalDateTime.now().plusHours(8));
		Bus bus2 = new Bus("BA923DZ", 10, StatusMezzo.FUORI_SERVIZIO, null, null);
		Bus bus3 = new Bus("CF394AR", 20, StatusMezzo.IN_MANUTENZIONE, LocalDateTime.now(),
				LocalDateTime.now().plusDays(3));
		Tram tram1 = new Tram("CF554AW", 5, StatusMezzo.IN_SERVIZIO, LocalDateTime.now(),
				LocalDateTime.now().plusHours(8));
		Tram tram2 = new Tram("FB293SM", 30, StatusMezzo.IN_MANUTENZIONE, LocalDateTime.now(),
				LocalDateTime.now().plusDays(9));
		Tram tram3 = new Tram("FG567SB", 50, StatusMezzo.FUORI_SERVIZIO, null, null);
		Tram tram4 = new Tram("CF654AW", 5, StatusMezzo.IN_SERVIZIO, LocalDateTime.now(),
				LocalDateTime.now().plusHours(8));
		parcoMezziDao.save(bus3);
		parcoMezziDao.save(bus2);
		parcoMezziDao.save(bus1);
		parcoMezziDao.save(tram1);
		parcoMezziDao.save(tram2);
		parcoMezziDao.save(tram3);
		parcoMezziDao.save(tram4);
		parcoMezziDao.save(bus4);

		Tratta tratta1 = new Tratta("corso Polli", "stazione Centrale", 20, 5);
		Tratta tratta2 = new Tratta("corso Dante", "Porto", 15, 7);
		Tratta tratta3 = new Tratta("Piazza Umberto", "salici", 30, 3);

		trattaDAO.save(tratta1);
		trattaDAO.save(tratta2);
		trattaDAO.save(tratta3);

		RegistroAttivita a1 = new RegistroAttivita(tram1, tratta3, 20);
		RegistroAttivita a2 = new RegistroAttivita(tram1, tratta3, 25);
		RegistroAttivita a3 = new RegistroAttivita(tram1, tratta3, 15);
		RegistroAttivita a4 = new RegistroAttivita(bus1, tratta2, 5);
		RegistroAttivita a5 = new RegistroAttivita(bus1, tratta2, 9);
		RegistroAttivita a6 = new RegistroAttivita(bus1, tratta2, 13);
		// fuori servizio
		RegistroAttivita a7 = new RegistroAttivita(tram3, tratta3, 7);

		registroAttivitaDAO.save(a1);
		registroAttivitaDAO.save(a2);
		registroAttivitaDAO.save(a3);
		registroAttivitaDAO.save(a4);
		registroAttivitaDAO.save(a5);
		registroAttivitaDAO.save(a6);
		registroAttivitaDAO.save(a7);
		// ----------------------------------------
//		List<RegistroAttivita> list = registroAttivitaDAO.calcolaCorseByMezzo("FG567SB", 3);
//		list.forEach(e -> System.out.println(e));

//		tesseraDAO.getAll().forEach(e -> System.out.println(e));
//		tesseraDAO.delete(4);
//		tess3.setCognome("cambiato");
//		tesseraDAO.update(tess3);
//		tesseraDAO.getAll().forEach(e -> System.out.println(e));

//		bigliettoDAO.vidimazione(1, bus3);
//		bigliettoDAO.vidimazione(2, bus1);
//		bigliettoDAO.delete(3);
//		bigliettoDAO.getAll().forEach(e -> System.out.println(e));

		parcoMezziDao.delete("CF654AW");
		parcoMezziDao.getAll().forEach(e -> System.out.println(e));
		parcoMezziDao.getInManu().forEach(e -> System.out.println(e));
		parcoMezziDao.getInServizio().forEach(e -> System.out.println(e));

		trattaDAO.getAll().forEach(e -> System.out.println(e));

	}

}

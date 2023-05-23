package controller;

import java.time.LocalDate;
import java.time.LocalTime;

import Enums.DurataAbbonamento;
import Enums.FunzioneDistributore;
import dao.AbbonametoDAO;
import dao.BigliettoDAO;
import dao.IAbbonamentiDAO;
import dao.IBigliettoDAO;
import dao.IPuntoVenditaDAO;
import dao.ITesseraDAO;
import dao.PuntiVenditaDAO;
import dao.TesseraDAO;
import module.Abbonamento;
import module.Biglietto;
import module.Distributore;
import module.Rivenditore;
import module.Tessera;

public class Main {

	static protected IBigliettoDAO bigliettoDAO = new BigliettoDAO();
	static protected IAbbonamentiDAO abbonamentoDAO = new AbbonametoDAO();
	static protected IPuntoVenditaDAO puntiVenditaDAO = new PuntiVenditaDAO();
	static protected ITesseraDAO tesseraDAO = new TesseraDAO();

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
		bigliettoDAO.convalida(1);
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
		tesseraDAO.rinnovoTessera(3);
//		Abbonamento ab1=new Abbonamento()
	}

}

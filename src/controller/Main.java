package controller;

import Enums.FunzioneDistributore;
import dao.AbbonametoDAO;
import dao.BigliettoDAO;
import dao.IAbbonamentiDAO;
import dao.IBigliettoDAO;
import dao.IPuntoVenditaDAO;
import dao.PuntiVenditaDAO;
import module.Biglietto;
import module.Distributore;
import module.PuntiVendita;

public class Main {

	static protected IBigliettoDAO bigliettoDAO = new BigliettoDAO();
	static protected IAbbonamentiDAO abbonamentoDAO = new AbbonametoDAO();
	static protected IPuntoVenditaDAO puntiVenditaDAO = new PuntiVenditaDAO();

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
		PuntiVendita d1 = new Distributore("Napoli", FunzioneDistributore.IN_SERVIZIO);
		Distributore d2 = new Distributore("Roma", FunzioneDistributore.FUORI_SERVIZIO);
		Distributore d3 = new Distributore("Torino", FunzioneDistributore.FUORI_SERVIZIO);
		puntiVenditaDAO.save(d1);
		puntiVenditaDAO.save(d2);
		puntiVenditaDAO.save(d3);
		Biglietto b1 = new Biglietto(d1);
		Biglietto b2 = new Biglietto(d2);
		Biglietto b3 = new Biglietto(d3);
		bigliettoDAO.save(b1);
		bigliettoDAO.save(b2);
		bigliettoDAO.save(b3);
//		Abbonamento ab1=new Abbonamento()
	}

}

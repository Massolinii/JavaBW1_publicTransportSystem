package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import Enums.DurataAbbonamento;
import dao.AbbonametoDAO;
import dao.BigliettoDAO;
import dao.IAbbonamentiDAO;
import dao.IBigliettoDAO;
import module.Abbonamento;

public class Main {

	public static void main(String[] args) {

		IBigliettoDAO bigliettoDAO = new BigliettoDAO();
		IAbbonamentiDAO abbonamentoDAO = new AbbonametoDAO();

		Abbonamento a1 = new Abbonamento(DurataAbbonamento.MENSILE);
		a1.setScadenza_abbonameto(LocalDateTime.of(LocalDate.of(2023, 3, 10), LocalTime.now()));
//		Biglietto b1 = new Biglietto();
//		System.out.println(b1.toString()); 
		try {
			/*
			 * BIGLIETTI bigliettoDAO.save(b1); bigliettoDAO.convalida(1);
			 * bigliettoDAO.convalida(1); bigliettoDAO.convalida(2);
			 */

//			ABBONAMENTI
			abbonamentoDAO.save(a1);
//			abbonamentoDAO.checkScadenza(1);
			abbonamentoDAO.rinnovo(1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

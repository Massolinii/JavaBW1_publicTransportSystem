package dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import Enums.DurataAbbonamento;
import module.Abbonamento;
import utils.JpaUtil;

public class AbbonametoDAO implements IAbbonamentiDAO {

	@Override
	public void save(Abbonamento a) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			a.setData_emissione(dateGenerator());
//			a.setData_emissione(LocalDateTime.now());
			// switch Mensile Settimanale {false:rinnovo}
			setScadenza(a, false);
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
			System.out.println("Abbonamento aggiunto nel DB!");
			System.out.println(a);
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'aggiunta del Abbonamento nel DB." + e);
		} finally {
			em.close();
		}

	}

	@Override
	public void rinnovo(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.getTransaction().begin();
			Abbonamento a = em.find(Abbonamento.class, id);
			if (!checkScadenza(id)) {
				// true:rinnovo date start now
				System.out.println("Abbonamento Rinnovato");
				setScadenza(a, true);
				System.out.println(a);
			} else {
				System.out.println("Impossibile rinnovare!");
			}

		} catch (Exception e) {
			System.out.println("Errore :  " + e);
		} finally {
			em.close();
		}

	}

	@Override
	public Boolean checkScadenza(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.getTransaction().begin();
			Abbonamento a = em.find(Abbonamento.class, id);
			if (a != null) {
				// compare le 2 date se la prima e minore return -> -1
				if (a.getScadenza_abbonameto().compareTo(LocalDateTime.now()) > 0) {

					// setScadenza(a);
					System.out.println("Abbonamento ancora valido fino a "
							+ a.getScadenza_abbonameto().format(DateTimeFormatter.ISO_DATE));
					return true;
				} else {
					System.out.println("Abbonamento SCADUTO!! ");
					return false;
				}
			} else {
				System.out.println("Biglietto " + id + " non esiste.");
			}
		} catch (Exception e) {
			System.out.println("Errore :  " + e);
		} finally {
			em.close();
		}
		return null;
	}

	public LocalDateTime dateGenerator() throws Exception {
		Random ry = new Random();
		Random rm = new Random();
		Random rd = new Random();
		int year = 1969 + ry.nextInt(2015 - 1969 + 1);
		int month = 1 + rm.nextInt(12);
		int day = 1 + rd.nextInt(31);
		if (month == 2 && day > 28) {
			day = day - 3;
		} else {
			if ((month % 2 == 0 && month != 8) && day == 31) {
				day = day - 1;
			}
		}

		return LocalDateTime.of(year, month, day, 0, 0);
	}

	public void setScadenza(Abbonamento a, Boolean rinnovo) {
		if (a.getDurata() == DurataAbbonamento.MENSILE) {
			a.setScadenza_abbonameto(rinnovo ? LocalDateTime.now().plusDays(30) : a.getData_emissione().plusDays(30));
		} else {
			a.setScadenza_abbonameto(rinnovo ? LocalDateTime.now().plusDays(7) : a.getData_emissione().plusDays(7));
		}
	}

	@Override
	public void delete(Abbonamento a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Abbonamento a) {
		// TODO Auto-generated method stub

	}

	@Override
	public Abbonamento getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Abbonamento> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

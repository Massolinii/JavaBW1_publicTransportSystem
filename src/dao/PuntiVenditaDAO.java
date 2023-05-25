package dao;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Enums.FunzioneDistributore;
import module.Biglietto;
import module.Distributore;
import module.PuntiVendita;
import module.Rivenditore;
import utils.JpaUtil;

public class PuntiVenditaDAO implements IPuntoVenditaDAO {
	IBigliettoDAO bigliettoDAO = new BigliettoDAO();
	Scanner sc = new Scanner(System.in);

	@Override
	public void save(PuntiVendita pv) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(pv);
			em.getTransaction().commit();
			System.out.println("Punto vendita aggiunto nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'aggiunta del punto vendita nel DB." + e);
		} finally {
			em.close();
		}

	}

	@Override
	public void updateStatus(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Distributore pv = em.find(Distributore.class, id);
			FunzioneDistributore funzione = pv.getFunzione();
			if (funzione == FunzioneDistributore.FUORI_SERVIZIO) {
				pv.setFunzione(FunzioneDistributore.IN_SERVIZIO);
			} else {
				pv.setFunzione(FunzioneDistributore.FUORI_SERVIZIO);
			}
			em.merge(pv);
			em.getTransaction().commit();
			System.out.println("Punto vendita " + pv.getPunto_vendita_id() + " è " + pv.getFunzione());
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore durante il cambiodi stato del Punto vendita nel DB." + id + " " + e);
		} finally {
			em.close();
		}

	}

	@Override
	public PuntiVendita getById(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			PuntiVendita pv = em.find(PuntiVendita.class, id);
			em.getTransaction().commit();
			return pv;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'aggiunta del Distributore nel DB." + e);
		} finally {
			em.close();
		}
		return null;

	}

	@Override
	public void delete(PuntiVendita pv) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(PuntiVendita pv) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public List<PuntiVendita> getAllPuntiVendita() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		List<PuntiVendita> listaPuntiVendita = null;
		try {

			em.getTransaction().begin();
			Query query = em.createQuery("SELECT p FROM PuntiVendita p");
			listaPuntiVendita = query.getResultList();
			if (listaPuntiVendita != null) {
				int i = 1;
				System.out.println("Lista punti vendita:");
				for (PuntiVendita pv : listaPuntiVendita) {
					System.out.println(i + "." + pv.toString());
					i++;
				}
			} else {
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'ottenimento dei punti vendita!" + e);
		} finally {
			em.close();
		}
		return listaPuntiVendita;
	}

	public void acquistaBiglietto() {
		List<PuntiVendita> listaPuntiVendita = this.getAllPuntiVendita();
		Boolean condition = true;
		do {
			if (listaPuntiVendita != null) {
				int scelta = sc.nextInt();
				PuntiVendita puntoVenditaSelezionato = listaPuntiVendita.get(scelta - 1);
				if (scelta == 0) {
					condition = false;
				}
				if (puntoVenditaSelezionato instanceof Distributore) {
					Distributore distributoreSelezionato = (Distributore) puntoVenditaSelezionato;

					if (distributoreSelezionato.getFunzione() == FunzioneDistributore.IN_SERVIZIO) {
						// acquisto biglietto->emissione->save on DB
						Biglietto newBiglietto = new Biglietto(puntoVenditaSelezionato);
						bigliettoDAO.save(newBiglietto);
						System.out.println("Ecco il numero del tuo biglietto" + newBiglietto.getBiglietto_id());

					} else {
						System.out.println("Distributore fuori servizio. Scegli un altro distributore!");

					}
				} else {
					Rivenditore rivenditoreSelezionato = (Rivenditore) puntoVenditaSelezionato;
					LocalTime orarioAttuale = LocalTime.now();
					if (orarioAttuale.isBefore(rivenditoreSelezionato.getOrario_apertura())
							|| orarioAttuale.isAfter(rivenditoreSelezionato.getOrario_chiusura())) {
						System.out.println("Questo rivenditore è attualmente chiuso!");
					} else {
						System.out.println("Hai comprato il biglietto!");
					}
				}
			} else {
				System.out.println("Non ci sono punti vendita disponibili!");
			}
		} while (condition);

		sc.close();
	}

	public void selezionaPuntoVendita() {
		Scanner sc = new Scanner(System.in);
		List<PuntiVendita> list = getAllPuntiVendita();

		System.out.println("\nScegli un punto vendita:");
		boolean condition = true;
		do {
			if (list == null) {
				System.err.println("error:lista vuota");
			} else {
				int scelta = sc.nextInt();
				PuntiVendita puntoVenditaSelezionato = list.get(scelta - 1);

				if (puntoVenditaSelezionato instanceof Distributore) {

					Distributore distributoreSelezionato = (Distributore) puntoVenditaSelezionato;
					if (distributoreSelezionato.getFunzione() == FunzioneDistributore.IN_SERVIZIO) {
						// acquisto biglietto->emissione->save on DB
						sceltaProdotto(puntoVenditaSelezionato);
						Biglietto newBiglietto = new Biglietto(puntoVenditaSelezionato);
						bigliettoDAO.save(newBiglietto);
						System.out.println("Ecco il numero del tuo biglietto" + newBiglietto.getBiglietto_id());

					} else {
						System.out.println("Distributore fuori servizio. Scegli un altro distributore!");

					}
				} else {
					Rivenditore rivenditoreSelezionato = (Rivenditore) puntoVenditaSelezionato;
					// CHIUSO
					if (LocalTime.now().isBefore(rivenditoreSelezionato.getOrario_apertura())
							|| LocalTime.now().isAfter(rivenditoreSelezionato.getOrario_chiusura())) {
						System.out.println("Questo rivenditore è attualmente chiuso!");
					} else {
						// APERTO
						System.out.println("Hai comprato il biglietto!");
					}
				}

			}

		} while (condition);
	}

	public void sceltaProdotto(PuntiVendita puntoVenditaSelezionato) {

		Boolean condition = true;
		do {
			String scelta2 = sc.nextLine();
			System.out.println("scrivi la tua scelta:\nback\nbiglietto\nrinnovo");
			switch (scelta2.toLowerCase()) {
			case "back":
				condition = false;
				break;
			case "biglietto":
				Biglietto newBiglietto = new Biglietto(puntoVenditaSelezionato);
				bigliettoDAO.save(newBiglietto);
				System.out.println("Ecco il numero del tuo biglietto" + newBiglietto.getBiglietto_id());
				condition = false;
				break;
			case "rinnovo":
				condition = false;
				break;

			default:
				break;
			}
		} while (condition);
	}
}

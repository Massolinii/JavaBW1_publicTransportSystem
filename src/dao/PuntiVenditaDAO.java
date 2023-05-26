package dao;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Enums.DurataAbbonamento;
import Enums.FunzioneDistributore;
import module.Abbonamento;
import module.Biglietto;
import module.Distributore;
import module.PuntiVendita;
import module.Rivenditore;
import module.Tessera;
import utils.JpaUtil;

public class PuntiVenditaDAO implements IPuntoVenditaDAO {
	IBigliettoDAO bigliettoDAO = new BigliettoDAO();
	ITesseraDAO tesseraDAO = new TesseraDAO();
	IAbbonamentiDAO abbonamentoDAO = new AbbonametoDAO();
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

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'ottenimento dei punti vendita!" + e);
		} finally {
			em.close();
		}
		return listaPuntiVendita;
	}

	public void puntiVenditaIntefaccia() {

		Scanner scanner = new Scanner(System.in);

		// Inizializza i punti vendita

		// Variabili per le scelte dell'utente
		int sceltaPuntoVendita = 0;
		int sceltaOperazione = 0;
		int sceltaDurataAbbonamento = 0;

		boolean continua = true;
		while (continua) {
			// Mostra l'elenco dei punti vendita
			System.out.println("Scegli un punto vendita:");
			for (int i = 0; i < getAllPuntiVendita().size(); i++) {
				System.out.println((i + 1) + ". " + getAllPuntiVendita().get(i));
			}

			// Leggi la scelta dell'utente
			sceltaPuntoVendita = scanner.nextInt();

			// Verifica se la scelta è valida
			if (sceltaPuntoVendita < 1 || sceltaPuntoVendita > getAllPuntiVendita().size()) {

				System.out.println("Scelta non valida. Riprova.");
				continue; // Torna all'inizio del ciclo
			}
			PuntiVendita puntoVenditaSelezionato = getAllPuntiVendita().get(sceltaPuntoVendita - 1);
			if (puntoVenditaSelezionato instanceof Distributore) {
				Distributore distributoreSelezionato = (Distributore) puntoVenditaSelezionato;

				if (distributoreSelezionato.getFunzione() == FunzioneDistributore.IN_SERVIZIO) {
					System.out.println("Distributore selezionato in servizio");
				} else {
					System.out.println("Distributore selezionato è fuori servizio");
					continue;
				}
			} else {
				Rivenditore rivenditoreSelezionato = (Rivenditore) puntoVenditaSelezionato;
				LocalTime orarioAttuale = LocalTime.now();
				if (orarioAttuale.isBefore(rivenditoreSelezionato.getOrario_apertura())
						|| orarioAttuale.isAfter(rivenditoreSelezionato.getOrario_chiusura())) {
					System.out.println("Questo Rivenditore è attualmente chiuso!");
					continue;
				} else {
					System.out.println("Rivenditore selezionato è fuori servizio");
				}
			}
			// Ottieni il punto vendita selezionato
			PuntiVendita puntoVenditaScelto = getAllPuntiVendita().get(sceltaPuntoVendita - 1);
			System.out.println("\nHai scelto: " + puntoVenditaScelto);

			// Chiedi se l'utente vuole comprare un biglietto o rinnovare un abbonamento
			boolean continuaOperazione = true;
			while (continuaOperazione) {
				System.out.println("Cosa desideri fare?");
				System.out.println("1. Comprare un biglietto");
				System.out.println("2. Rinnovare un abbonamento");
				System.out.println("3. Cambia punto vendita");
				sceltaOperazione = scanner.nextInt();

				switch (sceltaOperazione) {
				case 1:
					System.out.println("Hai scelto di comprare un biglietto.");
					// biglietto dao acquisto
					Biglietto newB = new Biglietto(puntoVenditaScelto);
					bigliettoDAO.save(newB);
					System.out.println("Ecco a te il biglietto" + newB);
					continuaOperazione = false;
					break;

				case 2:
					System.out.println("Hai scelto di rinnovare un abbonamento.");
					// Chiedi il numero della tessera
					System.out.println("Inserisci il numero della tua tessera:");
					int numeroTessera = scanner.nextInt();
					boolean validita = tesseraDAO.rinnovoTessera(numeroTessera);

					// Chiedi se l'utente desidera un abbonamento mensile o settimanale
					if (validita) {
						Tessera t = tesseraDAO.getById(numeroTessera);
						Abbonamento abbTessera = t.getAbbonamento();
						abbonamentoDAO.checkScadenza(abbTessera.getBiglietto_id());
						boolean continuaDurataAbbonamento = true;
						while (continuaDurataAbbonamento) {
							System.out.println("Scegli la durata dell'abbonamento:");
							System.out.println("1. Mensile");
							System.out.println("2. Settimanale");
							System.out.println("3. Cambia operazione");
							sceltaDurataAbbonamento = scanner.nextInt();

							switch (sceltaDurataAbbonamento) {
							case 1:
								System.out.println("Hai scelto un abbonamento mensile.");

								Abbonamento abbMensile = new Abbonamento(puntoVenditaScelto, DurataAbbonamento.MENSILE);
								abbonamentoDAO.save(abbMensile);
								tesseraDAO.updateAbb(numeroTessera, abbMensile);
								System.out.println(tesseraDAO.getById(numeroTessera));
								continuaDurataAbbonamento = false;
								break;

							case 2:
								System.out.println("Hai scelto un abbonamento settimanale.");
								Abbonamento abbSettimanale = new Abbonamento(puntoVenditaScelto,
										DurataAbbonamento.SETTIMANALE);
								abbonamentoDAO.save(abbSettimanale);
								tesseraDAO.updateAbb(numeroTessera, abbSettimanale);
								System.out.println(tesseraDAO.getById(numeroTessera));
								continuaDurataAbbonamento = false;
								break;

							case 3:
								continuaOperazione = false;
								continuaDurataAbbonamento = false;
								break;

							default:
								System.out.println("Scelta non valida. Riprova.");
								break;
							}
						}
					} else {
						System.out.println("non puoi effetuare operazioni con la tessera scaduta!!");
					}

				case 3:
					continuaOperazione = false;
					break;

				default:
					System.out.println("Scelta non valida. Riprova.");
					break;
				}
			}

			// Chiedi all'utente se desidera continuare
			System.out.println("_________________________________________________");
			System.out.println("\nDesideri effettuare un'altra operazione? (Sì/No)");
			String risposta = scanner.next();
			if (risposta.equalsIgnoreCase("No")) {
				continua = false;
			}
		}

		scanner.close();
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

	public void printPuntiVendita(List<PuntiVendita> puntiVendita) {
		System.out.println("Lista punti vendita:");
		int i = 1;
		for (PuntiVendita pv : puntiVendita) {
			System.out.println(i + "." + pv.toString());
			i++;
		}
		System.out.println("Scegli un punto vendita:");

	}
}

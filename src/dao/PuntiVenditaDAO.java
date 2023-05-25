package dao;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Enums.FunzioneDistributore;
import module.Distributore;
import module.PuntiVendita;
import module.Rivenditore;
import utils.JpaUtil;

public class PuntiVenditaDAO implements IPuntoVenditaDAO {

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
                for (PuntiVendita pv : listaPuntiVendita ) {
                    System.out.println(i+ "." + pv.toString());
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
        Scanner sc = new Scanner (System.in);
        List<PuntiVendita> listaPuntiVendita = this.getAllPuntiVendita();
        if (listaPuntiVendita != null) {
            int i = 1;
            System.out.println("Scegli un punto vendita dove acquistare un biglietto!");
            for (PuntiVendita pv : listaPuntiVendita ) {
                System.out.println(i+ "." + pv.toString());
                i++;
            }
            int scelta = sc.nextInt();
            PuntiVendita puntoVenditaSelezionato = listaPuntiVendita.get(scelta -1);
            if (puntoVenditaSelezionato instanceof Distributore) {
                Distributore distributoreSelezionato = (Distributore) puntoVenditaSelezionato;
                if (distributoreSelezionato.getFunzione() == FunzioneDistributore.IN_SERVIZIO) {
                    System.out.println("Hai comprato il biglietto!");
                } else  { 
                    System.out.println("Distributore fuori servizio. Scegli un altro distributore!");
                }
            } else {
                Rivenditore rivenditoreSelezionato = (Rivenditore) puntoVenditaSelezionato;
                LocalTime orarioAttuale = LocalTime.now();
                if (orarioAttuale.isBefore(rivenditoreSelezionato.getOrario_apertura()) || orarioAttuale.isAfter(rivenditoreSelezionato.getOrario_chiusura())) {
                    System.out.println("Questo rivenditore è attualmente chiuso!");
                } else  { 
                    System.out.println("Hai comprato il biglietto!");
                }
            }
        } else {
            System.out.println("Non ci sono punti vendita disponibili!");
        }
        sc.close();
    }

}

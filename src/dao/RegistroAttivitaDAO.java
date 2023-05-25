package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Enums.StatusMezzo;
import module.Parco_Mezzi;
import module.RegistroAttivita;
import module.Tratta;
import utils.JpaUtil;

public class RegistroAttivitaDAO implements IRegistroAttivitaDAO {

	@Override
	// integer min è il tempo di percorrenza della lunghezza della tratta.
	public void save(RegistroAttivita attivita) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			if (attivita.getMezzo().getStatus() == StatusMezzo.IN_SERVIZIO) {
				em.getTransaction().begin();
				em.persist(attivita);
				em.getTransaction().commit();
				System.out.println("attivita salvata!");
			} else {
				System.out.println(
						"il mezzo: [" + attivita.getMezzo().getTarga() + "] fuori servizio o in manutenzione!");
			}
		} catch (Exception e) {
			System.out.println("Errore :  " + e);
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Integer id) {

	}

	@Override
	public List<RegistroAttivita> calcolaCorseByMezzo(String targaMezzo, Integer idTratta) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<RegistroAttivita> q = em.createNamedQuery("registroAttivita.corsePerMezzoSuTratta",
					RegistroAttivita.class);
			q.setParameter("targaMezzo", targaMezzo);
			q.setParameter("idTratta", idTratta);
			List<RegistroAttivita> list = q.getResultList();
			System.out.println(
					"Il mezzo con id: " + targaMezzo + " ha percorso " + list.size() + " volte la tratta " + idTratta);
			return q.getResultList();
		} catch (Exception e) {
			System.out.println("Errore :  " + e);
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void calcolaTemEffetivo(Parco_Mezzi mezzo, Tratta tratta) {

	}

	@Override
	public void delete(RegistroAttivita attivita) {
		// TODO Auto-generated method stub

	}

	@Override
	public RegistroAttivita getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegistroAttivita> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

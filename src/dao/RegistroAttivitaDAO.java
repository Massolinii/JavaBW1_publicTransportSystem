package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import module.Parco_Mezzi;
import module.RegistroAttivita;
import module.Tratta;
import utils.JpaUtil;

public class RegistroAttivitaDAO implements IRegistroAttivitaDAO {

	@Override
	public void save(RegistroAttivita attivita, Integer min) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			attivita.setTempoEffettivo(min);
			em.persist(attivita);
			em.getTransaction().commit();
			System.out.println("attivita salvata!");
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

}

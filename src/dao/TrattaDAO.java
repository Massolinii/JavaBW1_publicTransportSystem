package dao;

import java.util.List;

import javax.persistence.EntityManager;

import module.Tratta;
import utils.JpaUtil;

public class TrattaDAO implements ITrattaDAO {

	@Override
	public void save(Tratta t) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			System.out.println("Tratta aggiunto nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'aggiunta del Tratta nel DB." + e);
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Tratta t = em.find(Tratta.class, id);
			if (t != null) {

				em.merge(t);
				em.getTransaction().commit();
				System.out.println("Tratta " + id + " modificata!");

			} else {
				System.out.println("La tratta " + id + " non esiste.");
			}
		} catch (Exception e) {
			System.out.println("Errore :  " + e);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Tratta> getAllTratte() {

		return null;
	}

}

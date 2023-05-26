package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	public List<Tratta> getAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Query q = em.createNamedQuery("tratta.getAll");
			List<Tratta> list = q.getResultList();
			return list;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nella lettura del DB." + e);
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Tratta t = em.find(Tratta.class, id);
			if (t != null) {

				em.remove(t);
				em.getTransaction().commit();
				System.out.println("Tratta [" + id + "] eliminata dal DB!");

			} else {
				System.out.println("La tratta [" + id + "] non esiste.");
			}
		} catch (Exception e) {

			System.out.println("Errore :  " + e);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Tratta t) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
			System.out.println("Tratta modificata nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nella modifica del Tratta nel DB." + e);
		} finally {
			em.close();
		}
	}

	@Override
	public Tratta getById(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Tratta t = em.find(Tratta.class, id);
			em.getTransaction().commit();
			System.out.println("Tratta [" + id + "] trvata dal DB!");
			return t;
		} catch (Exception e) {
			System.out.println("Errore :  " + e);
		} finally {
			em.close();
		}
		return null;
	}

}

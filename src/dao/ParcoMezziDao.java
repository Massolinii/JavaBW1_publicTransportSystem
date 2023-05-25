package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Enums.StatusMezzo;
import module.Parco_Mezzi;
import utils.JpaUtil;

public class ParcoMezziDao implements IParcoMezziDao {
	@Override
	public void save(Parco_Mezzi mezzo) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(mezzo);
			em.getTransaction().commit();
			System.out.println("Mezzo aggiunto nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'aggiunta del mezzo nel DB." + e);
		} finally {
			em.close();
		}

	}

	@Override
	public void delete(String id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Parco_Mezzi mezzo = em.find(Parco_Mezzi.class, id);
			em.remove(mezzo);
			em.getTransaction().commit();
			System.out.println("Mezzo[" + id + "] Eliminato dal DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nel rimuovere il mezzo nel DB." + e);
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Parco_Mezzi mezzo) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(mezzo);
			em.getTransaction().commit();
			System.out.println("Mezzo[" + mezzo.getTarga() + "] modificato nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nella modifica del mezzo nel DB." + e);
		} finally {
			em.close();
		}

	}

	@Override
	public Parco_Mezzi getById(String id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Parco_Mezzi mezzo = em.find(Parco_Mezzi.class, id);
			System.out.println("Mezzo[" + mezzo.getTarga() + "] trovato dal DB!");
			return mezzo;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'aggiunta del mezzo nel DB." + e);
		} finally {
			em.close();
		}

		return null;
	}

	@Override
	public List<Parco_Mezzi> getAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Query q = em.createNamedQuery("mezzi.getAll");
			List<Parco_Mezzi> list = q.getResultList();
			return list;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore in lettura dal DB." + e);
		} finally {
			em.close();
		}

		return null;
	}

	@Override
	public List<Parco_Mezzi> getInManu() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Query q = em.createNamedQuery("mezzi.getInManutenzione");
			List<Parco_Mezzi> list = q.getResultList();
			return list;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore in lettura dal DB." + e);
		} finally {
			em.close();
		}

		return null;
	}

	@Override
	public List<Parco_Mezzi> getInServizio() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Query q = em.createNamedQuery("mezzi.getInServizio");
			List<Parco_Mezzi> list = q.getResultList();
			return list;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore in lettura dal DB." + e);
		} finally {
			em.close();
		}

		return null;
	}

	@Override
	public void updateStatusMezzi(StatusMezzo stm, Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Parco_Mezzi mezzo = em.find(Parco_Mezzi.class, id);
			if (mezzo != null) {

				mezzo.setStatus(stm);
				em.merge(mezzo);
				em.getTransaction().commit();
				System.out.println("Il mezzo" + id + " ha status= " + stm.toString());

			} else {
				System.out.println("Il mezzo con " + id + " non esiste.");
			}
		} catch (Exception e) {
			System.out.println("Errore :  " + e);
		} finally {
			em.close();
		}

	}

}

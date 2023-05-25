package dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Enums.StatusMezzo;
import module.Biglietto;
import module.Parco_Mezzi;
import utils.JpaUtil;

public class BigliettoDAO implements IBigliettoDAO {

	public void save(Biglietto bi) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(bi);
			em.getTransaction().commit();
			System.out.println("Biglietto aggiunto nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'aggiunta del biglietto nel DB." + e);
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Biglietto b = em.find(Biglietto.class, id);
			em.remove(b);
			em.getTransaction().commit();
			System.out.println("Biglietto[" + id + "] rimosso nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nel rimovere il biglietto nel DB." + e);
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Biglietto bi) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(bi);
			em.getTransaction().commit();
			System.out.println("Biglietto[" + bi.getBiglietto_id() + "] rimosso nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nel modificare il biglietto nel DB." + e);
		} finally {
			em.close();
		}
	}

	@Override
	public Biglietto getById(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Biglietto b = em.find(Biglietto.class, id);
			em.getTransaction().commit();
			System.out.println("Biglietto[" + b.getBiglietto_id() + "] trovato nel DB!");
			return b;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nel modificare il biglietto nel DB." + e);
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public List<Biglietto> getAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Query q = em.createNamedQuery("biglietto.getAll");
			List<Biglietto> list = q.getResultList();
			return list;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nella modifica del Tessera nel DB." + e);
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void vidimazione(Integer id, Parco_Mezzi mezzo) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Biglietto bi = em.find(Biglietto.class, id);
			if (mezzo.getStatus() == StatusMezzo.IN_SERVIZIO) {
				if (bi != null) {
					if (bi.getValido()) {
						bi.setValido(false);
						bi.setOrario_validazione(LocalDateTime.now());
						bi.setMezzo(mezzo);
						mezzo.setCountPassanger(mezzo.getCountPassanger() + 1);
						em.merge(mezzo);
						em.merge(bi);
						em.getTransaction().commit();
						bi.setOrario_validazione(LocalDateTime.now());
						System.out.println("Biglietto " + id + " convalidato!");
					} else {
						System.out.println("Biglietto già convalidato.");
					}
				} else {
					System.out.println("Biglietto " + id + " non esiste.");
				}
			} else {

				System.out.println("mezzo fuori servizio");
			}

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore :  " + e);
		} finally {
			em.close();
		}
	}

}

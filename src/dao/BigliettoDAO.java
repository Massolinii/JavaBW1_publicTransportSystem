package dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import module.Biglietto;
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
	public void convalida(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Biglietto bi = em.find(Biglietto.class, id);
			if (bi != null) {
				if (bi.getValido()) {
					bi.setValido(false);
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
		} catch (Exception e) {
			System.out.println("Errore :  " + e);
		} finally {
			em.close();
		}
	}

}

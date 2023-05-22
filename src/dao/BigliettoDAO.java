package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import module.Biglietto;
import utils.JpaUtil;

public class BigliettoDAO implements IBigliettoDAO {

	public void save(Biglietto bi) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(bi);
			em.getTransaction().commit();
			System.out.println("Successfully added into the DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("There was an error saving this Element." + e);
		} finally {
			em.close();
		}
	}

	@Override
	public void convalida(Biglietto e) {
		// TODO Auto-generated method stub
		
	}

}

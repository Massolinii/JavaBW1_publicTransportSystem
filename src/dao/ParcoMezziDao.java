package dao;

import java.util.List;

import javax.persistence.EntityManager;

import Enums.StatusMezzo;
import module.Parco_Mezzi;
import utils.JpaUtil;

public class ParcoMezziDao implements IParcoMezziDao {

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
	public void delete(Parco_Mezzi mezzo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Parco_Mezzi mezzo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Parco_Mezzi getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parco_Mezzi> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

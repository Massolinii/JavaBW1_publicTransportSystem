package dao;

import java.util.List;

import javax.persistence.EntityManager;

import Enums.FunzioneDistributore;
import module.Distributore;
import module.Parco_Mezzi;
import module.PuntiVendita;
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

	@Override
	public List<Parco_Mezzi> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

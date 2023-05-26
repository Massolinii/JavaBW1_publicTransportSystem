package dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

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
//			System.out.println("Biglietto aggiunto nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'aggiunta del biglietto nel DB." + e);
		} finally {
			em.close();
		}
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

	@Override
	public void delete(Biglietto bi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Biglietto bi) {
		// TODO Auto-generated method stub

	}

	@Override
	public Biglietto getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Biglietto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

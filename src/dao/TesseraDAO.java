package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import module.Abbonamento;
import module.Tessera;
import utils.JpaUtil;

public class TesseraDAO implements ITesseraDAO {
	IAbbonamentiDAO abbDAO = new AbbonametoDAO();

	@Override
	public void save(Tessera t) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			System.out.println("Tessera aggiunto nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'aggiunta del Tessera nel DB." + e);
		} finally {
			em.close();
		}

	}

	@Override
	public void updateAbb(Integer id, Abbonamento abb) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Tessera t = em.find(Tessera.class, id);
			t.setAbbonamento(abb);
			em.merge(t);
			em.getTransaction().commit();
			System.out.println("\nTessera aggiornata con il nuovo abbonamento nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'update dell'abbonamento del Tessera nel DB." + e);
		} finally {
			em.close();
		}

	}

	@Override
	public void checkAbb(Integer id_tessera) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Abbonamento abb = em.find(Tessera.class, id_tessera).getAbbonamento();
			System.out.println(abb);
			if (abb != null) {
				abbDAO.checkScadenza(abb.getBiglietto_id());

			} else {
				System.out.println("non è presente alcun abbonamento colleato alla tessera n: " + id_tessera);
			}

			em.getTransaction().commit();
			System.out.println("Tessera aggiunto nel DB!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore nell'aggiunta del Tessera nel DB." + e);
		} finally {
			em.close();
		}

	}

	@Override
	public boolean rinnovoTessera(Integer id) {
		boolean validita = false;
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {

			em.getTransaction().begin();
			Tessera t = em.find(Tessera.class, id);
			if (t != null) {
				// compare le 2 date se la prima e minore return -> -1
				if (t.getData_scadenza().compareTo(LocalDate.now()) > 0) {
					System.out.println("Tessera valida ancora fino a " + t.getData_scadenza());
					validita = true;
				} else {
					System.out.println("Tessera scaduta!!");
					System.out.println("vuoi rinnovare la tessera " + id);
					System.out.println("1-Rinnova tessera\n2-Annulla operazione.");
					Scanner sc = new Scanner(System.in);
					int sceltaTipo;
					do {
						sceltaTipo = sc.nextInt();
						sc.nextLine();
						if (sceltaTipo < 1 || sceltaTipo > 2) {
							System.out.println("Inserisci un'opzione valida!");
						}
					} while (sceltaTipo < 1 || sceltaTipo > 2);

					switch (sceltaTipo) {
					case 1:
						t.setData_scadenza(LocalDate.now().plusYears(1));
						em.merge(t);
						em.getTransaction().commit();
						System.out.println("Tessera id: " + id + " rinnovata");
						validita = true;
						break;
					case 2:
						System.out.println("Operazione annullata");
						break;

					default:
						break;
					}

				}
			}
		} catch (Exception e) {
			System.out.println("Errore :  " + e);
		} finally {
			em.close();
		}
		return validita;
	}

	@Override
	public Tessera getById(Integer id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Tessera t = em.find(Tessera.class, id);
			em.getTransaction().commit();
			return t;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore  Tessera  non presente nel DB." + e);
		} finally {
			em.close();
		}

		return null;
	}

	@Override
	public List<Tessera> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Tessera t) {
		// TODO Auto-generated method stub

	}

}

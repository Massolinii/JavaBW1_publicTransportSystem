package dao;

import module.Abbonamento;
import module.Tessera;

public interface ITesseraDAO {
	public void save(Tessera t);

	public void updateAbb(Integer id, Abbonamento abb);

	public void checkAbb(Integer id);

	public void checkTessera(Integer id);

	public void rinnovoTessera(Integer id);
}

package dao;

import java.util.List;

import module.Abbonamento;
import module.Tessera;

public interface ITesseraDAO {
	// Metodi Crud
	public void save(Tessera t);

	public void delete(Tessera t);

	public void update(Integer id);

	public Tessera getById(Integer id);

	public List<Tessera> getAll();

	public void updateAbb(Integer id, Abbonamento abb);

	public void checkAbb(Integer id);

	public boolean rinnovoTessera(Integer id);
}

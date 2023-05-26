package dao;

import java.util.List;

import module.Abbonamento;
import module.Tessera;

public interface ITesseraDAO {
	// Metodi Crud
	public void save(Tessera t);

	public void delete(Integer id);

	public void update(Tessera t);

	public Tessera getById(Integer id);

	public List<Tessera> getAll();

	// Metodi
	public void updateAbb(Integer id, Abbonamento abb);

	public void checkAbb(Integer id);

	public boolean rinnovoTessera(Integer id);
}

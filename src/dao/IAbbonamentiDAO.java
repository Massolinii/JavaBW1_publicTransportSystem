package dao;

import java.util.List;

import module.Abbonamento;

public interface IAbbonamentiDAO {
	// Metodi Crud
	public void save(Abbonamento a);

	public void delete(Integer id);

	public void update(Abbonamento a);

	public Abbonamento getById(Integer id);

	public List<Abbonamento> getAll();

	// Altri Metodi
	public void rinnovo(Integer id);

	public Boolean checkScadenza(Integer id);

}

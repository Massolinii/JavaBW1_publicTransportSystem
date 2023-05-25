package dao;

import java.util.List;

import module.Tratta;

public interface ITrattaDAO {
	// Metodi Crud
	public void save(Tratta t);

	public void delete(Integer id);

	public void update(Tratta t);

	public Tratta getById(Integer id);

	public List<Tratta> getAll();

}

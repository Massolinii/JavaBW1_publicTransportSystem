package dao;

import java.util.List;

import module.Tratta;

public interface ITrattaDAO {
	public void save(Tratta t);

	public void update(Integer id);

	public List<Tratta> getAllTratte();
}

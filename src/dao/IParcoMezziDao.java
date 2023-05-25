package dao;

import java.util.List;

import Enums.StatusMezzo;
import module.Parco_Mezzi;

public interface IParcoMezziDao {

// Metodi Crud
	public void save(Parco_Mezzi mezzo);

	public void delete(Parco_Mezzi mezzo);

	public void update(Parco_Mezzi mezzo);

	public Parco_Mezzi getById(Integer id);

	public List<Parco_Mezzi> getAll();

	// Metodo specifico
	public void updateStatusMezzi(StatusMezzo stm, Integer id);
}

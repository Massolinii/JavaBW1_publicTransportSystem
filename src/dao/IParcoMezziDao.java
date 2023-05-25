package dao;

import java.util.List;

import Enums.StatusMezzo;
import module.Parco_Mezzi;

public interface IParcoMezziDao {

// Metodi Crud
	public void save(Parco_Mezzi mezzo);

	public void delete(String id);

	public void update(Parco_Mezzi mezzo);

	public Parco_Mezzi getById(String id);

	public List<Parco_Mezzi> getAll();

	// Metodo specifico
	public void updateStatusMezzi(StatusMezzo stm, Integer id);

	public List<Parco_Mezzi> getInServizio();

	public List<Parco_Mezzi> getInManu();
}

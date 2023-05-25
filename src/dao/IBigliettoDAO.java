package dao;

import java.util.List;

import module.Biglietto;
import module.Parco_Mezzi;

public interface IBigliettoDAO {

	// Metodi Crud
	public void save(Biglietto bi);

	public void delete(Biglietto bi);

	public void update(Biglietto bi);

	public Biglietto getById(Integer id);

	public List<Biglietto> getAll();

//		Altri medodi
	public void vidimazione(Integer id, Parco_Mezzi mezzo);

}

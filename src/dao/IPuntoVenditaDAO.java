package dao;

import java.util.List;

import module.Parco_Mezzi;
import module.PuntiVendita;

public interface IPuntoVenditaDAO {

	// Metodi Crud
	public void save(PuntiVendita pv);

	public void delete(PuntiVendita pv);

	public void update(PuntiVendita pv);

	public PuntiVendita getById(Integer id);

	public List<Parco_Mezzi> getAll();

	// Metodo specifico
	public void updateStatus(Integer id);

}

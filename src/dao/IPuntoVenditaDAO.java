package dao;

import java.util.List;

import module.PuntiVendita;

public interface IPuntoVenditaDAO {

	// Metodi Crud
	public void save(PuntiVendita pv);

	public void delete(PuntiVendita pv);

	public void update(PuntiVendita pv);

	public PuntiVendita getById(Integer id);

	public List<PuntiVendita> getAllPuntiVendita();

	public void acquistaBiglietto();

	// Metodo specifico
	public void updateStatus(Integer id);

	public void puntiVenditaIntefaccia();

}

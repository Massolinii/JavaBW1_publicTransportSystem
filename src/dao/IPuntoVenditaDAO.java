package dao;

import module.PuntiVendita;

public interface IPuntoVenditaDAO {

	public void save(PuntiVendita pv);

	public void updateStatus(Integer id);

	public PuntiVendita getById(Integer id);
}

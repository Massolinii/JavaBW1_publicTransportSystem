package dao;

import module.Abbonamento;

public interface IAbbonamentiDAO {
	public void save(Abbonamento a);

	public void rinnovo(Integer id);

	public Boolean checkScadenza(Integer id);
}

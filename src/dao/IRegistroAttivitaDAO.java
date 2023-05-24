package dao;

import java.util.List;

import module.Parco_Mezzi;
import module.RegistroAttivita;
import module.Tratta;

public interface IRegistroAttivitaDAO {
	public void save(RegistroAttivita attivita, Integer min);

	public void update(Integer id);

	public void calcolaTemEffetivo(Parco_Mezzi mezzo, Tratta tratta);

	public List<RegistroAttivita> calcolaCorseByMezzo(String id_mezzo, Integer id_tratta);

}

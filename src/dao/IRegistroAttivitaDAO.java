package dao;

import java.util.List;

import module.Parco_Mezzi;
import module.RegistroAttivita;
import module.Tratta;

public interface IRegistroAttivitaDAO {

	// Metodi Crud
	public void save(RegistroAttivita attivita);

	public void delete(Integer id);

	public void update(RegistroAttivita attivita);

	public RegistroAttivita getById(Integer id);

	public List<RegistroAttivita> getAll();

	// Metodi specifici
	public void calcolaTemEffetivo(Parco_Mezzi mezzo, Tratta tratta);

	public List<RegistroAttivita> calcolaCorseByMezzo(String id_mezzo, Integer id_tratta);

}

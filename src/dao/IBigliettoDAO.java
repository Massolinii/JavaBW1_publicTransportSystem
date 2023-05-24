package dao;

import module.Biglietto;
import module.Parco_Mezzi;

public interface IBigliettoDAO {

		public void save(Biglietto bi);
		public void convalida(Integer id, Parco_Mezzi mezzo);

}

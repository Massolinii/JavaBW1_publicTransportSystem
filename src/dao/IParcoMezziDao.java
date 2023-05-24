package dao;

import Enums.StatusMezzo;
import module.Parco_Mezzi;

public interface IParcoMezziDao {

	public void updateStatusMezzi(StatusMezzo stm, Integer id);

	public void save(Parco_Mezzi mezzo);
}

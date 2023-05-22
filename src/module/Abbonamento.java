package module;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Enums.DurataAbbonamento;

@Entity
@DiscriminatorValue(value = "abbonamento")
public class Abbonamento extends TitoloDiViaggio {

	@Column (nullable = false)
	protected DurataAbbonamento durata;
}

package clasesDAO;

import clases.Diario;
import clases.Periodico;

public interface PeriodicoDAO {

	void persistir(Periodico viajePeriodico);

	void borrar(Periodico viajePeriodico);

	void actualizar(Periodico viajePeriodico);

}

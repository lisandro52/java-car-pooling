package clasesDAO;

import java.util.List;

import javax.persistence.Query;

import clases.Administrador;
import clases.Evento;
import datos.EMF;

public interface EventoDAO {


	void actualizar(Evento evento);

	void persistir(Evento evento);

	List<Evento> listar(Administrador administrador);

	Integer contar(Administrador administrador);
	


}

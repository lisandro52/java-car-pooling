package clasesDAO;

import java.util.List;

import clases.Usuario;
import clases.Viajero;


public interface ViajeroDAO {

	

	public void persistir(Viajero viajero);

	public void actualizar(Viajero viajero);
	
	List<Usuario> recuperarViajeroConEmail(String email);
	
	Viajero recuperarViajeroConNombre(String nombre);

	public Viajero buscarViajero(String nombre, String password);
	
	
}

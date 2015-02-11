package Claseshiberjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesDAO.ViajeroDAO;
import datos.EMF;
import clases.Administrador;
import clases.Denuncia;
import clases.Usuario;
import clases.Viajero;

public class ViajeroDAOhiberjpa extends GenericDAOhiberjpa<Viajero> implements ViajeroDAO  {

	public ViajeroDAOhiberjpa() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Usuario> recuperarViajeroConEmail(String email) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select a from Usuario a where a.email =?");
		consulta.setParameter(1, email);
		List<Usuario> lista= (List<Usuario>)consulta.getResultList();
		return lista;
	}

	@Override
	public Viajero buscarViajero(String nombre, String password) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select v from Usuario v where v.email =? and v.contrasenia =?");
		consulta.setParameter(1, nombre);
		consulta.setParameter(2, password);
		Viajero resultado = (Viajero)consulta.getSingleResult();
		return resultado;
	}

	@Override
	public Viajero recuperarViajeroConNombre(String nombre) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select a from Viajero a where a.nombre =?");
		consulta.setParameter(1, nombre);
		Viajero resultado = (Viajero)consulta.getSingleResult();
		return resultado;
	}

	
	
}

package Claseshiberjpa;

import java.util.List;

import javax.persistence.Query;

import clases.Usuario;
import clases.Viajero;
import clasesDAO.UsuarioDAO;
import datos.EMF;

public class UsuarioDAOhiberjpa extends GenericDAOhiberjpa<Usuario> implements UsuarioDAO {
	
	
	
	public Usuario buscarUsuario(String email, String password) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select v from Usuario v where v.email =? and v.contrasenia =?");
		consulta.setParameter(1, email);
		consulta.setParameter(2, password);
		List<Usuario> resultado = (List<Usuario>)consulta.getResultList();
		if (resultado.size()==1){
			return resultado.get(0);
			
		}
		else {return null;}
	}



}

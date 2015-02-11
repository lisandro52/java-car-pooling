package Claseshiberjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;



import javax.persistence.Query;

import clases.Administrador;
import clases.Calificacion;
import clasesDAO.AdministradorDAO;
import datos.EMF;

public class AdministradorDAOhiberjpa extends GenericDAOhiberjpa<Administrador> implements AdministradorDAO {

	public Administrador recuperar(String nombre) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select a from Administrador a where a.nombre =?");
		consulta.setParameter(1, nombre);
		Administrador resultado = (Administrador)consulta.getSingleResult();
		return resultado;
		}

	@Override
	public Administrador recuperarId(Long idAdmin) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select a from Administrador a where a.id =?");
		consulta.setParameter(1, idAdmin);
		Administrador resultado = (Administrador)consulta.getSingleResult();
		return resultado;
		
	}
}

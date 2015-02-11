package Claseshiberjpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clases.Administrador;
import clases.Calificacion;
import clases.Denuncia;
import clasesDAO.DenunciaDAO;
import datos.EMF;

public class DenunciaDAOhiberjpa extends GenericDAOhiberjpa<Denuncia> implements DenunciaDAO {
	
	public Denuncia getDenuncia(long id) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select a from Denuncia a where a.id =?");
		consulta.setParameter(1, id);
		Denuncia resultado = (Denuncia)consulta.getSingleResult();
		return resultado;
		}

}

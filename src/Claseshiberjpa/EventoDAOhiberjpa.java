package Claseshiberjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clases.Administrador;
import clases.Denuncia;
import clases.Evento;
import clases.Usuario;
import clasesDAO.EventoDAO;
import datos.EMF;

public class EventoDAOhiberjpa extends GenericDAOhiberjpa<Evento> implements EventoDAO {

	
	

	@Override
	public Integer contar(Administrador admin) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select e from Evento e  where e.administrador =?");
		consulta.setParameter(1, admin);
		List<Evento> lista= (List<Evento>) consulta.getResultList();		
		return lista.size();
	}

	@Override
	public List<Evento> listar(Administrador admin) {
		Query consulta = EMF.getEMF().createEntityManager().createQuery("select e from Evento e  where e.administrador =?");
		consulta.setParameter(1, admin);
		List<Evento> lista= (List<Evento>) consulta.getResultList();
		return lista;
	}

	



	
	
	
	

}

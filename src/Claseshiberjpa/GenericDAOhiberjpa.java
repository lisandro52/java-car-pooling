package Claseshiberjpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesDAO.GenericDAO;
import datos.EMF;

public class GenericDAOhiberjpa<T> 	implements GenericDAO<T> {
	protected Class<T> persistentClass;


	@Override
	public void persistir(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		}
		catch (RuntimeException e) {
			if ( tx != null && tx.isActive() ) tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
			em.close();
		}
	}

	public void actualizar(T entity) {
		EntityManager em= EMF.getEMF().createEntityManager();
		EntityTransaction etx= em.getTransaction();
		etx.begin();
		em.merge(entity);
		etx.commit();
		em.close();
	
	}


	@Override
	public void borrar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(entity);
			tx.commit();
		}
		catch (RuntimeException e) {
			if ( tx != null && tx.isActive() ) tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
			em.close();
		}
	}
	/*public T borrar(Serializable id) {
		T entity = EMF.getEMF().createEntityManager().find(this.getPersistentClass(), id);
		if (entity != null) {
			this.borrar(entity);
		}
		return entity;
	}
	public List<T> listar(String columnOrder) {
		Query consulta= EMF.getEMF().createEntityManager().createQuery("select e from " +
				getPersistentClass().getSimpleName()+ " e order by e.“+columnOrder");
				List<T> resultado = (List<T>)consulta.getResultList();
		return resultado;
	}*/

}

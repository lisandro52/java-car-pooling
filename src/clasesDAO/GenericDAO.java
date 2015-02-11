package clasesDAO;

public interface GenericDAO<T> {

	void borrar(T entity);

	void persistir(T entity);
	
	void actualizar (T entity);

}

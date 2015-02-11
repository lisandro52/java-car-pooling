package clasesDAO;

import clases.Administrador;

public interface AdministradorDAO {

	

	void persistir(Administrador admin);

	public void actualizar(Administrador admin);

	Administrador recuperar(String string);

	Administrador recuperarId(Long idAdmin);

}
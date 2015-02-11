package clasesDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import clases.Administrador;
import clases.Denuncia;
import datos.EMF;

public interface DenunciaDAO {

	
	public Denuncia getDenuncia(long id);

	public void persistir(Denuncia denuncia);
}

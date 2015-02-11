package clasesDAO;

import clases.Usuario;

public interface UsuarioDAO {



	Usuario buscarUsuario(String email, String password);

	

}

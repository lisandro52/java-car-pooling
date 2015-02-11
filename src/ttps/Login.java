package ttps;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import clases.Usuario;
import clases.Viajero;
import clasesDAO.*;


public class Login extends ActionSupport
{
	public String password;
	public String email;
	
	private UsuarioDAO usuarioDAO;
	
	public String execute(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		String user = (String)session.get("user");
		if (user == null){
			Usuario u = usuarioDAO.buscarUsuario(email, password);
		if (u != null){
			session.put("email", u.getEmail());
			session.put("id", u.getId());
			session.put("usrLogin", u);
			if (u.esAdministrador()){
				session.put("tipoUsuario", "administrador");
				return "administrador";
			}
			else{
				session.put("tipoUsuario", "viajero");
				return "usuario";
			}
		} else {
			addFieldError("email", "No existe el usuario");
			return INPUT;
		}
		} else {
		return "conectado";
		}
		}
	
	public void validate(){
		if ((getPassword()==null) || (getPassword().equals("")))
			addFieldError("password", "Se requiere una contraseña de usuario");
		if ((getEmail()==null) || (getEmail().equals("")))
			addFieldError("email","Se requiere un Email");
		}
	
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
		}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	}

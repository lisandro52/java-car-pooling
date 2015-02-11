package ttps;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import com.mysql.jdbc.Blob;
import com.opensymphony.xwork2.ActionSupport;

import clases.Usuario;
import clases.Viajero;
import clasesDAO.*;


public class Registro extends ActionSupport
{
	public String password;
	public String password2;
	public String nombre;
	public String apellido;
	public String telefono;
	public String email;
	public File foto;
	
	public String execute() throws Exception{
		if(this.getPassword().equals(this.getPassword2()) ){
			ViajeroDAO vDAO = FactoryDAO.getViajeroDAO();
			List<Usuario> viajeros = vDAO.recuperarViajeroConEmail(this.getEmail());
			if (viajeros.size()==0){
				Viajero viajeroNuevo = new Viajero();
				viajeroNuevo.setApellido(this.getApellido());
				viajeroNuevo.setContrasenia(this.getPassword());
				viajeroNuevo.setEmail(this.getEmail());
				viajeroNuevo.setNombre(this.getNombre());
				viajeroNuevo.setTelefono(this.getTelefono());
				viajeroNuevo.setEstado("Activo");
				viajeroNuevo.setFoto(this.parseFileToByteArray(this.getFoto()));
				vDAO.persistir(viajeroNuevo);
				return SUCCESS;
			}
			else 
				return INPUT; 
		}
		else 
			return "input"; 

		
	}
	
	
	
	public void validate(){
		if ((getPassword()==null) || (getPassword().equals("")))
			addFieldError("password", "Se requiere una contraseña de usuario");
		if ((getEmail()==null) || (getEmail().equals("")))
			addFieldError("email","Se requiere un Email");
		if ((getNombre()==null) || (getNombre().equals("")))
			addFieldError("nombre","Se requiere un Nombre");
		if ((getApellido()==null) || (getApellido().equals("")))
			addFieldError("apellido","Se requiere un apellido");
		if ((getTelefono()==null) || (getTelefono().equals("")))
			addFieldError("telefono","Se requiere un telefono");
		if ((getPassword2()==null) || (getPassword2().equals("")))
			addFieldError("password2","Se requiere repetir la contraseña");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return nombre;
	}

	public void setUsuario(String usuario) {
		this.nombre = usuario;
	}
	
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apelldio) {
		this.apellido = apelldio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}
	
	private byte[] parseFileToByteArray(File file){
		byte[] bFile = new byte[(int) file.length()];
		 FileInputStream fileInputStream = null;
        try {
            //convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
	    fileInputStream.read(bFile);
	    fileInputStream.close();
 
	    for (int i = 0; i < bFile.length; i++) {
	       	System.out.print((char)bFile[i]);
            }
 
	    System.out.println("Done");
        }catch(Exception e){
        	e.printStackTrace();
        }
        return bFile;
	}

}

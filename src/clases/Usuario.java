package clases;

import java.io.Serializable;

import javax.persistence.*;
@Entity
@Inheritance (strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="idUsuario")
	private Long Id;
	
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String constrasenia) {
		this.contrasenia = constrasenia;
	}
	
	
	 public long getId() {
		return Id;
	}
	public abstract boolean esViajero();
	 
	 public abstract boolean esAdministrador();
	 
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

}

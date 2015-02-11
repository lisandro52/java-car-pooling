package clases;

import javax.persistence.*;

@Entity
public class Denuncia {
	@Id @GeneratedValue
	@Column(name="idDenuncia")
	private Long id;
	
	private String descripcion;
	
	public Denuncia( ) {
		super();
	 
	}
	
	public Denuncia( String descripcion) {
		super();
		 
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
}
}

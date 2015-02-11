package clases;

import javax.persistence.*;

@Entity
public class Calificacion {
	@Id @GeneratedValue
	@Column(name="idCalificacon")
	private long id;
	
	private String tipoCalificacion;
	private String descripcion;
	
	public String getTipoCalificacion() {
		return tipoCalificacion;
	}
	public void setTipoCalificacion(String tipoCalificacion) {
		this.tipoCalificacion = tipoCalificacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

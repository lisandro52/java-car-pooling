package clases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;

import com.mysql.jdbc.Blob;

@Entity
public class Viajero extends Usuario 
{
	@Lob
	private byte[] foto;
	
	private String telefono;
	private String estado;
	
	@OneToOne//(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private Mensajeria mensajeria;
	
	@OneToMany//(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Denuncia> denuncias ;
	
	@OneToMany
	private List<Calificacion> calificaciones;

	
	@OneToMany(cascade=CascadeType.MERGE)
	@JoinTable(name="viajes_creados")
	//@IndexColumn(base = 1, name = "vjc")
	private List<Viaje> viajesCreados = new ArrayList<Viaje>();
	
	@OneToMany
	@JoinTable(name="viajes_participados")
	//@IndexColumn(base=1, name="vjp")
	private List<Viaje> viajesParticipante= new ArrayList<Viaje>();

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Mensajeria getMensajeria() {
		return mensajeria;
	}

	public void setMensajeria(Mensajeria mensajeria) {
		this.mensajeria = mensajeria;
	}

	public List<Denuncia> getDenuncias() {
		return denuncias;
	}

	public void setDenuncias(List<Denuncia> denuncias) {
		this.denuncias = denuncias;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public List<Viaje> getViajesCreados() {
		return viajesCreados;
	}

	public void setViajesCreados(List<Viaje> viajesCreados) {
		this.viajesCreados = viajesCreados;
	}

	public List<Viaje> getViajesParticipante() {
		return viajesParticipante;
	}

	public void setViajesParticipante(List<Viaje> viajesParticipante) {
		this.viajesParticipante = viajesParticipante;
	}
	
	public void borrarViajeCreado(Viaje viaje){
		int i=this.getViajesCreados().indexOf(viaje);
		this.getViajesCreados().get(i).setEstado("Cancelado");
	}
	
	public void agregarViajeCreado(Viaje viaje){
		this.getViajesCreados().add(viaje);
	}
	
	public void borrarViajeParticipante(Viaje viaje){
		int i=this.getViajesParticipante().indexOf(viaje);
		this.getViajesParticipante().get(i).setEstado("Cancelado");
	}
	
	public void agregarViajeParticipante(Viaje viaje){
		this.getViajesParticipante().add(viaje);
	}

	@Override
	public boolean esViajero() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean esAdministrador() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

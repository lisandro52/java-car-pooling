package clases;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Viaje implements Serializable {
@Id @GeneratedValue(strategy = GenerationType.TABLE)
@Column(name="idViaje")
private long id;
private String origen;
private String destino;
private String horaPartidaIda;
private String horaLlegadaIda;
private String horaPartidaVuelta;
private String horaLlegadaVuelta;
private int asientos;
private String nombre;
private String estado;
private Date fecha;

@OneToOne
private Evento evento;

public String getOrigen() {
	return origen;
}
public void setOrigen(String origen) {
	this.origen = origen;
}
public String getDestino() {
	return destino;
}
public void setDestino(String destino) {
	this.destino = destino;
}


public int getAsientos() {
	return asientos;
}
public void setAsientos(int asientos) {
	this.asientos = asientos;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public Evento getEvento() {
	return evento;
}
public void setEvento(Evento evento) {
	this.evento = evento;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getHoraPartidaIda() {
	return horaPartidaIda;
}
public void setHoraPartidaIda(String horaPartidaIda) {
	this.horaPartidaIda = horaPartidaIda;
}
public String getHoraLlegadaIda() {
	return horaLlegadaIda;
}
public void setHoraLlegadaIda(String horaLlegadaIda) {
	this.horaLlegadaIda = horaLlegadaIda;
}
public String getHoraPartidaVuelta() {
	return horaPartidaVuelta;
}
public void setHoraPartidaVuelta(String horaPartidaVuelta) {
	this.horaPartidaVuelta = horaPartidaVuelta;
}
public String getHoraLlegadaVuelta() {
	return horaLlegadaVuelta;
}
public void setHoraLlegadaVuelta(String horaLlegadaVuelta) {
	this.horaLlegadaVuelta = horaLlegadaVuelta;
}



}

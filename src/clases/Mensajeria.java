package clases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Mensajeria {
	@Id @GeneratedValue
	@Column(name="idMensajeria")
	private long id;
	
	@OneToMany//(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name="mensajes_enviados")
	private List<Mensaje> enviados = new ArrayList<Mensaje>();
	
	@OneToMany//(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name="mensajes_recibidos")
	private List<Mensaje> recibidos = new ArrayList<Mensaje>();

	public List<Mensaje> getEnviados() {
		return enviados;
	}

	public void setEnviados(List<Mensaje> enviados) {
		this.enviados = enviados;
	}

	public List<Mensaje> getRecibidos() {
		return recibidos;
	}

	public void setRecibidos(List<Mensaje> recibidos) {
		this.recibidos = recibidos;
	}
	

	

}

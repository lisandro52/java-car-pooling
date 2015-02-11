package clases;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Mensaje {
	@Id @GeneratedValue
	@Column(name="idMensaje")
	private long id;
	
	private String cuerpo;
	private String asunto;
	private Boolean leido;;
	
	@OneToOne
	private Viajero emisor;
	
	@OneToOne
	private Viajero receptor;
	private Date fecha;
	
	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Viajero getEmisor() {
		return emisor;
	}

	public void setEmisor(Viajero emisor) {
		this.emisor = emisor;
	}

	public Viajero getReceptor() {
		return receptor;
	}

	public void setReceptor(Viajero receptor) {
		this.receptor = receptor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getLeido() {
		return leido;
	}

	public void setLeido(Boolean leido) {
		this.leido = leido;
	}

	public Mensaje() {
		// TODO Auto-generated constructor stub
	}

}

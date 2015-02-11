package clases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Administrador extends Usuario{
	
	@OneToMany (cascade={CascadeType.PERSIST, CascadeType.REMOVE})  
	private List<Evento> eventosCreados;

	public List<Evento> getEventosCreados() {
		return eventosCreados;
	}

	public void setEventosCreados(List<Evento> eventosCreados) {
		this.eventosCreados = eventosCreados;
	}

	@Override
	public boolean esViajero() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esAdministrador() {
		// TODO Auto-generated method stub
		return true;
	}
}

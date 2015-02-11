package ttps;

import java.util.Date;
import java.util.List;
import java.util.Map;

import clases.Administrador;
import clases.Evento;
import clases.Usuario;
import clases.Viajero;
import clasesDAO.AdministradorDAO;
import clasesDAO.EventoDAO;
import clasesDAO.FactoryDAO;
import clasesDAO.ViajeroDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AltaEvento extends ActionSupport{
	public String nombre;
	public String descripcion;
	public String lugar;
	public String fecha;
	public String hora;
	
	public String execute() throws Exception{
		
		Map<String, Object> session = ActionContext.getContext().getSession();
			
				EventoDAO eDAO = FactoryDAO.getEventoDAO();
				Evento eventoNuevo = new Evento();
				eventoNuevo.setNombre(this.getNombre());
				eventoNuevo.setDescripcion(this.getDescripcion());
				eventoNuevo.setLugar(this.getLugar());
				eventoNuevo.setFecha(this.getFecha());
				eventoNuevo.setHora(this.getHora());
				Long idAdmin = (Long) session.get("id");
				AdministradorDAO aDAO = FactoryDAO.getAdministradorDAO();
				Administrador administrador =aDAO.recuperarId(idAdmin);
				eventoNuevo.setAdministrador(administrador);
				eDAO.persistir(eventoNuevo);
				administrador.getEventosCreados().add(eventoNuevo);
				
				
			
				return SUCCESS;

				
		
				
	}
	
	
	
	public void validate(){
		if (getNombre()==null || getNombre().equals(""))
			addFieldError("nombre","Se requiere un nombre");
		if (getDescripcion()==null || getDescripcion().equals(""))
			addFieldError("descripcion","Se requiere una descripcion");
		if (getLugar()==null || getLugar().equals(""))
			addFieldError("lugar","Se requiere un lugar");
		if (getHora()==null || getHora().equals(""))
			addFieldError("hora","Se requiere una hora");
		if (getFecha()==null || getFecha().equals(""))
			addFieldError("fecha","Se requiere una fecha");
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
}

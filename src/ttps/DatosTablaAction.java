package ttps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import clases.Administrador;
import clases.Evento;
import clasesDAO.EventoDAO;
import clasesDAO.FactoryDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DatosTablaAction extends ActionSupport{
	private List<Evento> gridModel; 
	private Integer rows = 0; 
	private Integer page = 0; 
	private Integer total = 0; 
	private Integer record = 0; 
	private String sord; 
	private String sidx; 
	private List<Evento> eventos = new ArrayList<Evento>(); 
	
	public String execute() { 
		Map<String, Object> session = ActionContext.getContext().getSession();
		EventoDAO eDAO = FactoryDAO.getEventoDAO();
		this.eventos = eDAO.listar((Administrador) session.get("usrLogin"));
		record = eDAO.contar((Administrador) session.get("usrLogin")); // Contar filas
		gridModel = eventos; // Setear el gridModel con la lista obtenida 
		total = (int) Math.ceil((double) record / (double) rows); // Calcular el número de págs 
		return SUCCESS; 
	} 
	
	public String getJSON() { 
		return execute(); 
	}

	public List<Evento> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<Evento> gridModel) {
		this.gridModel = gridModel;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecord() {
		return record;
	}

	public void setRecord(Integer record) {
		this.record = record;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
}


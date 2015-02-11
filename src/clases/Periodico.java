package clases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Periodico extends Viaje {

	public enum DiasSemana{
		LUNES, MARTES, MIERCOLES, JUEVES, VIERNES;
	}	
	
	@ElementCollection(targetClass=DiasSemana.class)
	@Enumerated(EnumType.STRING)
	private List<DiasSemana> dias;

	public List<DiasSemana> getDias() {
		return dias;
	}

	public void setDias(List<DiasSemana> dias) {
		this.dias = dias;
	}
}

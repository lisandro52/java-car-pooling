

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.mapping.Collection;

import clases.*;
import clases.Periodico.DiasSemana;
import clasesDAO.FactoryDAO;
import datos.EMF;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletTest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		FactoryDAO fact = new FactoryDAO();



		//Creo un evento
		Evento evento = new Evento();
		evento.setDescripcion("Excursion a Tecnopolis");
		evento.setNombre("Tecnopolis");
		evento.setHora("10.30");
		evento.setLugar("Tecnopolis");
		Date fecha1 = new Date(114,11,3);
		//evento.setFecha(fecha1);
		fact.getEventoDAO().persistir(evento);

		//Le modifico un dato al evento
		evento.setDescripcion("Una excursion espectacular");
		fact.getEventoDAO().actualizar(evento);

		//Creo otro evento
		Evento evento2 = new Evento();
		evento2.setDescripcion("Visita a Accenture");
		evento2.setNombre("Accenture");
		evento2.setHora("15.30");
		evento2.setLugar("Accenture");
		Date fecha2 = new Date(114,11,7);
		//evento2.setFecha(fecha2);
		fact.getEventoDAO().persistir(evento2);


		//Creo un viaje

		Viaje viaje = new Puntual();
		viaje.setAsientos(4);
		viaje.setDestino("Tecnopolis");
		viaje.setEstado("Activo");
		viaje.setEvento(evento);
		Date fechaViaje = new Date();
		viaje.setFecha(fechaViaje);
		viaje.setHoraPartidaIda("14:30");
		viaje.setHoraLlegadaIda("16:30");
		viaje.setHoraPartidaVuelta("18:00");
		viaje.setHoraLlegadaVuelta("20:00");
		viaje.setNombre("Viaje a tecnopolis");
		viaje.setOrigen("Facultad Informatica");
		fact.getViajeDAO().persistir(viaje);


		//Creo un viaje periodico

		Periodico viajePeriodico = new Periodico();
		viajePeriodico.setAsientos(4);
		viajePeriodico.setDestino("Informatica");
		viajePeriodico.setEstado("Activo");
		Date fechaViaje2 = new Date();
		viajePeriodico.setFecha(fechaViaje2);
		viajePeriodico.setHoraPartidaIda("08:00");
		viajePeriodico.setHoraLlegadaIda("09:00");
		viajePeriodico.setHoraPartidaVuelta("12:00");
		viajePeriodico.setHoraLlegadaVuelta("13:00");
		viajePeriodico.setNombre("Facultad Informatica");
		viajePeriodico.setOrigen("Facultad Informatica");

		DiasSemana dias = null;

		List listaDias = new ArrayList();
		listaDias.add(dias.JUEVES);
		listaDias.add(dias.LUNES);
		viajePeriodico.setDias(listaDias);
		fact.getPeriodicoDAO().persistir(viajePeriodico);


		//Creo dos mensajerias

		Mensajeria mensajeria1 = new Mensajeria();
		fact.getMensajeriaDAO().persistir(mensajeria1);

		Mensajeria mensajeria2 = new Mensajeria();
		fact.getMensajeriaDAO().persistir(mensajeria2);


		//Creo una calificacion

		Calificacion calif = new Calificacion();
		calif.setDescripcion("Muy buen conductor!");
		calif.setTipoCalificacion("Positiva");
		List<Calificacion> calificaciones = new ArrayList<Calificacion>();
		calificaciones.add(calif);
		fact.getCalificacionDAO().persistir(calif);

		//Creo otra calificacion

		Calificacion calif2 = new Calificacion();
		calif2.setDescripcion("Muy buen conductor!");
		calif2.setTipoCalificacion("Positiva");
		calificaciones.add(calif2);
		fact.getCalificacionDAO().persistir(calif2);


		//Creo una denuncia
		this.imprimir("Agrego una denuncia");
		Denuncia den = new Denuncia();
		den.setDescripcion("El conductor condujo ebrio!");
		List<Denuncia> denuncias = new ArrayList<Denuncia>();
		denuncias.add(den);
		fact.getDenunciaDAO().persistir(den);

		this.imprimir("Descripcion de la denuncia:");
		this.imprimir(fact.getDenunciaDAO().getDenuncia(1).getDescripcion());
		//Creo un Administrador
		this.imprimir("Agrego un adminsitrador Ramiro");
		Administrador admin = new Administrador();
		admin.setApellido("Boza");
		admin.setNombre("Ramiro");
		admin.setEmail("ramiro.boza@hotmail.com");
		admin.setContrasenia("1111");
		List<Evento> eventos = new ArrayList<Evento>();
		eventos.add(evento);
		eventos.add(evento2);
		admin.setEventosCreados(eventos);

		//Agrego un administrador
		fact.getAdministradorDAO().persistir(admin);

		//Le modifico un atributo

		admin.setEmail("ramiro@hotmail.com");
		fact.getAdministradorDAO().actualizar(admin);


		//Creo un viajero
		this.imprimir("Agrego un viajero Nahuel");
		Viajero viajero1 = new Viajero();
		viajero1.setApellido("Prinsich");
		viajero1.setNombre("Nahuel");
		viajero1.setContrasenia("1234");
		viajero1.setEmail("prinsich@hotmail.com");
		//viajero1.setFoto("http://fotos/prinsich");
		viajero1.setTelefono("4832253");
		viajero1.setEstado("Activo");
		//viajero1.setFoto("foto");
		viajero1.setMensajeria(mensajeria1);
		viajero1.setCalificaciones(calificaciones);
		viajero1.setDenuncias(denuncias);
		fact.getViajeroDAO().persistir(viajero1);

		//Creo otro viajero
		this.imprimir("Agrego un viajero Franco");
		Viajero viajero2 = new Viajero();
		viajero2.setApellido("Butto");
		viajero2.setNombre("Franco");
		viajero2.setContrasenia("1234");
		viajero2.setEmail("butto@hotmail.com");
		//viajero2.setFoto("http://fotos/butto");
		viajero2.setTelefono("4567656");
		viajero2.setEstado("Activo");
		fact.getViajeroDAO().persistir(viajero2);
		viajero2.setMensajeria(mensajeria2);
		fact.getViajeroDAO().actualizar(viajero2);
		

		//Le modifico un dato


		/*viajero.setConstrasenia("5555");
		fact.getViajeroDAO().actualizar(viajero);*/


		//Creo un mensaje

		Mensaje mensaje = new Mensaje();
		mensaje.setAsunto("consulta");
		mensaje.setCuerpo("bla bla bla bla");
		mensaje.setLeido(true);
		mensaje.setEmisor(viajero1);
		mensaje.setReceptor(viajero2);
		mensaje.setFecha(fecha1);
		fact.getMensajeDAO().persistir(mensaje);

		List<Mensaje> enviados = new ArrayList<Mensaje>();
		enviados.add(mensaje);
		mensajeria1.setEnviados(enviados);
		fact.getMensajeriaDAO().actualizar(mensajeria1);
		
		
		Diario viajeDiario = new Diario();
		viajeDiario.setAsientos(2);
		viajeDiario.setDestino("Facultad");
		viajeDiario.setEstado("Activo");
		viajeDiario.setEvento(evento);
		Date fechaViajeDiario = new Date();
		viajeDiario.setFecha(fechaViajeDiario);
		viajeDiario.setHoraPartidaIda("08:30");
		viajeDiario.setHoraLlegadaIda("09:00");
		viajeDiario.setHoraPartidaVuelta("18:00");
		viajeDiario.setHoraLlegadaVuelta("18:30");
		viajeDiario.setNombre("Viaje diario a la facultad");
		viajeDiario.setOrigen("Casa de Juan");
		fact.getViajeDAO().persistir(viajeDiario);
		
		//Agrego 2 viajes al viajero1
		this.imprimir("Le agrego dos viajes a Nahuel.");
		viajero1.agregarViajeCreado(viajeDiario);
		viajero1.agregarViajeCreado(viaje);
		fact.getViajeroDAO().actualizar(viajero1);
		
		this.imprimir("Info del primer viaje de Nahuel: ");
		Viaje primerViaje = fact.getViajeroDAO().recuperarViajeroConNombre("Nahuel").getViajesCreados().get(0);
		this.imprimir(primerViaje.getNombre() + " " + primerViaje.getOrigen() + "-" + primerViaje.getDestino());
		//this.imprimir(fact.getViajeroDAO().recuperarViajeroConNombre("Nahuel").getViajesCreados().get(0).getOrigen());
		
		//Agrego 1 viaje al viajero2
		this.imprimir("Agrego un viaje a Franco");
		viajero2.agregarViajeParticipante(viajePeriodico);
		fact.getViajeroDAO().actualizar(viajero2);
		
		this.imprimir("Estado del viaje de Franco: ");
		Viaje viajeFranco = fact.getViajeroDAO().recuperarViajeroConNombre("Franco").getViajesParticipante().get(0);
		this.imprimir(viajeFranco.getEstado());

		
		//Borro un viaje al viajero 1
		this.imprimir("Borro el viaje de Franco. Estado:");
		viajero2.borrarViajeParticipante(viajePeriodico);
		fact.getPeriodicoDAO().actualizar(viajePeriodico);
		Viaje viajeFranco2 = fact.getViajeroDAO().recuperarViajeroConNombre("Franco").getViajesParticipante().get(0);
		this.imprimir(viajeFranco2.getEstado());
		this.imprimir("Apellido del administrador:");
		this.imprimir(fact.getAdministradorDAO().recuperar("Ramiro").getApellido());

	}
	
	public void imprimir(String string){
		System.out.println(string);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

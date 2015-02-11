package clasesDAO;


import Claseshiberjpa.*;


public class FactoryDAO {

	public FactoryDAO() {
		// TODO Auto-generated constructor stub
	}

	
	public static ViajeroDAO getViajeroDAO(){
		return new ViajeroDAOhiberjpa();
	}


	public static DenunciaDAO getDenunciaDAO() {
		// TODO Auto-generated method stub
		return new DenunciaDAOhiberjpa();
	}


	public static AdministradorDAO getAdministradorDAO() {
		return new AdministradorDAOhiberjpa();
		
	}


	public static CalificacionDAO getCalificacionDAO() {
		// TODO Auto-generated method stub
		return new CalificacionDAOhiberjpa() ;
	}


	public static MensajeriaDAO getMensajeriaDAO() {
		// TODO Auto-generated method stub
		return new MensajeriaDAOhiberjpa();
	}


	public static EventoDAO getEventoDAO() {
		// TODO Auto-generated method stub
		return new EventoDAOhiberjpa();
	}


	public static ViajeDAO getViajeDAO() {
		// TODO Auto-generated method stub
		return new ViajeDAOhiberjpa();
	}


	public static MensajeDAO getMensajeDAO() {
		// TODO Auto-generated method stub
		return new MensajeDAOhiberjpa();
	}


	public static PeriodicoDAO getPeriodicoDAO() {
		// TODO Auto-generated method stub
		return new PeriodicoDAOhiberjpa();
	}


	public static UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new UsuarioDAOhiberjpa();
	}
}

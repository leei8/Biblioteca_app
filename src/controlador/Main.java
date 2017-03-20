package controlador;
import modelo.*;
import vista.*;

public class Main {

	public static void main(String[] args) {
	
		//Crear controladores
		ControladorSocio controladorSocio = new ControladorSocio();
		
		//Crear modelos
		SocioModelo socioModelo = new SocioModelo();
		
		//Crear ventanas
		Principal principal = new Principal();
		GestionSocio gestionSocio = new GestionSocio(principal, true);
		FormularioSocio formularioSocio = new FormularioSocio(gestionSocio,true);
		
		principal.setControladorSocio(controladorSocio);
		gestionSocio.setControladorSocio(controladorSocio);
		formularioSocio.setControladorSocio(controladorSocio);
		
		//Asignar ventanas y modelos al controlador
		controladorSocio.setPrincipal(principal);
		controladorSocio.setGestionSocios(gestionSocio);
		controladorSocio.setFormularioSocio(formularioSocio);
		controladorSocio.setSocioModelo(socioModelo);
		
	}

}

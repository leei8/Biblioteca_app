package controlador;

import modelo.*;
import vista.*;

public class Main {

	public static void main(String[] args) {

		// Crear controladores
		ControladorSocio controladorSocio = new ControladorSocio();
		ControladorLibro controladorLibro = new ControladorLibro();
		ControladorPrestamo controladorPrestamo = new ControladorPrestamo();
		// Crear modelos
		SocioModelo socioModelo = new SocioModelo();
		LibroModelo libroModelo = new LibroModelo();
		PrestamoModelo prestamoModelo = new PrestamoModelo();

		// Crear ventanas
		Principal principal = new Principal();

		GestionSocio gestionSocio = new GestionSocio(principal, true);
		FormularioSocio formularioSocio = new FormularioSocio(gestionSocio, true);
		EliminarSocio eliminarSocio = new EliminarSocio(gestionSocio, true);
		ConsultaSocio consultaSocio = new ConsultaSocio(gestionSocio, true);

		GestionLibro gestionLibro = new GestionLibro(principal, true);
		FormularioLibro formularioLibro = new FormularioLibro(gestionLibro, true);
		ConsultaLibro consultaLibro = new ConsultaLibro(gestionLibro, true);

		principal.setControladorSocio(controladorSocio);

		gestionSocio.setControladorSocio(controladorSocio);
		formularioSocio.setControladorSocio(controladorSocio);
		eliminarSocio.setControladorSocio(controladorSocio);
		consultaSocio.setControladorSocio(controladorSocio);

		principal.setControladorLibro(controladorLibro);
		gestionLibro.setControladorLibro(controladorLibro);
		formularioLibro.setControladorLibro(controladorLibro);
		consultaLibro.setControladorLibro(controladorLibro);

		// Asignar ventanas y modelos al controlador
		controladorSocio.setPrincipal(principal);
		controladorSocio.setSocioModelo(socioModelo);
		controladorSocio.setGestionSocios(gestionSocio);
		controladorSocio.setFormularioSocio(formularioSocio);
		controladorSocio.setEliminarSocio(eliminarSocio);
		controladorSocio.setConsultaSocio(consultaSocio);

		controladorLibro.setPrincipal(principal);
		controladorLibro.setLibroModelo(libroModelo);
		controladorLibro.setGestionLibro(gestionLibro);
		controladorLibro.setFormularioLibro(formularioLibro);
		controladorLibro.setConsultaLibro(consultaLibro);

		// prestamo egiteko

		GestionPrestamo gestionPrestamo = new GestionPrestamo(principal, true);
		RealizarPrestamo realizarprestamo = new RealizarPrestamo(gestionPrestamo, true);

		controladorPrestamo.setPrincipal(principal);
		controladorPrestamo.setPrestamoModelo(prestamoModelo);
		controladorPrestamo.setGestionPrestamo(gestionPrestamo);
		controladorPrestamo.setRealizarPrestamo(realizarprestamo);

		principal.setVisible(true);
	}
}

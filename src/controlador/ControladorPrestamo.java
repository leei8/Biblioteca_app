package controlador;

import modelo.LibroModelo;
import modelo.PrestamoModelo;
import modelo.SocioModelo;
import vista.GestionPrestamo;
import vista.Principal;
import vista.RealizarPrestamo;

public class ControladorPrestamo {
	// atributo
	private Principal principal;
	private GestionPrestamo gestionPrestamo;
	private RealizarPrestamo realizarPrestamo;
	private PrestamoModelo prestamoModelo;
	private LibroModelo libromodelo;
	private SocioModelo sociomodelo;

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public GestionPrestamo getGestionPrestamo() {
		return gestionPrestamo;
	}

	public void setGestionPrestamo(GestionPrestamo gestionprestamo) {
		this.gestionPrestamo = gestionprestamo;
	}

	public RealizarPrestamo getRealizarprestamo() {
		return realizarPrestamo;
	}

	public void setRealizarprestamo(RealizarPrestamo realizarprestamo) {
		this.realizarPrestamo = realizarprestamo;
	}

	public PrestamoModelo getPrestamoModelo() {
		return prestamoModelo;
	}

	public void setPrestamoModelo(PrestamoModelo prestamoModelo) {
		this.prestamoModelo = prestamoModelo;
	}

	public LibroModelo getLibromodelo() {
		return libromodelo;
	}

	public void setLibromodelo(LibroModelo libromodelo) {
		this.libromodelo = libromodelo;
	}

	public SocioModelo getSociomodelo() {
		return sociomodelo;
	}

	public void setSociomodelo(SocioModelo sociomodelo) {
		this.sociomodelo = sociomodelo;
	}
}

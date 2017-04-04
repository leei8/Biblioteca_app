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
	private LibroModelo libroModelo;
	private SocioModelo socioModelo;

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

	public RealizarPrestamo getRealizarPrestamo() {
		return realizarPrestamo;
	}

	public void setRealizarPrestamo(RealizarPrestamo realizarprestamo) {
		this.realizarPrestamo = realizarprestamo;
	}

	public PrestamoModelo getPrestamoModelo() {
		return prestamoModelo;
	}

	public void setPrestamoModelo(PrestamoModelo prestamoModelo) {
		this.prestamoModelo = prestamoModelo;
	}

	public LibroModelo getLibromodelo() {
		return libroModelo;
	}

	public void setLibromodelo(LibroModelo libromodelo) {
		this.libroModelo = libromodelo;
	}

	public SocioModelo getSociomodelo() {
		return socioModelo;
	}

	public void setSociomodelo(SocioModelo sociomodelo) {
		this.socioModelo = sociomodelo;
	}
	public void abrirPrestamoModelo() {
		this.prestamoModelo.setVisible(true);

	}
	public void cerrarPrestamoModelo() {
		this.prestamoModelo.limpiarFormularioLibro();
		this.prestamoModelo.dispose();

	}
}

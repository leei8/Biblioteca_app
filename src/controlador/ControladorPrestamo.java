package controlador;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import modelo.Libro;
import modelo.LibroModelo;
import modelo.Prestamo;
import modelo.PrestamoModelo;
import modelo.Socio;
import modelo.SocioModelo;
import vista.FormularioPrestamo;
import vista.GestionPrestamo;
import vista.Principal;

public class ControladorPrestamo {

	private Principal principal;
	private PrestamoModelo prestamoModelo;
	private SocioModelo socioModelo;
	private LibroModelo libroModelo;
	private GestionPrestamo gestionPrestamo;
	private FormularioPrestamo formularioPrestamo;

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public GestionPrestamo getGestionPrestamo() {
		return gestionPrestamo;
	}

	public void setGestionPrestamo(GestionPrestamo gestionPrestamo) {
		this.gestionPrestamo = gestionPrestamo;
	}

	public FormularioPrestamo getFormularioPrestamo() {
		return formularioPrestamo;
	}

	public void setFormularioPrestamo(FormularioPrestamo formularioPrestamo) {
		this.formularioPrestamo = formularioPrestamo;
	}

	public PrestamoModelo getPrestamoModelo() {
		return prestamoModelo;
	}

	public void setPrestamoModelo(PrestamoModelo prestamoModelo) {
		this.prestamoModelo = prestamoModelo;
	}

	public SocioModelo getSocioModelo() {
		return socioModelo;
	}

	public void setSocioModelo(SocioModelo socioModelo) {
		this.socioModelo = socioModelo;
	}

	public LibroModelo getLibroModelo() {
		return libroModelo;
	}

	public void setLibroModelo(LibroModelo libroModelo) {
		this.libroModelo = libroModelo;
	}

	public void abrirVentanaGestionPrestamo() {
		this.gestionPrestamo.setVisible(true);

	}

	public void abrirVentanaFormularioPrestamo() {
		ArrayList<Socio> socios = this.socioModelo.select();
		ArrayList<Libro> libros = this.libroModelo.select();
		formularioPrestamo.rellenarComboBoxSocios(socios);
		formularioPrestamo.rellenarComboBoxLibros(libros);
		this.formularioPrestamo.setVisible(true);

	}

	public void realizarPrestamo(int idSoc, String titulo) {
		if (this.socioModelo.select(idSoc) != null) {
			// sozioa existitzen da
			Libro libro = this.libroModelo.selecLibroPorTitulo(titulo);
			// prestamoa sortu
			Prestamo prestamo = new Prestamo();
			// prestamoa bete
			prestamo.setId_libro(libro.getId());
			prestamo.setFecha(new Date());
			prestamo.setId_socio(idSoc);
			prestamo.setDevuelto(false);
			// prestamo modeloari esan isert egiteko prestamoa
			this.prestamoModelo.insert(prestamo);
			// garbitu
			this.formularioPrestamo.limpiar();
			JOptionPane.showMessageDialog(formularioPrestamo, "mailegua eginda", "Mailegua",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			// sozioa ez da existitzen //falta terminar esto.
			
			this.formularioPrestamo.errorPorSocioMall();
		}

	}

}

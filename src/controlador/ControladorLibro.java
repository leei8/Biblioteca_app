package controlador;

import modelo.*;
import vista.*;

public class ControladorLibro {

	// Atributos
	private LibroModelo libroModelo;
	private Principal principal;
	private GestionLibro gestionLibro;
	private FormularioLibro formularioLibro;

	// Getters y setters

	public LibroModelo getLibroModelo() {
		return libroModelo;
	}

	public void setLibroModelo(LibroModelo libroModelo) {
		this.libroModelo = libroModelo;
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public GestionLibro getGestionLibro() {
		return gestionLibro;
	}

	public void setGestionLibro(GestionLibro gestionLibro) {
		this.gestionLibro = gestionLibro;
	}

	public FormularioLibro getFormularioLibro() {
		return formularioLibro;
	}

	public void setFormularioLibro(FormularioLibro formularioLibro) {
		this.formularioLibro = formularioLibro;
	}

	// Metodos
	public void abrirVentanaGestionLibros() {
		this.gestionLibro.setVisible(true);
	}

	public void abrirFormularioLibro() {
		this.formularioLibro.setVisible(true);

	}

//	public void cerrarFormularioLibro() {
//		this.formularioLibro.limpiarFormularioLibro();
//		this.formularioLibro.dispose();
//
//	}

	public void insertarLibro(String titulo, String autor, int num_pag)  {
		Libro libro = new Libro();
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setNum_pag(num_pag);

		libroModelo.insert(libro);

	}

}

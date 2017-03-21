package controlador;

import modelo.*;
import vista.*;

public class ControladorSocio {

	// Atributos
	private SocioModelo socioModelo;
	private Principal principal;
	private GestionSocio gestionSocio;
	private FormularioSocio formularioSocio;

	// Getters y setters
	public SocioModelo getSocio_modelo() {
		return socioModelo;
	}

	public void setSocioModelo(SocioModelo socioModelo) {
		this.socioModelo = socioModelo;
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public GestionSocio getGestionSocios() {
		return gestionSocio;
	}

	public void setGestionSocios(GestionSocio gestionSocio) {
		this.gestionSocio = gestionSocio;
	}

	public FormularioSocio getFormularioSocio() {
		return formularioSocio;
	}

	public void setFormularioSocio(FormularioSocio formularioSocio) {
		this.formularioSocio = formularioSocio;
	}

	// Metodos
	public void abrirVentanaGestionSocios() {
		this.gestionSocio.setVisible(true);
	}

	public void abrirFormularioSocio() {
		this.formularioSocio.setVisible(true);

	}

	public void cerrarFormularioSocio() {
		this.formularioSocio.limpiarFormularioSocio();
		this.formularioSocio.dispose();

	}

	public void insertarSocio(String nombre, String apellido, String direccion, String poblacion, String provincia,
			String dni) {
		Socio socio = new Socio();
		socio.setNombre(nombre);
		socio.setApellido(apellido);
		socio.setDireccion(direccion);
		socio.setProvincia(provincia);
		socio.setDni(dni);
		
		socioModelo.insert(socio);

	}

}

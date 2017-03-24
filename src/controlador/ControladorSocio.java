package controlador;

import java.util.ArrayList;

import modelo.*;
import vista.*;

public class ControladorSocio {

	// Atributos
	private SocioModelo socioModelo;
	private Principal principal;
	private GestionSocio gestionSocio;
	private FormularioSocio formularioSocio;
	private EliminarSocio eliminarSocio;
	private ConsultaSocio consultaSocio;

	

	// Getters y setters
	public GestionSocio getGestionSocio() {
		return gestionSocio;
	}

	public void setGestionSocio(GestionSocio gestionSocio) {
		this.gestionSocio = gestionSocio;
	}

	public ConsultaSocio getConsultaSocio() {
		return consultaSocio;
	}

	public void setConsultaSocio(ConsultaSocio consultaSocio) {
		this.consultaSocio = consultaSocio;
	}

	public SocioModelo getSocioModelo() {
		return socioModelo;
	}
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

	public EliminarSocio getEliminarSocio() {
		return eliminarSocio;
	}

	public void setEliminarSocio(EliminarSocio eliminarSocio) {
		this.eliminarSocio = eliminarSocio;
	}

	// Metodos
	public void abrirVentanaGestionSocios() {
		this.gestionSocio.setVisible(true);
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

	public void abrirFormularioSocio() {
		this.formularioSocio.setVisible(true);

	}

	public void cerrarFormularioSocio() {
		this.formularioSocio.limpiarFormularioSocio();
		this.formularioSocio.dispose();

	}

	public void abrirEliminarSocio() {
		ArrayList<Socio> socios = socioModelo.select();
		this.eliminarSocio.rellenarCombo(socios);
		this.eliminarSocio.setVisible(true);

	}

	public void cerrarEliminarSocio() {
		this.eliminarSocio.dispose();

	}

	public void rellenarFormularioBorrado(int idSocio) {
		Socio socio = socioModelo.select(idSocio);
		eliminarSocio.rellenarCamposFormulario(socio);
	}

	public void eliminarSocio(int id) {
		socioModelo.delete(id);
		
		//Limpiar formulario
		eliminarSocio.clearTextFields();
		eliminarSocio.clearComboBoxSocios();
		
		//Rellenar de nuevo el formulario
		ArrayList<Socio> socios = socioModelo.select();
		eliminarSocio.rellenarCombo(socios);
	}

	public void abrirConsultaSocio() {
	
		ArrayList<Socio> socios = socioModelo.select();
		consultaSocio.rellenarTabla(socios);
		this.consultaSocio.setVisible(true);
		
	}

	public void rellenarTablaSelectNombre(String nombre) {
	//	ArrayList<Socio> socios = socioModelo.select(nombre);
	//	consultaSocio.rellenarTabla(socios);
	//	this.consultaSocio.setVisible(true);
	}
}

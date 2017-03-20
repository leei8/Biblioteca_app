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
	

	
}

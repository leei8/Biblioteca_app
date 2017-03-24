package vista;
import controlador.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionSocio extends JDialog {

	//Atributos
	private ControladorSocio controladorSocio;
	
	//Getters y setters
	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}
	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}

	//Constructor
	public GestionSocio(Principal principal, boolean modal) {
		super(principal,modal);
		setBounds(100, 100, 450, 300);
		JButton botonAnadirSocio = new JButton("A\u00F1adir socio");
		botonAnadirSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorSocio.abrirFormularioSocio();
			}
		});
		JButton botonEliminarSocio = new JButton("Eliminar socio");
		botonEliminarSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorSocio.abrirEliminarSocio();
			}
		});
		JButton botonModificarSocio = new JButton("Modificar socio");
		
		JButton btnBuscarSocios = new JButton("Consulta de socios");
		btnBuscarSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorSocio.abrirConsultaSocio();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBuscarSocios, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addComponent(botonModificarSocio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addComponent(botonEliminarSocio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addComponent(botonAnadirSocio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
					.addGap(301))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addComponent(botonAnadirSocio)
					.addGap(18)
					.addComponent(botonEliminarSocio)
					.addGap(18)
					.addComponent(botonModificarSocio)
					.addGap(18)
					.addComponent(btnBuscarSocios)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}

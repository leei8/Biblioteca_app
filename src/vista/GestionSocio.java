package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorSocio;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		JButton btnNewButton = new JButton("A\u00F1adir socio");
		JButton btnNewButton_1 = new JButton("Eliminar socio");
		JButton btnNewButton_2 = new JButton("Modificar socio");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_2))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(144)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(144)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(187))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addComponent(btnNewButton)
					.addGap(35)
					.addComponent(btnNewButton_1)
					.addGap(36)
					.addComponent(btnNewButton_2)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}

}

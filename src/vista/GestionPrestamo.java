package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controlador.ControladorPrestamo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnRealizarPrestamo;
	private ControladorPrestamo controladorPrestamo;
	
	
	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}

	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}

	
	
	public GestionPrestamo(Principal parent, boolean modal) {
		super(parent,modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			btnRealizarPrestamo = new JButton("Realizar prestamo");
			btnRealizarPrestamo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controladorPrestamo.abrirVentanaFormularioPrestamo();
				}
			});
		}
		JLabel lblGestionDePrestamos = new JLabel("GESTION DE PRESTAMOS");
		lblGestionDePrestamos.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(90)
							.addComponent(lblGestionDePrestamos))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(147)
							.addComponent(btnRealizarPrestamo)))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGestionDePrestamos)
					.addGap(35)
					.addComponent(btnRealizarPrestamo)
					.addContainerGap(160, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}

}

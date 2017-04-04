package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrestamo;
import modelo.Libro;
import modelo.Socio;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FormularioPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ControladorPrestamo controladorPrestamo;
	private JComboBox comboBoxSocios;
	private JComboBox comboBoxLibros;
	

	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}

	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}

	
	public FormularioPrestamo(GestionPrestamo parent, boolean modal) {
		super(parent,modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		comboBoxSocios = new JComboBox();

		comboBoxLibros = new JComboBox();

		JLabel lblEligeElSocio = new JLabel("Elige el socio:");

		JLabel lblEligeElLibro = new JLabel("Elige el libro:");

		JButton btnConfirmarPrestamo = new JButton("Confirmar prestamo");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(73)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblEligeElLibro)
							.addPreferredGap(ComponentPlacement.RELATED, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblEligeElSocio)
								.addPreferredGap(ComponentPlacement.RELATED, 100, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(comboBoxSocios, Alignment.LEADING, 0, 164, Short.MAX_VALUE)
								.addComponent(comboBoxLibros, Alignment.LEADING, 0, 164, Short.MAX_VALUE))))
					.addGap(187))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(287, Short.MAX_VALUE)
					.addComponent(btnConfirmarPrestamo)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(37)
					.addComponent(lblEligeElSocio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxSocios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(lblEligeElLibro)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxLibros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(btnConfirmarPrestamo)
					.addGap(26))
		);
		contentPanel.setLayout(gl_contentPanel);
	}

	public void rellenarComboBoxSocios(ArrayList<Socio> socios) {
		for (Socio socio : socios) {
			comboBoxSocios.addItem(socio.getId() + ": " + socio.getNombre() + " " + socio.getApellido());
		}
		
	}

	public void rellenarComboBoxLibros(ArrayList<Libro> libros) {
		
		for (Libro libro : libros) {
			comboBoxLibros.addItem(libro.getId() + ": " + libro.getTitulo());
		}
	}
}

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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ControladorPrestamo controladorPrestamo;
	private JTextField textFieldSocio;
	private JTextField textFieldTitulo;

	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}

	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}

	public FormularioPrestamo(GestionPrestamo parent, boolean modal) {
		super(parent, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblEligeElSocio = new JLabel("Idsoc:");

		JLabel lblEligeElTitulo = new JLabel("Titulo:");

		JButton btnConfirmarPrestamo = new JButton("Confirmar prestamo");
		btnConfirmarPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPrestamo.realizarPrestamo(Integer.parseInt(textFieldSocio.getText()),
						textFieldTitulo.getText());

			}
		});

		textFieldSocio = new JTextField();
		textFieldSocio.setColumns(10);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap(287, Short.MAX_VALUE)
						.addComponent(btnConfirmarPrestamo).addContainerGap())
				.addGroup(Alignment.LEADING,
						gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblEligeElSocio)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFieldSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(298, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup().addContainerGap()
						.addComponent(lblEligeElTitulo)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(textFieldTitulo,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(298, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(40)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblEligeElSocio)
								.addComponent(textFieldSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(47)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING).addComponent(lblEligeElTitulo)
								.addComponent(textFieldTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
						.addComponent(btnConfirmarPrestamo).addGap(26)));
		contentPanel.setLayout(gl_contentPanel);
	}

	public void rellenarComboBoxSocios(ArrayList<Socio> socios) {
		for (Socio socio : socios) {
			// comboBoxSocios.addItem(socio.getId() + ": " + socio.getNombre() +
			// " " + socio.getApellido());
		}

	}

	public void rellenarComboBoxLibros(ArrayList<Libro> libros) {

		for (Libro libro : libros) {
			// comboBoxLibros.addItem(libro.getId() + ": " + libro.getTitulo());
		}
	}

	public void limpiar() {
		//limpiar metodoa texfield guztiak garbituko du.
		textFieldSocio.setText("");
		textFieldTitulo.setText("");
	}
}

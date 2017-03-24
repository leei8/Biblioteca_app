package vista;

import controlador.*;
import modelo.Socio;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class EliminarSocio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldId;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDireccion;
	private JTextField textFieldPoblacion;
	private JTextField textFieldProvincia;
	private JTextField textFieldDni;
	private ControladorSocio controladorSocio;
	private JComboBox comboBoxSocios;
	

	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}

	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}

	public EliminarSocio(GestionSocio padre, boolean modal) {
		super(padre, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		JLabel lblEscogerSocio = new JLabel("Escoger socio:");

		JLabel lblNombre = new JLabel("Nombre:");

		JLabel lblApellido = new JLabel("Apellido:");

		JLabel lblDireccion = new JLabel("Direccion:");

		JLabel lblPoblacion = new JLabel("Poblacion:");

		JLabel lblProvincia = new JLabel("Provincia:");

		JLabel lblDni = new JLabel("DNI:");

		textFieldNombre = new JTextField();
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);

		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		textFieldApellido.setEnabled(false);
		textFieldApellido.setColumns(10);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setEnabled(false);
		textFieldDireccion.setEditable(false);
		textFieldDireccion.setColumns(10);

		textFieldPoblacion = new JTextField();
		textFieldPoblacion.setEnabled(false);
		textFieldPoblacion.setEditable(false);
		textFieldPoblacion.setColumns(10);

		textFieldProvincia = new JTextField();
		textFieldProvincia.setEditable(false);
		textFieldProvincia.setEnabled(false);
		textFieldProvincia.setColumns(10);

		textFieldDni = new JTextField();
		textFieldDni.setEnabled(false);
		textFieldDni.setEditable(false);
		textFieldDni.setColumns(10);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmarEliminacion();
			}

		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorSocio.cerrarEliminarSocio();
			}
		});

		comboBoxSocios = new JComboBox();
		comboBoxSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxSocios.getSelectedIndex() == -1) {
					clearTextFields();
				} else {
					String datosSocio = (String) comboBoxSocios.getSelectedItem();

					String[] partes = datosSocio.split(":");
					// En la parte 0 esta el ID
					int idSocio = Integer.parseInt(partes[0]);
					controladorSocio.rellenarFormularioBorrado(idSocio);
				}
			}
		});
		comboBoxSocios.setEditable(true);
		
		JLabel lblId = new JLabel("ID:");
		
		textFieldId = new JTextField();
		textFieldId.setEnabled(false);
		textFieldId.setEditable(false);
		textFieldId.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblEscogerSocio)
							.addGap(18)
							.addComponent(comboBoxSocios, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblApellido)
								.addComponent(lblDireccion)
								.addComponent(lblPoblacion)
								.addComponent(lblProvincia)
								.addComponent(lblDni))
							.addGap(30)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldPoblacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(64)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnBorrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEscogerSocio)
								.addComponent(comboBoxSocios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblId)
								.addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(25)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(96)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApellido))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDireccion))))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(textFieldPoblacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFieldProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblProvincia))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFieldDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDni)))
								.addComponent(lblPoblacion)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(23)
							.addComponent(btnBorrar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar)))
					.addGap(84))
		);
		contentPanel.setLayout(gl_contentPanel);
	}

	public void clearTextFields() {
		this.textFieldId.setText("");
		this.textFieldNombre.setText("");
		this.textFieldApellido.setText("");
		this.textFieldDireccion.setText("");
		this.textFieldPoblacion.setText("");
		this.textFieldProvincia.setText("");
		this.textFieldDni.setText("");

	}
	public void clearComboBoxSocios() {
		comboBoxSocios.removeAllItems();
	}

	public void rellenarCombo(ArrayList<Socio> socios) {

		for (Socio socio : socios) {
			this.comboBoxSocios.addItem(socio.getId() + ": " + socio.getNombre() + " " + socio.getApellido());

		}
		this.comboBoxSocios.setSelectedIndex(-1); // Para que no haya
													// seleccionado ninguno al principio
	}

	public void rellenarCamposFormulario(Socio socio) {
		this.textFieldId.setText(String.valueOf((socio.getId())));
		this.textFieldNombre.setText(socio.getNombre());
		this.textFieldApellido.setText(socio.getApellido());
		this.textFieldDireccion.setText(socio.getDireccion());
		this.textFieldPoblacion.setText(socio.getPoblacion());
		this.textFieldProvincia.setText(socio.getProvincia());
		this.textFieldDni.setText(socio.getDni());
	}

	private void confirmarEliminacion() {
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas borrar este socio?");
		if (respuesta == JOptionPane.OK_OPTION){
			controladorSocio.eliminarSocio(Integer.parseInt(textFieldId.getText()));
		}
	}
}

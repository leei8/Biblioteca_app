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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioSocio extends JDialog {

	// Atributos
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreSocio;
	private JTextField textFieldApellidoSocio;
	private JTextField textFieldDireccionSocio;
	private JTextField textFieldProvinciaSocio;
	private JTextField textFieldPoblacionSocio;
	private JTextField textFieldDniSocio;

	// Atributo controlador y getters-setters
	private ControladorSocio controladorSocio;

	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}

	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}

	// Constructor

	public FormularioSocio(GestionSocio padre, boolean modal) {
		super(padre, modal);
		setBounds(100, 100, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(24, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup()
						.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE).addContainerGap()));
		JLabel NombreSocio = new JLabel("Nombre:");
		JLabel apellidoSocio = new JLabel("Apellido:");
		JLabel direccionSocio = new JLabel("Direccion:");
		JLabel poblacionSocio = new JLabel("Poblacion:");
		JLabel provinciaSocio = new JLabel("Provincia:");
		JLabel dniSocio = new JLabel("DNI:");

		textFieldNombreSocio = new JTextField();
		textFieldNombreSocio.setColumns(10);

		textFieldApellidoSocio = new JTextField();
		textFieldApellidoSocio.setColumns(10);

		textFieldDireccionSocio = new JTextField();
		textFieldDireccionSocio.setColumns(10);

		textFieldPoblacionSocio = new JTextField();
		textFieldPoblacionSocio.setColumns(10);

		textFieldProvinciaSocio = new JTextField();
		textFieldProvinciaSocio.setColumns(10);

		textFieldDniSocio = new JTextField();
		textFieldDniSocio.setColumns(10);

		JLabel titulo = new JLabel("INSERTAR NUEVO SOCIO");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 17));

		JButton GuardarFormularioSocio = new JButton("Guardar");
		GuardarFormularioSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorSocio.insertarSocio(textFieldNombreSocio.getText(), textFieldApellidoSocio.getText(),
						textFieldDireccionSocio.getText(), textFieldPoblacionSocio.getText(),
						textFieldProvinciaSocio.getText(), textFieldDniSocio.getText());
				controladorSocio.cerrarFormularioSocio();
			}
		});

		JButton cancelarFormularioSocio = new JButton("Cancelar");
		cancelarFormularioSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorSocio.cerrarFormularioSocio();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(90)
							.addComponent(titulo))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(NombreSocio)
								.addComponent(direccionSocio)
								.addComponent(apellidoSocio)
								.addComponent(poblacionSocio)
								.addComponent(provinciaSocio)
								.addComponent(dniSocio))
							.addGap(47)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textFieldNombreSocio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
								.addComponent(textFieldProvinciaSocio, Alignment.LEADING)
								.addComponent(textFieldDniSocio, Alignment.LEADING)
								.addComponent(textFieldApellidoSocio)
								.addComponent(textFieldDireccionSocio)
								.addComponent(textFieldPoblacionSocio))
							.addGap(56)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(GuardarFormularioSocio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cancelarFormularioSocio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(titulo)
					.addGap(28)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(textFieldNombreSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldApellidoSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(NombreSocio)
									.addGap(18)
									.addComponent(apellidoSocio)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldDireccionSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(direccionSocio))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldPoblacionSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(poblacionSocio))
							.addGap(12)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(provinciaSocio)
								.addComponent(textFieldProvinciaSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(86)
							.addComponent(GuardarFormularioSocio)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cancelarFormularioSocio)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDniSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dniSocio))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
	}

	public void limpiarFormularioSocio() {
		textFieldNombreSocio.setText("");
		textFieldApellidoSocio.setText("");
		textFieldDireccionSocio.setText("");
		textFieldPoblacionSocio.setText("");
		textFieldProvinciaSocio.setText("");
		textFieldDniSocio.setText("");
		
	}
}

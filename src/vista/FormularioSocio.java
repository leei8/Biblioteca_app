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
		super(padre,modal);
		setBounds(100, 100, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
		);
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
		
		textFieldProvinciaSocio = new JTextField();
		textFieldProvinciaSocio.setColumns(10);
		
		textFieldPoblacionSocio = new JTextField();
		textFieldPoblacionSocio.setColumns(10);
		
		textFieldDniSocio = new JTextField();
		textFieldDniSocio.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(NombreSocio)
						.addComponent(dniSocio)
						.addComponent(provinciaSocio)
						.addComponent(poblacionSocio)
						.addComponent(apellidoSocio)
						.addComponent(direccionSocio))
					.addGap(49)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldNombreSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDireccionSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldProvinciaSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDniSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldApellidoSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPoblacionSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(198, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(NombreSocio)
						.addComponent(textFieldNombreSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(apellidoSocio)
						.addComponent(textFieldApellidoSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(direccionSocio)
						.addComponent(textFieldDireccionSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(poblacionSocio)
						.addComponent(textFieldPoblacionSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(provinciaSocio)
						.addComponent(textFieldProvinciaSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(dniSocio)
						.addComponent(textFieldDniSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
	}
}

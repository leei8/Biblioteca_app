package vista;

import controlador.ControladorSocio;
import modelo.Socio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaSocio extends JDialog {

	private ControladorSocio controladorSocio;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private final JLabel lblNombre = new JLabel("Nombre:");
	private JTextField textFieldNombre;
	private final JButton botonBusqueda = new JButton("");

	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}

	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}

	public ConsultaSocio(GestionSocio gestionSocio, boolean modal) {
		super(gestionSocio, modal);
		botonBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldNombre.getText();
				controladorSocio.rellenarTablaSelectNombre(nombre);
				
			}
		});
		botonBusqueda.setIcon(new ImageIcon("C:\\Users\\ikaslea\\Desktop\\asd.png"));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNombre)
					.addGap(18)
					.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(botonBusqueda)
					.addContainerGap(151, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNombre)
							.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(botonBusqueda))
					.addGap(128)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		table = new JTable();
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,11)); //Cabecera en negrita
		table.getTableHeader().setForeground(Color.WHITE); //Cabecera letras blancas
		table.getTableHeader().setBackground(Color.BLACK); //Cabecera con fondo negro
		scrollPane.setViewportView(table);
		contentPanel.setLayout(gl_contentPanel);
	}

	public void rellenarTabla(ArrayList<Socio> socios) {
		//Crear una tabla logica
		DefaultTableModel tableModel = new DefaultTableModel();
		//Crear la cabecera de la tabla
		Object[] cabecera = { "NOMBRE", "APELLIDO", "DIRECCION", "POBLACION", "PROVINCIA", "DNI" };
		tableModel.setColumnIdentifiers(cabecera);
		
		//Rellenar tabla de socios
		for (Socio socio : socios) {
			Object[] linea = { socio.getNombre(), socio.getApellido(), socio.getDireccion(), 
								socio.getPoblacion(), socio.getProvincia(), socio.getDni()};
			tableModel.addRow(linea);
		}
		//Rellenar tabla y darle formato grafico
		table.setModel(tableModel);
		
		//Hacer la tabla ordenable por campos y alfabeticamente
		TableRowSorter<DefaultTableModel> modeloOrdenado;
		modeloOrdenado = new TableRowSorter<DefaultTableModel>(tableModel);
		table.setRowSorter(modeloOrdenado);
	}
}

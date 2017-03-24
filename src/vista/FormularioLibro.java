package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLibro;
import controlador.ControladorSocio;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioLibro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	// Atributo controlador y getters-setters
	private ControladorLibro controladorLibro;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldNum_pag;
	

	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}

	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}

	//Constructor
	
	public FormularioLibro(GestionLibro padre, boolean modal) {
		super(padre, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblInsertarNuevoLibro = new JLabel("INSERTAR NUEVO LIBRO");
		lblInsertarNuevoLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblTitulo = new JLabel("Titulo:");
		
		JLabel lblAutor = new JLabel("Autor:");
		
		JLabel lblNumeroDePginas = new JLabel("Numero de p\u00E1ginas:");
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setColumns(10);
		
		textFieldNum_pag = new JTextField();
		textFieldNum_pag.setColumns(10);
		
		textFieldAutor = new JTextField();
		textFieldAutor.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorLibro.cerrarFormularioLibro();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addGap(96)
					.addComponent(lblInsertarNuevoLibro)
					.addContainerGap(124, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitulo)
						.addComponent(lblAutor)
						.addComponent(lblNumeroDePginas))
					.addGap(48)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textFieldAutor, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldNum_pag, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
						.addComponent(textFieldTitulo))
					.addGap(1)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInsertarNuevoLibro)
					.addGap(50)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitulo)
						.addComponent(textFieldTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAutor)
						.addComponent(textFieldNum_pag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroDePginas)
						.addComponent(textFieldAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGuardar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
	public void limpiarFormularioLibro() {
		textFieldTitulo.setText("");
		textFieldAutor.setText("");
		textFieldNum_pag.setText("");
	}
}

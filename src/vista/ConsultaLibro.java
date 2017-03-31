package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.ControladorLibro;
import modelo.Libro;

import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaLibro extends JDialog {

	// --- ATRIBUTOS

	private JComboBox comboBoxTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldNumPag;
	private ControladorLibro controladorLibro;

	// --- GETS Y SETS

	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}

	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}

	public ConsultaLibro(GestionLibro parent, boolean modal) {
		super(parent, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			getContentPane().add(tabbedPane, BorderLayout.CENTER);
			{
				JPanel panelTitulo = new JPanel();
				tabbedPane.addTab("Por titulo", null, panelTitulo, null);
				{
					comboBoxTitulo = new JComboBox();
					comboBoxTitulo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							comboBoxTituloActionPerformed();
						}
					});
				}

				textFieldAutor = new JTextField();
				textFieldAutor.setEditable(false);
				textFieldAutor.setEnabled(false);
				textFieldAutor.setColumns(10);

				textFieldNumPag = new JTextField();
				textFieldNumPag.setEditable(false);
				textFieldNumPag.setEnabled(false);
				textFieldNumPag.setColumns(10);

				JLabel lblAutor = new JLabel("Autor del libro:");

				JLabel lblNumPag = new JLabel("Numero de pags:");
				GroupLayout gl_panelTitulo = new GroupLayout(panelTitulo);
				gl_panelTitulo.setHorizontalGroup(
					gl_panelTitulo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTitulo.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_panelTitulo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelTitulo.createSequentialGroup()
									.addGap(1)
									.addGroup(gl_panelTitulo.createSequentialGroup()
										.addComponent(lblNumPag)
										.addGap(18))
									.addComponent(textFieldNumPag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelTitulo.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(comboBoxTitulo, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(Alignment.LEADING, gl_panelTitulo.createSequentialGroup()
										.addComponent(lblAutor)
										.addGap(28)
										.addComponent(textFieldAutor, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(115, Short.MAX_VALUE))
				);
				gl_panelTitulo.setVerticalGroup(
					gl_panelTitulo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTitulo.createSequentialGroup()
							.addGap(34)
							.addComponent(comboBoxTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addGroup(gl_panelTitulo.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAutor))
							.addGap(18)
							.addGroup(gl_panelTitulo.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldNumPag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumPag))
							.addContainerGap(84, Short.MAX_VALUE))
				);
				panelTitulo.setLayout(gl_panelTitulo);
			}
			{
				JPanel panelAutor = new JPanel();
				tabbedPane.addTab("Por autor", null, panelAutor, null);
			}
			{
				JPanel panelNumPag = new JPanel();
				tabbedPane.addTab("Por numero de paginas", null, panelNumPag, null);
			}
		}
	}

	public void rellenarComboLibros(ArrayList<Libro> libros) {
		
		DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (Libro libro : libros) {
			defaultComboBoxModel.addElement(libro.getId() + ": " + libro.getTitulo());
		}
		defaultComboBoxModel.setSelectedItem("Elige el titulo del libro...");
		this.comboBoxTitulo.setModel(defaultComboBoxModel);

	
//		for (Libro libro : libros) {
//			this.comboBoxTitulo.addItem(libro.getId() + ": " + libro.getTitulo());
//		}
//		this.comboBoxTitulo.setSelectedIndex(-1);
	}

	protected void comboBoxTituloActionPerformed() {

		String item = this.comboBoxTitulo.getSelectedItem().toString();
		String[] partes = item.split(":");
		int idLibro = Integer.parseInt(partes[0]);

		controladorLibro.rellenarPorTitulo(idLibro);
	}

	public void llenarPestanaTitulo(Libro libro) {
		this.textFieldAutor.setText(libro.getAutor());
		this.textFieldNumPag.setText(String.valueOf(libro.getNum_pag()));

	}
}

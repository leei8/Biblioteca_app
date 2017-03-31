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
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JCheckBox;

public class ConsultaLibro extends JDialog {

	// --- ATRIBUTOS

	private JComboBox comboBoxTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldNumPag;
	private ControladorLibro controladorLibro;
	private JComboBox comboBoxAutor;
	private JList listLibros;

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
				gl_panelTitulo
						.setHorizontalGroup(
								gl_panelTitulo.createParallelGroup(Alignment.LEADING).addGroup(gl_panelTitulo
										.createSequentialGroup().addGap(31).addGroup(gl_panelTitulo
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelTitulo.createSequentialGroup()
														.addGap(1)
														.addGroup(gl_panelTitulo.createSequentialGroup()
																.addComponent(lblNumPag).addGap(18))
														.addComponent(textFieldNumPag, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panelTitulo.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(comboBoxTitulo, Alignment.LEADING, 0,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(Alignment.LEADING,
																gl_panelTitulo.createSequentialGroup()
																		.addComponent(lblAutor).addGap(28)
																		.addComponent(textFieldAutor,
																				GroupLayout.PREFERRED_SIZE, 183,
																				GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(115, Short.MAX_VALUE)));
				gl_panelTitulo.setVerticalGroup(gl_panelTitulo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTitulo.createSequentialGroup().addGap(34)
								.addComponent(comboBoxTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(37)
								.addGroup(gl_panelTitulo.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFieldAutor, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAutor))
								.addGap(18)
								.addGroup(gl_panelTitulo.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFieldNumPag, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNumPag))
								.addContainerGap(84, Short.MAX_VALUE)));
				panelTitulo.setLayout(gl_panelTitulo);
			}
			{
				JPanel panelAutor = new JPanel();
				tabbedPane.addTab("Por autor", null, panelAutor, null);

				comboBoxAutor = new JComboBox();
				comboBoxAutor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						comboBoxAutorActionPerformed();
					}
				});

				listLibros = new JList();

				JLabel lblLibrosEscritos = new JLabel("Libros escritos");

				JLabel lblAutor = new JLabel("Autor:");
				GroupLayout gl_panelAutor = new GroupLayout(panelAutor);
				gl_panelAutor.setHorizontalGroup(
					gl_panelAutor.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelAutor.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelAutor.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelAutor.createSequentialGroup()
									.addGroup(gl_panelAutor.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAutor)
										.addComponent(comboBoxAutor, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
									.addGap(39)
									.addComponent(listLibros, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(Alignment.TRAILING, gl_panelAutor.createSequentialGroup()
									.addComponent(lblLibrosEscritos)
									.addGap(85))))
				);
				gl_panelAutor.setVerticalGroup(
					gl_panelAutor.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelAutor.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLibrosEscritos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelAutor.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelAutor.createSequentialGroup()
									.addComponent(lblAutor)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(162))
								.addGroup(gl_panelAutor.createSequentialGroup()
									.addGap(6)
									.addComponent(listLibros, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
				);
				panelAutor.setLayout(gl_panelAutor);
			}
			{
				JPanel panelNumPag = new JPanel();
				tabbedPane.addTab("Por numero de paginas", null, panelNumPag, null);
				
				JCheckBox checkBoxMenorCien = new JCheckBox("< 100");
				
				JCheckBox checkBoxEntreCienQuinientos = new JCheckBox("100 - 500");
				
				JCheckBox checkBoxMayotQuinientos = new JCheckBox("> 500");
				
				JList list = new JList();
				GroupLayout gl_panelNumPag = new GroupLayout(panelNumPag);
				gl_panelNumPag.setHorizontalGroup(
					gl_panelNumPag.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNumPag.createSequentialGroup()
							.addGroup(gl_panelNumPag.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelNumPag.createSequentialGroup()
									.addGap(58)
									.addComponent(checkBoxMenorCien)
									.addGap(48)
									.addComponent(checkBoxEntreCienQuinientos)
									.addGap(40)
									.addComponent(checkBoxMayotQuinientos))
								.addGroup(gl_panelNumPag.createSequentialGroup()
									.addGap(25)
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(57, Short.MAX_VALUE))
				);
				gl_panelNumPag.setVerticalGroup(
					gl_panelNumPag.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNumPag.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_panelNumPag.createParallelGroup(Alignment.BASELINE)
								.addComponent(checkBoxMenorCien)
								.addComponent(checkBoxMayotQuinientos)
								.addComponent(checkBoxEntreCienQuinientos))
							.addGap(18)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(28, Short.MAX_VALUE))
				);
				panelNumPag.setLayout(gl_panelNumPag);
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

		// for (Libro libro : libros) {
		// this.comboBoxTitulo.addItem(libro.getId() + ": " +
		// libro.getTitulo());
		// }
		// this.comboBoxTitulo.setSelectedIndex(-1);
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

	public void rellenarComboAutores(ArrayList<String> autores) {
		DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (String autor : autores) {
			defaultComboBoxModel.addElement(autor);
		}
		defaultComboBoxModel.setSelectedItem("Elige uno");
		this.comboBoxAutor.setModel(defaultComboBoxModel);

	}

	protected void comboBoxAutorActionPerformed() {
		String autor = this.comboBoxAutor.getSelectedItem().toString();
		controladorLibro.rellenarPorAutor(autor);

	}

	public void llenarListaLibrosAutor(ArrayList<Libro> librosAutor) {
		DefaultListModel defaultListModel = new DefaultListModel();
		for (Libro libro : librosAutor) {
			defaultListModel.addElement(libro.getTitulo() + " - " + libro.getNum_pag());

			this.listLibros.setModel(defaultListModel);
		}
	}
}

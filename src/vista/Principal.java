package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorSocio;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class Principal extends JFrame {

	private JPanel contentPane;
	private ControladorSocio controladorSocio;
	

	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}

	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelIcon = new JLabel("");
		labelIcon.setVerticalAlignment(SwingConstants.BOTTOM);
		labelIcon.setIcon(new ImageIcon("C:\\Users\\ikaslea\\Desktop\\libros.jpg"));
		
		JButton botonGestionLibros = new JButton("GESTION LIBROS");
		
		JButton botonGestionSocios = new JButton("GESTION SOCIOS");
		
		JButton botonPrestamos = new JButton("PRESTAMOS");
		
		JLabel labelBiblioteca = new JLabel("BIBLIOTECA");
		labelBiblioteca.setToolTipText("");
		labelBiblioteca.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(labelBiblioteca))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(botonGestionLibros))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(botonGestionSocios))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(botonPrestamos)))
					.addGap(14)
					.addComponent(labelIcon, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(labelBiblioteca, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addComponent(botonGestionLibros)
					.addGap(31)
					.addComponent(botonGestionSocios)
					.addGap(28)
					.addComponent(botonPrestamos)
					.addGap(24))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(labelIcon, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

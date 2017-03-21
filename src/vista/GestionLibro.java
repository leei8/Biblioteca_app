package vista;
import controlador.*;
import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionLibro extends JDialog {
	// Atributos
	private final JPanel contentPanel = new JPanel();
	private ControladorLibro controladorLibro;

	// Getters y setters
	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}

	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}

	public GestionLibro(Principal principal, boolean modal) {
		super(principal, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JButton botonAnadirLibro = new JButton("A\u00F1adir libro");
		botonAnadirLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorLibro.abrirFormularioLibro();
			}
		});
		
		JButton botonEliminarLibro = new JButton("Eliminar libro");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(153)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(botonEliminarLibro)
						.addComponent(botonAnadirLibro))
					.addContainerGap(182, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(24)
					.addComponent(botonAnadirLibro)
					.addGap(34)
					.addComponent(botonEliminarLibro)
					.addContainerGap(147, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}

package Vistas;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controlador.ControlladorMenu;
import Vistas.Menu;

import javax.swing.SwingConstants;

public class VistaInicio extends JPanel {


	public VistaInicio() {
		setLayout(null);
		
		//ETIQUETAS
		JLabel label = new JLabel("Productos");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(30, 68, 364, 21);
		add(label);
		
		
		//BOTONES
		//BOTON AÑADIR PRODUCTO
		JButton btnañadirpro = new JButton("A\u00F1adir");
		//ACCION DEL BOTON
		btnañadirpro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ControlladorMenu.getInstance().showAñadirProductos();
					}
		
		});
		btnañadirpro.setBackground(new Color(100, 149, 237));
		btnañadirpro.setBounds(30, 100, 165, 37);
		add(btnañadirpro);
		//BOTON MODIFICAR PRODUCTO
		JButton btnmodificarpro = new JButton("Modificar");
		btnmodificarpro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlladorMenu.getInstance().showModificarProductos();
			}
		});
		btnmodificarpro.setBackground(new Color(100, 149, 237));
		btnmodificarpro.setBounds(239, 100, 165, 37);
		add(btnmodificarpro);
		//BOTON CONSULTAR PRODUCTO
		JButton btnconsultarpro = new JButton("Consultar");
		btnconsultarpro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlladorMenu.getInstance().showConsultarProductos();
			}
		});
		btnconsultarpro.setBackground(new Color(100, 149, 237));
		btnconsultarpro.setBounds(239, 148, 165, 37);
		add(btnconsultarpro);
		//BOTON ELIMINAR PRODUCTO
		JButton btneliminarpro = new JButton("Eliminar ");
		btneliminarpro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlladorMenu.getInstance().showEliminarProducto();
			}
		});
		btneliminarpro.setBackground(new Color(100, 149, 237));
		btneliminarpro.setBounds(30, 148, 165, 37);
		add(btneliminarpro);
		//BOTON SALIR
		JButton btnsalir = new JButton("Salir");
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //ACCION DEL BOTON
				System.exit(0);
			}
		});
		btnsalir.setBounds(82, 290, 269, 30);
		add(btnsalir);

	}

}

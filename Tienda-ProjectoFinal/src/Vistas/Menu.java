package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;




import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.SwingConstants;

import Controlador.ControlladorMenu;
import VistasProductos.AñadirProductos;
import VistasProductos.ModificarProductos;
import VistasProductos.EliminarProducto;

import java.awt.Font;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private VistaInicio VistaInicio;
	private VistaInicioSesion VistaInicioSesion;
	private VistasProductos.AñadirProductos AñadirProductos;
	private VistasProductos.ModificarProductos ModificarProductos;
	private VistasProductos.EliminarProducto EliminarProducto;
	private VistasProductos.ConsultarProductos ConsultarProductos;
	private static JTextField mensajes;
	private JMenuItem menuItem;

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//MENU
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//IR A PANTALLA INICIAL
		JMenu mnInicio = new JMenu(new AbstractAction("Inicio"){
		public void actionPerformed(ActionEvent ae) {
		    }
		});
		menuBar.add(mnInicio);
		
		menuItem = new JMenuItem(new AbstractAction("IR A INICIO"){
			public void actionPerformed(ActionEvent ae) {
				 ControlladorMenu.getInstance().showVistaInicio();
				 mensaje("Has vuelto al menú");
			    }
			});
		mnInicio.add(menuItem);
		
		
		JMenu Productos = new JMenu("Productos");
		menuBar.add(Productos);
		
		
		JMenuItem Añadir = new JMenuItem(new AbstractAction("Añadir"){
		public void actionPerformed(ActionEvent ae) {
			 ControlladorMenu.getInstance().showAñadirProductos();
			 mensaje("Añada un producto");
		    }
		});
		Productos.add(Añadir);
		
		JMenuItem Eliminar = new JMenuItem(new AbstractAction("Eliminar"){
			public void actionPerformed(ActionEvent ae) {
				 ControlladorMenu.getInstance().showEliminarProducto();
				 mensaje("Elimine un producto");
			    }
			});
		Productos.add(Eliminar);
		
		JMenuItem Modificar = new JMenuItem(new AbstractAction("Modificar"){
			public void actionPerformed(ActionEvent ae) {
				 ControlladorMenu.getInstance().showModificarProductos();
				 mensaje("Modifique un producto");
			    }
			});
		Productos.add(Modificar);
		
		JMenuItem Consultar = new JMenuItem(new AbstractAction("Consultar"){
			public void actionPerformed(ActionEvent ae) {
				 ControlladorMenu.getInstance().showConsultarProductos();
				 mensaje("Consulte un producto");
			    }
			});
		Productos.add(Consultar);
		

		//Contenedor de Ventanas
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		
		//AÑADIMOS LAS VENTANAS
		//VENTANA INICIOSESION
		VistaInicioSesion = new VistaInicioSesion();
		panel.add(VistaInicioSesion,"VistaInicioSesion");
		//VENTANA MENU
		VistaInicio = new VistaInicio();
		panel.add(VistaInicio,"VistaInicio");
		//VENTANA AÑADIR PRODUCTOS
		AñadirProductos = new VistasProductos.AñadirProductos();
		panel.add(AñadirProductos,"AñadirProductos");
		//VENTANA MODIFICAR PRODUCTOS
		ModificarProductos = new VistasProductos.ModificarProductos();
		panel.add(ModificarProductos,"ModificarProductos");
		//VENTANA ELIMINAR PRODUCTOS
		EliminarProducto = new VistasProductos.EliminarProducto();
		panel.add(EliminarProducto,"EliminarProducto");
		//VENTANA CONSULTAR PRODUCTOS
		ConsultarProductos = new VistasProductos.ConsultarProductos();
		panel.add(ConsultarProductos,"ConsultarProductos");
		
		//Añadimos componente de mensajes
		mensajes = new JTextField();
		mensajes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mensajes.setHorizontalAlignment(SwingConstants.CENTER);
		mensajes.setEditable(false);
		contentPane.add(mensajes, BorderLayout.SOUTH);
	}
	
	public void showInicial(ArrayList<String> usuarios){
		this.VistaInicioSesion.putUsuarios(usuarios);
	}
	

	
	//MOSTRAR LOS DIFERENTES PANELES
	public void showVistaInicioSesion(){
		CardLayout c= (CardLayout) this.panel.getLayout();
		c.show(panel, "VistaInicioSesion");
	}
	
	public void showVistaInicio(){
		CardLayout c= (CardLayout) this.panel.getLayout();
		c.show(panel, "VistaInicio");
		
	}
	
	public void showAñadirProductos(){
		CardLayout c= (CardLayout) this.panel.getLayout();
		c.show(panel, "AñadirProductos");
	}
	public void showModificarProductos(){
	CardLayout c= (CardLayout) this.panel.getLayout();
	c.show(panel, "ModificarProductos");
}
	
	public void showEliminarProducto(){
		CardLayout c= (CardLayout) this.panel.getLayout();
		c.show(panel, "EliminarProducto");
	}
	public void showConsultarProductos(){
		CardLayout c= (CardLayout) this.panel.getLayout();
		c.show(panel, "ConsultarProductos");
	}
	
	
	//PANEL DEL MENSAJE
	public static void mensaje(String msj){
		mensajes.setText(msj);
	}

}


package VistasProductos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Controlador.ControlladorMenu;
import Model.ConexionDB;
import Vistas.Menu;

public class AñadirProductos extends JPanel {
	
	private JTextField CjaNumero;
	private JTextField CjaNombre;
	private JTextField CjaPrecio;
	public String nombre,aux,aux2;
	public int numero,precio;
	private ConexionDB ConexionDB;
	private Menu menu;
	private JButton btnGuardar,btnVolver;
	private PreparedStatement bbdd;
	private Connection con;
	private JLabel label,label_1,label_2;
	
	
	public AñadirProductos() {
		setLayout(null);
		//Creamos la conexion con la base de datos
				ConexionDB=ConexionDB.getInstance();
			
		//ETIQUETAS
		label = new JLabel("N\u00BA del producto:");
		label.setBounds(10, 14, 108, 14);
		add(label);
		label_1 = new JLabel("Nombre:");
		label_1.setBounds(10, 51, 60, 14);
		add(label_1);
		label_2 = new JLabel("Precio:");
		label_2.setBounds(10, 82, 60, 14);
		add(label_2);
		
		//CAJAS
		CjaNumero = new JTextField();
		CjaNumero.setColumns(10);
		CjaNumero.setBounds(128, 11, 34, 20);
		add(CjaNumero);
		
		CjaNombre = new JTextField();
		CjaNombre.setColumns(10);
		CjaNombre.setBounds(66, 48, 107, 20);
		add(CjaNombre);
		
		CjaPrecio = new JTextField();
		CjaPrecio.setColumns(10);
		CjaPrecio.setBounds(66, 79, 73, 20);
		add(CjaPrecio);
		
		
		//BOTONES
		//BOTON GUARDAR
		btnGuardar = new JButton("Guardar");
		
		btnGuardar.addActionListener(new ActionListener() { //ActionListener para cuando se presione el boton guardar
			public void actionPerformed(ActionEvent e) { //Creando metodo
				
				// Recogiendo datos de los campos de texto
			aux=CjaNumero.getText();
			numero=Integer.parseInt(aux);
			nombre=CjaNombre.getText();
			aux2=CjaPrecio.getText();
			precio=Integer.parseInt(aux2);
				
				con=ConexionDB.getConexion(); //Estableciendo la conexion
				try{
					bbdd=con.prepareStatement("insert into productos(Numproducto,Nombre,Precio) values(?,?,?)"); //Codigo para insertar valores en sql
					
					bbdd.setInt(1,numero); //Mandando los valores al codigo sql
					bbdd.setString(2,nombre);
					bbdd.setInt(3,precio); 
					bbdd.executeUpdate(); //Ejecutando actualizacion (actualizando)
				
				}catch(SQLException a){ //Si surge un error
					menu.mensaje("Ha surgido un error");
				}
				menu.mensaje("Ha sido añadido " + nombre + " a la base de datos");
				
			}
		});
		btnGuardar.setBounds(73, 125, 89, 23);
		add(btnGuardar);
		
		//BOTON VOLVER
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				ControlladorMenu.getInstance().showVistaInicio();
				menu.mensaje("Has vuelto al menú");
				

}});
		btnVolver.setBounds(183, 125, 89, 23);
		add(btnVolver);
	}

			
	}

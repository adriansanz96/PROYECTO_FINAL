package VistasProductos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Controlador.ControlladorMenu;
import Model.ConexionDB;
import Vistas.Menu;
import Vistas.VistaInicio;

public class ModificarProductos extends JPanel {
	private JTextField Mnumero;
	private JTextField Mnombre;
	private JTextField Mprecio;
	public String nombre,aux,aux2,aux3;
	public int numero,precio,buscar;
	private Connection con;
	private PreparedStatement bbdd;
	private JButton btnBuscar,btnRegresar,btnGuardar;
	private ResultSet rs;
	
	private Menu menu;
	private ConexionDB ConexionDB;
	
	
	public ModificarProductos() {
		
		setLayout(null);
		
		//Creamos la conexion con la base de datos
				ConexionDB=ConexionDB.getInstance();
		
				
		//ETIQUETAS
		JLabel label = new JLabel("N\u00BA del producto:");
		label.setBounds(10, 14, 107, 14);
		add(label);
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(10, 55, 59, 14);
		add(label_1);
		JLabel label_2 = new JLabel("Precio:");
		label_2.setBounds(10, 82, 59, 14);
		add(label_2);
		
		//CAJAS
		
		Mnumero = new JTextField();
		Mnumero.setColumns(10);
		Mnumero.setBounds(102, 11, 34, 20);
		add(Mnumero);
		
		Mnombre = new JTextField();
		Mnombre.setColumns(10);
		Mnombre.setBounds(66, 52, 107, 20);
		add(Mnombre);
		
		Mprecio = new JTextField();
		Mprecio.setColumns(10);
		Mprecio.setBounds(66, 79, 73, 20);
		add(Mprecio);
		
		
		//BOTONES
		//BOTON GUARDAR
		btnGuardar = new JButton("Guardar");
		
		btnGuardar.addActionListener(new ActionListener() { //ActionListener para cuando se presione el boton guardar
			public void actionPerformed(ActionEvent e) { //Creando metodo
				
				// Recogiendo datos de los campos de texto
				aux=Mnumero.getText();
				numero=Integer.parseInt(aux);
				nombre=Mnombre.getText(); 
				aux2=Mprecio.getText();
				precio=Integer.parseInt(aux2);
				
				Connection con=ConexionDB.getConexion(); //Estableciendo la conexion
				try{
					PreparedStatement bbdd=con.prepareStatement("update productos set Nombre=?,Precio=? where Numproducto=?"); //Codigo para insertar valores en sql
					
				//Mandando los valores al codigo sql
				bbdd.setString(1,nombre);
				bbdd.setInt(2,precio);
				bbdd.setInt(3,numero);
				bbdd.executeUpdate(); //Ejecutando actualizacion (actualizando)
				
				}catch(SQLException a){ //Si surge un error
					menu.mensaje("Ha surgido un error");
				}
				menu.mensaje("Ha sido modificado " + nombre + " en la base de datos");
			}
		});
		btnGuardar.setBounds(66, 110, 89, 23);
		add(btnGuardar);
		
		//BOTON BUSCAR
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				aux3=Mnumero.getText();
				buscar=Integer.parseInt(aux3);
				
				
				con=ConexionDB.getConexion();
				try{
					bbdd=con.prepareStatement(" select * from productos where Numproducto=?;");//Codigo sql
					bbdd.setInt(1,buscar);
					rs=bbdd.executeQuery(); //Ejecutando consulta
					if(rs.next()){
						//Recogiendo datos
						nombre=rs.getString("Nombre");
						precio=rs.getInt("Precio");
						numero=rs.getInt("Numproducto");
					
						
					}else{
						menu.mensaje("No existe ningún producto con ese número"); //Por si no existe matricula
					}
				}catch(SQLException y){
					menu.mensaje("ERROR");
				}
				Mnumero.setText(""+numero);
				Mnombre.setText(nombre);
				Mprecio.setText(""+precio);
			}
		});
			
		btnBuscar.setBounds(151, 10, 89, 23);
		add(btnBuscar);
		
		//BOTON REGRESAR
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent e) {
			ControlladorMenu.getInstance().showVistaInicio();
			menu.mensaje("Has vuelto al menú");
	

}});

		btnRegresar.setBounds(250, 10, 89, 23);
		add(btnRegresar);

		
		

	}

			
	}

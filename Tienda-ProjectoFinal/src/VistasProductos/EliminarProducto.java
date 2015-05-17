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

public class EliminarProducto extends JPanel {
	private JTextField Cjaeliminar;
	public int eliminar;
	public String aux;
	private Menu menu;
	private ConexionDB ConexionDB;
	/**
	 * Create the panel.
	 */
	public EliminarProducto() {
		
		setLayout(null);
		
		//Creamos la conexion con la base de datos
				ConexionDB=ConexionDB.getInstance();
		//ETIQUETA
		JLabel lblTecelaElNmero = new JLabel("Tecela el n\u00FAmero del producto que quieres eliminar:");
		lblTecelaElNmero.setBounds(33, 21, 323, 14);
		add(lblTecelaElNmero);
		//CAJA
		Cjaeliminar = new JTextField();
		Cjaeliminar.setColumns(10);
		Cjaeliminar.setBounds(33, 46, 86, 20);
		add(Cjaeliminar);
		
		JButton btnEliminar = new JButton("Eliminar");
		
		btnEliminar.addActionListener(new ActionListener() {//ActionListener para cuando se presione el boton consultar
			public void actionPerformed(ActionEvent e) {//Creando metodo
				Connection con=ConexionDB.getConexion(); //Estableciendo la conexion
				//ACCION
				try{
					PreparedStatement bbdd=con.prepareStatement("delete from productos where Numproducto=?"); //Codigo sql
					try{
						aux=Cjaeliminar.getText();
						eliminar=Integer.parseInt(aux); // Convertiendo
					}catch(Exception a){
						menu.mensaje("Error de captura");
					}
					bbdd.setInt(1, eliminar); //mandando numero al codigo sql
					bbdd.executeUpdate();
				}catch(SQLException r){
					menu.mensaje("Error");
					}
				menu.mensaje("Ha sido eliminado el producto " + eliminar + " de la base de datos");
			}
		});
		btnEliminar.setBounds(138, 45, 89, 23);
		add(btnEliminar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ControlladorMenu.getInstance().showVistaInicio();
					menu.mensaje("Has vuelto al menú");
		}});
			
		btnRegresar.setBounds(267, 46, 89, 23);
		add(btnRegresar);

	}
}

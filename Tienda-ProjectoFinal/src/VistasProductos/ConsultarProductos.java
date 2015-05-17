package VistasProductos;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Controlador.ControlladorMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Vistas.Menu;
import Model.ConexionDB;
public class ConsultarProductos extends JPanel {
	private JTextField CjaPrecio;
	private JTextField CjaNombre;
	private JTextField CjaNumero;
	private Menu menu;
	private ConexionDB ConexionDB;
	public String nombre,aux,aux2;
	public int numero,precio,consultar;
	private ResultSet rs;
	private PreparedStatement bbdd;
	
	
	public ConsultarProductos() {
		setLayout(null);
		
		//Creamos la conexion con la base de datos
		ConexionDB=ConexionDB.getInstance();
		
		//ETIQUETAS
		JLabel label = new JLabel("Precio:");
		label.setBounds(75, 101, 59, 14);
		add(label);
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(75, 70, 59, 14);
		add(label_1);
		JLabel label_2 = new JLabel("N\u00BA del producto:");
		label_2.setBounds(75, 15, 107, 14);
		add(label_2);
		
		//CAJAS
		CjaNombre = new JTextField();
		CjaNombre.setEditable(false);
		CjaNombre.setColumns(10);
		CjaNombre.setBounds(144, 67, 107, 20);
		add(CjaNombre);
		
		CjaPrecio = new JTextField();
		CjaPrecio.setEditable(false);
		CjaPrecio.setColumns(10);
		CjaPrecio.setBounds(144, 98, 73, 20);
		add(CjaPrecio);
		
		CjaNumero = new JTextField();
		CjaNumero.setColumns(10);
		CjaNumero.setBounds(178, 12, 34, 20);
		add(CjaNumero);
		
		

		JButton bntConsultar = new JButton("Consultar");
		bntConsultar.addActionListener(new ActionListener() {
			//ACCION DEL BOTON
			public void actionPerformed(ActionEvent e) {
				aux=CjaNumero.getText(); 
				consultar=Integer.parseInt(aux);
				Connection con=ConexionDB.getConexion(); //Estableciendo la conexion
				try{
					bbdd=con.prepareStatement(" select * from productos where Numproducto=?;");//Codigo sql
					bbdd.setInt(1,consultar);
					rs=bbdd.executeQuery(); //Ejecutando consulta
					if(rs.next()){
						nombre=rs.getString("Nombre");//Recogiendo datos
						precio=rs.getInt("Precio");
						
						
					}else{
						menu.mensaje("No existe ningún producto con ese número");
					}
				}catch(SQLException y){
					menu.mensaje("ERROR");
				}
				CjaNombre.setText(nombre);
				CjaPrecio.setText(""+precio);
				
			}
		});
		bntConsultar.setBounds(258, 11, 89, 23);
		add(bntConsultar);
		
		JButton BtnRegresar = new JButton("Regresar");
		BtnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlladorMenu.getInstance().showVistaInicio();
				menu.mensaje("Has vuelto al menú");
			}
		});
		BtnRegresar.setBounds(144, 145, 89, 23);
		add(BtnRegresar);

	}

}

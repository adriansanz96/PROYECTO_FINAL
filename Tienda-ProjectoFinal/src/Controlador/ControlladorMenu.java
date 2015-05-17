package Controlador;

import java.awt.CardLayout;
import java.util.ArrayList;
import Model.ConexionDB;
import Model.User;
import Model.UsuariosModel;
import Vistas.Menu;
import Vistas.VistaInicio;
import Vistas.VistaInicioSesion;


public class ControlladorMenu {
	
	//Instancia unica
	private static ControlladorMenu instance = null;
	//Atributos de bases de datos
	ConexionDB conexion;
	
	//Ventana Menu
	private Menu menu;
	//Ventana de Inicio de Sesion
	private VistaInicioSesion inicio;
	//Autenticador
	private Autenticar auth;
	private User usuarioRegistrado=null;

	private ControlladorMenu() {
		//CARGAR LA BASE DE DATOS
		conexion=ConexionDB.getInstance("localhost","tienda","root","121esp9.X"); //DATOS DE INICIO DE SESIÓN //AÑADIR CONTRASEÑA
		if(conexion.connectDB()==true) {
			System.out.println("CONECTADO A LA BASE DE DATOS");
		}else{
			System.out.println("ERROR EN LA CONEXION");
		}
		//CARGAR LA AUTENTICACIÓN
		auth=new Autenticar();
		
		this.showMain();
	}
	
	
	//Implementa SingleTon
	public static ControlladorMenu getInstance() {
	      if(instance == null) {
	         instance = new ControlladorMenu();
	      }
	      return instance;
	}
	
	//LANZAR VISTA INICIO SESION
	public void showMain(){
		//Consultamos los usuarios
		UsuariosModel uModel=new UsuariosModel();
		ArrayList<String> usuarios=uModel.getUsuarios();
		//Lanzamos la ventana principal
		menu = new Menu();
		//Cargamos datos de Usuarios
		menu.showInicial(usuarios);
		//Hacemos visible la pantalla inicial
		menu.setVisible(true);
	}
	
	//LANZAR VENTANA MENU("VISTAINICIO")
	public void showVistaInicio(){
		if(usuarioRegistrado==null){
			menu.mensaje("No puedes entrar si no inicias sesión");
		}else{
			menu.showVistaInicio();
			menu.mensaje("Ventana Menú");
		}
	}

	//LANZAR VENTANA AÑADIR PRODUCTO
	public void showAñadirProductos(){
		menu.showAñadirProductos();
		menu.mensaje("Añada un producto");
	}
	
	//LANZAR VENTANA MODIFICAR PRODUCTO
	public void showModificarProductos(){
		menu.showModificarProductos();
		menu.mensaje("Modifica un producto");
	}
	
	
	//LANZAR VENTANA ELIMINAR PRODUCTO
	public void showEliminarProducto(){
		menu.showEliminarProducto();
		menu.mensaje("Elimine un producto");
	}
	
	//LANZAR VENTANA CONSULTA PRODUCTO
		public void showConsultarProductos(){
			menu.showConsultarProductos();
			menu.mensaje("Consultar un producto");
		}
	
	//COMPROBACION DE USUARIOS
	public void checkUser(String usuario,char[] Contrasena){
		usuarioRegistrado=new User();
		menu.mensaje("Ventana Menú");
		menu.showVistaInicio();
		
		
	}
}

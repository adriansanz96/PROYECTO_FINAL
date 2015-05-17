package Model;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class ConexionDB {
	// DATOS DE LA CONEXION
	public String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
	
	//DATOS DE LA BBD
	private String host, bbdd, user, pass,url;
	
	//DATOS POR DEFECTO
	private static final String HOST="localhost";
	private static final String BBDD="tienda";
	private static final String USER="root";
	private static final String PASS="121esp9.X"; //AÑADIR CONTRASEÑA
	
	//CONEXION
	Connection conexion = null;
	
	//INSTANCIA ÚNICA
	private static ConexionDB instance = null;
	
	private ConexionDB(String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
	}
	
	//APLICAR SINGLETON
	public static ConexionDB getInstance(String HOST,String BBDD,String USER,String PASS) {
	      if(instance == null) {
	         instance = new ConexionDB(HOST,BBDD,USER,PASS);
	      }
	      return instance;
	   }
	
	public static ConexionDB getInstance() {
	      if(instance == null) {
	         instance = new ConexionDB(ConexionDB.HOST,ConexionDB.BBDD,ConexionDB.USER,ConexionDB.PASS);
	      }
	      return instance;
	  }
	
	public boolean connectDB(){
		try{
			//Lo primero es cargar el controlador MySQL el cual automáticamente se registra
			Class.forName(CONTROLADOR_MYSQL);
			//CONECTARNOS A LA BBDD
			conexion = DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return false;
		}
		catch( ClassNotFoundException noEncontroClase)
		{
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Connection getConexion(){
		return this.conexion;
	}

}


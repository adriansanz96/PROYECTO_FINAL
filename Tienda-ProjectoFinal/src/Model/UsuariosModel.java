package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuariosModel {
	//Atributos de bases de datos
	ConexionDB conexionbbdd;
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;
	
	//Consultas SQL
	private static String ADMINISTRADORES_LIST="SELECT administradores FROM administradores";
	
	
	public UsuariosModel() {
		//Creamos la conexion con la base de datos
		conexionbbdd=ConexionDB.getInstance();
	}
	
	//Devolucion de los usuaios
	public ArrayList<String> getUsuarios(){
		ArrayList<String> usuarios=new ArrayList<String>();
		try{
			//Preparamos la peticion
			instruccion = conexionbbdd.getConexion().createStatement();
			conjuntoResultados = instruccion.executeQuery(ADMINISTRADORES_LIST);
			//Recorremos los resultados y los almacenamos en un ArrayList
			//Listaremos por pantalla los datos
			while( conjuntoResultados.next() ) {
				usuarios.add(conjuntoResultados.getString("administradores"));
			}// fin de while
		}catch( SQLException excepcionSql ) {
			excepcionSql.printStackTrace();
		}		finally{
			try{
				conjuntoResultados.close();
				instruccion.close();
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
		return usuarios;
	}

}

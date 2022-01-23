package eus.ehu.adsi.arkanoid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.*;
import Conecta.sqliteConnection;

public class GestorPuntos {
	
	private static GestorPuntos mGestorPuntos;
	private GestorPuntos() {}
	
	public static GestorPuntos getMiGestorPuntos() {
		if (mGestorPuntos==null) {
			mGestorPuntos = new GestorPuntos();
		}
		return mGestorPuntos;
	}
	
	
	//Obtiene las puntuaciones absolutas de la BD
	//true para ranking personal
	//false para ranking global
	public JSONObject obtenerPuntuacionesAbs(Boolean personal) throws SQLException, JSONException {
		Connection connection =null;
		connection= sqliteConnection.dbConnector();

		String query = "";
		String user = Controlador.getControlador().getUsuario();

		
		if (personal == true) {            //personal
			query = "select * from ranking where nombreU=='"+user+"'"+"order by puntuacion desc";
		
		} else if (personal == false) {    //global
			query = "select * from ranking order by puntuacion desc";
		}

		Statement stm = connection.createStatement();
		ResultSet resul = stm.executeQuery(query);

		return procesarJSON(resul);
	}
	
	
	
	
	//Obtiene las puntuaciones por niveles de la BD
	//true para ranking personal
	//false para ranking global
	public JSONObject obtenerPuntuacionesNiv(Boolean personal) throws SQLException, JSONException {
		Connection connection =null;
		connection= sqliteConnection.dbConnector();

		String query = "";
		String user = Controlador.getControlador().getUsuario();

		if (personal == true) {  //personal
			query = "select * from ranking where nombreU=='"+user+"'"+"order by nivel asc, puntuacion desc";
		
		} else if (personal == false) { //global
			query = "select * from ranking order by nivel asc, puntuacion desc";
		}

		Statement stm = connection.createStatement();
		ResultSet resul = stm.executeQuery(query);
		
		return procesarJSON(resul);
	}
	
	
	private JSONObject procesarJSON(ResultSet resul) throws SQLException, JSONException {
		JSONObject j = new JSONObject();
		int i = 0;

		while (resul.next()) {			
			JSONObject json = new JSONObject();
		
			json.put("puntuacion", resul.getString("puntuacion"));
			json.put("nombreU", resul.getString("nombreU"));
			json.put("nivel", resul.getInt("nivel"));
			j.put(Integer.toString(i), json);

			i++;
		}
		
		return j;
	}
	
	
	//Inserto la puntuación, nivel, y nombreUsuario de jugador en BD
	public void insertarPuntuacion(String nombreU, int puntuacion, int nivel) throws SQLException {
		Connection connection =null;
		connection= sqliteConnection.dbConnector(); //Conexión BD
		
		Statement stm = connection.createStatement();
		stm.executeQuery("Insert into ranking values (("+nombreU+"),("+puntuacion+"),("+nivel+")");   //inserto valores en columnas
	}
	
	
	
}

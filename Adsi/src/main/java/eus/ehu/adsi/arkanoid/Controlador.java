package eus.ehu.adsi.arkanoid;

import java.awt.Color;
import java.sql.SQLException;
import java.util.jar.JarException;

import org.json.JSONException;
import org.json.JSONObject;

import eus.ehu.adsi.arkanoid.view.Config;
import eus.ehu.adsi.arkanoid.view.ScoreBoard;

public class Controlador {
	
	private static Controlador mControlador;
	private String usuario = "Gian"; //Por defecto es Jugador1, falta la parte de iniciar sesi�n
	
	public static String usuarioIdentificado;
	
	private Controlador() {
		
	}
	
	
	public static Controlador getControlador() {
		if(mControlador==null) {
			mControlador = new Controlador();
		}
		
		return mControlador;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public JSONObject obtenerDatosPersonalizacion(String pNombreUsuario) throws JSONException {
		
		//1. Obtener el jugador de la lista de jugadores que tenga el nombre de usuario
		
		GestorJugadores gestorJugadores = GestorJugadores.getMiGestorJugadores();	
		Jugador jugador = gestorJugadores.buscarJugador(pNombreUsuario);
		
		//2. Obtener los datos de personalizaci�n del jugador buscado
		
		JSONObject datosPersonalizacion = gestorJugadores.obtenerDatosPersonalizacion(jugador);
		
		//3. Set datos de personalizacion del jugador al juego
		
		setDatosJuego(datosPersonalizacion);
		
		return datosPersonalizacion;
		
	}
	
	
	public void setDatosJuego(JSONObject pDatosPersonalizacion) throws JSONException {
		
		//FONDO
		
		int fondo = pDatosPersonalizacion.getInt("fondo");
		//System.out.println(fondo);
		switch(fondo) {
		
		case 1:
			Config.BACKGROUND_COLOR = Color.black;
			break;
			
		case 2:
			Config.BACKGROUND_COLOR = Color.white;
			break;
		
		
		case 3:
			Config.BACKGROUND_COLOR = Color.orange;
			break;
			
		case 4:
			Config.BACKGROUND_COLOR = Color.yellow;
		
		}
		
		
		//BOLA
		
		int bola = pDatosPersonalizacion.getInt("bola");
		
		switch(bola) {
		
		case 1:
			Config.BALL_COLOR = Color.red;
			break;
			
		case 2:
			Config.BALL_COLOR = Color.green;
			break;
		
		
		case 3:
			Config.BALL_COLOR = Color.pink;
			break;
			
		case 4:
			Config.BALL_COLOR = Color.blue;
		
		}
		
		
		//PADDLE
		
		int paddle = pDatosPersonalizacion.getInt("paddle");
		
		switch(paddle) {
		
		case 1:
			Config.PADDLE_COLOR = Color.green;
			break;
			
		case 2:
			Config.PADDLE_COLOR = Color.red;
			break;
		
		
		case 3:
			Config.PADDLE_COLOR = Color.cyan;
			break;
			
		case 4:
			Config.PADDLE_COLOR = Color.gray;
		
		}
		
		
		
		//LADRILLOS
		
		int ladrillo = pDatosPersonalizacion.getInt("ladrillo");
		
		switch(ladrillo) {
		
		case 1:
			Config.BRICK_COLOR = Color.magenta;
			break;
			
		case 2:
			Config.BRICK_COLOR = Color.lightGray;
			break;
		
		
		case 3:
			Config.BRICK_COLOR = Color.darkGray;
			break;
			
		case 4:
			Config.BRICK_COLOR = Color.red;
		
		}
	}

	
	//obtener el Ranking global absoluto
	public JSONObject obtenerRankGA() throws SQLException, JSONException {
		return GestorPuntos.getMiGestorPuntos().obtenerPuntuacionesAbs(false);
	} 
	
	//obtener el Ranking personal absoluto
	public JSONObject obtenerRankPA() throws SQLException, JSONException {
		return GestorPuntos.getMiGestorPuntos().obtenerPuntuacionesAbs(true);
	}
	
	//obtener el Ranking global por niveles
	public JSONObject obtenerRankGN() throws SQLException, JSONException{
		return GestorPuntos.getMiGestorPuntos().obtenerPuntuacionesNiv(false);
	}
	
	//obtener el Ranking personal por niveles
	public JSONObject obtenerRankPN() throws SQLException, JSONException{
		return GestorPuntos.getMiGestorPuntos().obtenerPuntuacionesNiv(true);
	}
	
	
	//Insertar en BD puntuacion de cada partida realizada
	public void insertarPuntuacion() throws SQLException {
		//String nombreU, int puntuacion, int nivel
		//GestorJugadores.getMiGestorJugadores().getLista.getNombre();�
		String user = this.usuario;
		int nivel = 1; //Por defecto 1, no se ha realizado la funcionalidad nivel
		
		ScoreBoard sBoard = new ScoreBoard();
		int puntos = sBoard.getScore();

		GestorPuntos.getMiGestorPuntos().insertarPuntuacion(user, puntos, nivel);  //faltan parametros
	}
}
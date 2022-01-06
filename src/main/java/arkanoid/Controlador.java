package arkanoid;

import java.awt.Color;

import org.json.JSONException;
import org.json.JSONObject;

import eus.ehu.adsi.arkanoid.view.Config;

public class Controlador {
	
	private static Controlador mControlador;
	
	private Controlador() {
		
	}
	
	
	public static Controlador getControlador() {
		if(mControlador==null) {
			mControlador = new Controlador();
		}
		
		return mControlador;
	}
	
	
public JSONObject obtenerDatosPersonalizacion(String pNombreUsuario) {
		
		//1. Obtener el jugador de la lista de jugadores que tenga el nombre de usuario
		
		GestorJugadores gestorJugadores = GestorJugadores.getMiGestorJugadores();
		
		Jugador jugador = gestorJugadores.buscarJugador(pNombreUsuario);
		
		
		//2. Obtener los datos de personalización del jugador buscado
		
		JSONObject datosPersonalizacion = gestorJugadores.obtenerDatosPersonalizacion(jugador);
		
		
		//3. Set datos de personalizacion del jugador al juego
		
		setDatosJuego(datosPersonalizacion);
		
		
		return datosPersonalizacion;
		
	}
	
	
	public void setDatosJuego(JSONObject pDatosPersonalizacion) {
		
		try {
			int fondo = pDatosPersonalizacion.getInt("fondo");
			
			System.out.println(fondo);
			
			switch(fondo) {
			
			case 1:
				Config.BACKGROUND_COLOR = Color.white;
				break;
				
			case 2:
				Config.BACKGROUND_COLOR = Color.green;
				break;
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

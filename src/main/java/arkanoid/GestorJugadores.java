package arkanoid;

import java.util.ArrayList;

import org.json.JSONObject;

public class GestorJugadores {
	
	private static GestorJugadores mGestorJugadores;
	
	private ArrayList<Jugador> listaJugadores;
	
	private GestorJugadores() {}
	
	public static GestorJugadores getMiGestorJugadores() {
		
		if(mGestorJugadores==null) {
			mGestorJugadores = new GestorJugadores();
		}
		return mGestorJugadores;
	}
	
	
	public Jugador buscarJugador(String nombreUsuario) {
		
		boolean encontrado = false;
		
		Jugador jugador = null;
		
		int x = 0;
		
		while(!encontrado || x < listaJugadores.size()) {
			
			System.out.println("aa");
			
			Jugador j = listaJugadores.get(x);
			
			if(j.getNombreUsuario().equals(nombreUsuario)) {
				
				encontrado = true;
				
				jugador = j;
				
			}
			
			x++;
			
		}
		
		return jugador;

	}

	
	
	public JSONObject obtenerDatosPersonalizacion(Jugador pJugador) {
		
		return pJugador.getDatosPersonalizacion();
		
	}
	
	
	public void anadirJugador(Jugador pJugador) {
		
		listaJugadores.add(pJugador);
		
	}
}

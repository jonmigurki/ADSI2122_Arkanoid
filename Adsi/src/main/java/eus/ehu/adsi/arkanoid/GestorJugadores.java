package eus.ehu.adsi.arkanoid;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONException;
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
	
	
	public void cargarJugadores() throws IOException, JSONException {
		
		if(listaJugadores != null) {
			listaJugadores.clear();
		}else {
			listaJugadores = new ArrayList<Jugador>();
		}
		
		FileInputStream fis = new FileInputStream("jugadores.txt");
		Scanner in = new Scanner(fis);
		
		while(in.hasNext()) {
			String linea = in.nextLine();
			String[] u = linea.split(" ");
			
			//System.out.println(linea);
			
			if(u[0].equals("nombreUsuario:")) {
				String nombreUsuario = u[1];
				
				linea = in.nextLine();
				String[] c = linea.split(" ");
				String contrasena = c[1];
				
				linea = in.nextLine();
				String[] e = linea.split(" ");
				String email = e[1];
				
				linea = in.nextLine();
				String datos = linea.substring(22);
				
				//System.out.println(nombreUsuario + " " + contrasena + " " + email + " " + datos);
				
				
				Jugador jugador = new Jugador(nombreUsuario, contrasena, email, new JSONObject(datos));
				
				listaJugadores.add(jugador);
				
			}
			
			
		}
		
	}
	
	
	public int getNumJugadores() {
		if(listaJugadores != null) {
			return listaJugadores.size();
		}else {
			return 0;
		}
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

	public boolean identificar(String u, String c) {
		
		boolean encontrado = false;
		int x = 0;
		
		while(!encontrado && x < listaJugadores.size()) {
			
			
			Jugador j = listaJugadores.get(x);
			
			System.out.println(j.getNombreUsuario() + "    " + j.getContrasena());

			if(j.getNombreUsuario().equals(u) && j.getContrasena().equals(c)) {
				encontrado=true;
			}
			x++;
			
		}
		
		if(!encontrado) {
			return false;
		}
		else {
			return true;
		}
	}

	public void actualizarDatosPersonalizacion(Jugador elJugador, int fondo, int bola, int paddle, int ladrillo) {
		// TODO Auto-generated method stub
		
		//Creamos el objeto JSON
		JSONObject datosPersonalizacion = new JSONObject();
		try {
			datosPersonalizacion.put("fondo", fondo);
			datosPersonalizacion.put("bola", bola);
			datosPersonalizacion.put("paddle", paddle);
			datosPersonalizacion.put("ladrillo", ladrillo);
			
			elJugador.setDatosPersonalizacion(datosPersonalizacion);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

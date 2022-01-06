package arkanoid;

import org.json.JSONObject;

public class Jugador {
	
	
	private String nombreUsuario, contrasena, email;
	private JSONObject datosPersonalizacion;
	
	
	public Jugador(String pNombreUsuario, String pContrasena, String pEmail, JSONObject pDatosPersonalizacion) {
		
		this.nombreUsuario = pNombreUsuario;
		this.contrasena = pContrasena;
		this.email = pEmail;
		this.datosPersonalizacion = pDatosPersonalizacion;
		
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public JSONObject getDatosPersonalizacion() {
		return datosPersonalizacion;
	}


	public void setDatosPersonalizacion(JSONObject datosPersonalizacion) {
		this.datosPersonalizacion = datosPersonalizacion;
	}
	
	

}

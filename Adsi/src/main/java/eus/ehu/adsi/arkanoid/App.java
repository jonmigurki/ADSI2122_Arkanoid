package eus.ehu.adsi.arkanoid;

import eus.ehu.adsi.arkanoid.view.IU_Login;
import eus.ehu.adsi.arkanoid.view.IU_MenuPrincipal;

public class App {
	
	public static void main(String[] args) {
		
		System.out.println("EMPIEZA EL JUEGO");
		
		/*
		IU_Login login = new IU_Login();
		login.setVisible(true);
		*/
		
		/*
		IU_MenuPrincipal menuPrincipal = new IU_MenuPrincipal();
		menuPrincipal.setVisible(true);
		*/
		
		IU_Login login = new IU_Login();
		login.setVisible(true);
		
		//new Arkanoid().run();
	}
	
	
}
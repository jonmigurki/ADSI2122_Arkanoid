package eus.ehu.adsi.arkanoid.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;
import org.json.JSONObject;

import eus.ehu.adsi.arkanoid.Controlador;
import eus.ehu.adsi.arkanoid.GestorJugadores;
import eus.ehu.adsi.arkanoid.Jugador;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class IU_MenuPrincipal extends JFrame implements KeyListener {

	private JPanel contentPane;
	
	static IU_MenuPrincipal frame;
	
	JLabel labelBienvenido;
	
	JButton btnJugar;
	
	String usuarioIdentificado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new IU_MenuPrincipal();
					frame.setVisible(true);
					//System.out.println("Se ha abierto");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IU_MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblArkanoid = new JLabel("ARKANOID");
		lblArkanoid.setHorizontalAlignment(SwingConstants.CENTER);
		lblArkanoid.setFont(new Font("Dialog", Font.BOLD, 24));
		contentPane.add(lblArkanoid, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnPersonalizarJuego = new JButton("Personalizar juego");
		btnPersonalizarJuego.setBounds(29, 57, 168, 25);
		panel.add(btnPersonalizarJuego);
		
		btnPersonalizarJuego.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				IU_Personalizacion personalizacion = new IU_Personalizacion();
				personalizacion.setVisible(true);
			}
			
		});
		
		JButton btnSeleccionarNivel = new JButton("Seleccionar nivel");
		btnSeleccionarNivel.setBounds(239, 56, 158, 25);
		panel.add(btnSeleccionarNivel);
		
		JButton btnRankPersonal = new JButton("Ver ranking personal");
		btnRankPersonal.setBounds(29, 120, 158, 25);
		panel.add(btnRankPersonal);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(258, 107, 117, 25);
		panel.add(btnJugar);
		
		labelBienvenido = new JLabel("");
		labelBienvenido.setFont(new Font("Dialog", Font.BOLD, 15));
		labelBienvenido.setBounds(52, 12, 249, 33);
		panel.add(labelBienvenido);
				
		

		btnRankPersonal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				RankingPersAbs v2 = null;
				try {
					v2 = new RankingPersAbs();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				v2.setVisible(true);
				dispose();
			}
		});	
		
		
		btnJugar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				//new Arkanoid().run();
				
				/*
				Arkanoid arkanoid = new Arkanoid();
				arkanoid.run();
				*/
				
				//super.dispose();
				
				//setVisible(false);
								
				dispose();
				
				Arkanoid arkanoid = new Arkanoid();
				arkanoid.run();
				
				//frame.setVisible(false);
				
				//frame.setVisible(false);
			}
			
		});
		
		
	}
	
	
	public void cargarMenu(String pUsuarioIdentificado) throws JSONException {

		usuarioIdentificado = pUsuarioIdentificado;
		
		Controlador.usuarioIdentificado = usuarioIdentificado;
		
		labelBienvenido.setText("Bienvenid@ " + pUsuarioIdentificado);
		
		Controlador controlador = Controlador.getControlador();
		
		JSONObject datosPersonalizacion = controlador.obtenerDatosPersonalizacion(usuarioIdentificado); 
		
		controlador.setDatosJuego(datosPersonalizacion);
		
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("TECLADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
package eus.ehu.adsi.arkanoid.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.json.JSONException;

import eus.ehu.adsi.arkanoid.GestorJugadores;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JTextField;



public class IU_Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Login frame = new IU_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IU_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblArkanoid = new JLabel("ARKANOID");
		lblArkanoid.setFont(new Font("Dialog", Font.BOLD, 20));
		lblArkanoid.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblArkanoid, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnRankGlobal = new JButton("Ver ranking global");
		btnRankGlobal.setBounds(130, 167, 158, 25);
		panel.add(btnRankGlobal);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(206, 40, 114, 19);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(80, 42, 70, 15);
		panel.add(lblUsuario);
		
		txtContrasena = new JTextField();
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(206, 74, 114, 19);
		panel.add(txtContrasena);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(80, 72, 103, 15);
		panel.add(lblContrasea);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(146, 122, 117, 25);
		panel.add(btnEntrar);
		
		GestorJugadores gestorJugadores = GestorJugadores.getMiGestorJugadores();
		try {
			gestorJugadores.cargarJugadores();
			
			System.out.println("Hay " + gestorJugadores.getNumJugadores() + " jugadores en el sistema.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				String u = txtUsuario.getText().toString();
				String c = txtContrasena.getText().toString();
				
				GestorJugadores gestorJugadores = GestorJugadores.getMiGestorJugadores();
				
				if(gestorJugadores.identificar(u, c)) {
					
					IU_MenuPrincipal menuPrincipal = new IU_MenuPrincipal();
					try {
						menuPrincipal.cargarMenu(u);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					menuPrincipal.setVisible(true);
					setVisible(false);
					
				}else {
					
					Error error = new Error();
					error.setVisible(true);
					
				}
				
			}
			
		});
		
		btnRankGlobal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				RankingGlobAbs v2 = null;
				try {
					v2 = new RankingGlobAbs();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				v2.setVisible(true);
				dispose();
			}
		});	
	}
	
	
	public void cargarLogin() {
		
	}
}
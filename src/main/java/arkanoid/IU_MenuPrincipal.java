package arkanoid;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class IU_MenuPrincipal extends JFrame implements KeyListener {

	private JPanel contentPane;
	
	static IU_MenuPrincipal frame;
	
	JButton btnJugar;

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
		btnPersonalizarJuego.setBounds(29, 87, 168, 25);
		panel.add(btnPersonalizarJuego);
		
		JButton btnSeleccionarNivel = new JButton("Seleccionar nivel");
		btnSeleccionarNivel.setBounds(239, 56, 158, 25);
		panel.add(btnSeleccionarNivel);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(258, 107, 117, 25);
		panel.add(btnJugar);
				
		
		//this.addKeyListener(this);

		
		
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
	
	
	public void cargarMenu() {
		System.out.println("Se ha abierto el menú");
		
		//...
		
		//Añadir jugadores a la lista de jugadores
		JSONObject jsonJugador1 = new JSONObject();
		try {
			jsonJugador1.put("fondo", 1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Jugador jugador1 = new Jugador("jugador1", "123", "j1@gmail.com", jsonJugador1);
		
		GestorJugadores gestorJugadores = GestorJugadores.getMiGestorJugadores();
		
		gestorJugadores.anadirJugador(jugador1);
		
		String nombreUsuario = "jugador1";
		
		Controlador arkanoid = Controlador.getControlador();
		
		JSONObject datosPersonalizacion = arkanoid.obtenerDatosPersonalizacion(nombreUsuario);
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("TECLADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		
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

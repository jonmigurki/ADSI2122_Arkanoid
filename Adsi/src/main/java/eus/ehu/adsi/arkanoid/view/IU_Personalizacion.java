package eus.ehu.adsi.arkanoid.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eus.ehu.adsi.arkanoid.Controlador;
import eus.ehu.adsi.arkanoid.GestorJugadores;
import eus.ehu.adsi.arkanoid.Jugador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class IU_Personalizacion extends JFrame {

	private JPanel contentPane;
	
	String usuarioIdentificado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Personalizacion frame = new IU_Personalizacion();
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
	public IU_Personalizacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblPersonalizacin = new JLabel("PERSONALIZACIÓN");
		lblPersonalizacin.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPersonalizacin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPersonalizacin, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblFondo = new JLabel("FONDO:");
		lblFondo.setBounds(12, 40, 70, 15);
		panel.add(lblFondo);
		
		JLabel lblBola = new JLabel("BOLA:");
		lblBola.setBounds(12, 90, 70, 15);
		panel.add(lblBola);
		
		JLabel lblPaddle = new JLabel("PADDLE:");
		lblPaddle.setBounds(12, 140, 70, 15);
		panel.add(lblPaddle);
		
		JLabel lblLadrillo = new JLabel("LADRILLO:");
		lblLadrillo.setBounds(12, 190, 107, 15);
		panel.add(lblLadrillo);
		
		JPanel fondonegro = new JPanel();
		fondonegro.setBounds(90, 26, 70, 43);
		panel.add(fondonegro);
		
		final JRadioButton btnfondonegro = new JRadioButton("");
		fondonegro.add(btnfondonegro);
		
		JPanel icononegro = new JPanel();
		icononegro.setBackground(Color.BLACK);
		FlowLayout fl_icononegro = (FlowLayout) icononegro.getLayout();
		fl_icononegro.setVgap(15);
		fl_icononegro.setHgap(15);
		fondonegro.add(icononegro);
		
		JPanel fondoblanco = new JPanel();
		fondoblanco.setBounds(170, 26, 70, 43);
		panel.add(fondoblanco);
		
		final JRadioButton btnfondoblanco = new JRadioButton("");
		fondoblanco.add(btnfondoblanco);
		
		JPanel iconoblanco = new JPanel();
		FlowLayout flowLayout = (FlowLayout) iconoblanco.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(15);
		iconoblanco.setBackground(Color.WHITE);
		fondoblanco.add(iconoblanco);
		
		JPanel fondonaranja = new JPanel();
		fondonaranja.setBounds(250, 26, 70, 43);
		panel.add(fondonaranja);
		
		final JRadioButton btnfondonaranja = new JRadioButton("");
		fondonaranja.add(btnfondonaranja);
		
		JPanel icononaranja = new JPanel();
		icononaranja.setBackground(Color.ORANGE);
		FlowLayout fl_icononaranja = (FlowLayout) icononaranja.getLayout();
		fl_icononaranja.setVgap(15);
		fl_icononaranja.setHgap(15);
		fondonaranja.add(icononaranja);
		
		JPanel fondoamarillo = new JPanel();
		fondoamarillo.setBounds(330, 26, 70, 43);
		panel.add(fondoamarillo);
		
		final JRadioButton btnfondoamarillo = new JRadioButton("");
		fondoamarillo.add(btnfondoamarillo);
		
		JPanel iconoamarillo = new JPanel();
		FlowLayout flowlayoutamarillo = (FlowLayout) iconoamarillo.getLayout();
		flowlayoutamarillo.setVgap(15);
		flowlayoutamarillo.setHgap(15);
		iconoamarillo.setBackground(Color.YELLOW);
		fondoamarillo.add(iconoamarillo);
		
		
		/////////////////////////////////////////////////////////////////////////////
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(95, 260, 117, 25);
		panel.add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(244, 260, 117, 25);
		panel.add(btnGuardar);
		
		/////////////////////////////////////////////////////////////////////////////

		
		
		final JRadioButton btnbolaroja = new JRadioButton("Roja");
		btnbolaroja.setForeground(Color.RED);
		btnbolaroja.setBounds(84, 86, 76, 23);
		panel.add(btnbolaroja);
		
		final JRadioButton btnbolarosa = new JRadioButton("Rosa");
		btnbolarosa.setForeground(Color.PINK);
		btnbolarosa.setBounds(244, 86, 76, 23);
		panel.add(btnbolarosa);
		
		final JRadioButton btnazul = new JRadioButton("Azul");
		btnazul.setForeground(Color.BLUE);
		btnazul.setBounds(330, 86, 76, 23);
		panel.add(btnazul);
		
		final JRadioButton btnbolaverde = new JRadioButton("Verde");
		btnbolaverde.setForeground(Color.GREEN);
		btnbolaverde.setBounds(156, 86, 76, 23);
		panel.add(btnbolaverde);
		
		
		////////////////////////////////////////////////////////////////////////////////////
		
		
		JPanel paddleverde = new JPanel();
		paddleverde.setBounds(90, 135, 70, 43);
		panel.add(paddleverde);
		
		final JRadioButton btnpaddleverde = new JRadioButton("");
		paddleverde.add(btnpaddleverde);
		
		JPanel iconoverde = new JPanel();
		FlowLayout flowlayoutverde = (FlowLayout) iconoverde.getLayout();
		flowlayoutverde.setHgap(15);
		iconoverde.setBackground(Color.GREEN);
		paddleverde.add(iconoverde);
		
		
		JPanel paddlerojo = new JPanel();
		paddlerojo.setBounds(160, 135, 70, 43);
		panel.add(paddlerojo);
		
		final JRadioButton btnpaddlerojo = new JRadioButton("");
		paddlerojo.add(btnpaddlerojo);
		
		JPanel iconorojo = new JPanel();
		FlowLayout flowlayoutrojo = (FlowLayout) iconorojo.getLayout();
		flowlayoutrojo.setHgap(15);
		iconorojo.setBackground(Color.RED);
		paddlerojo.add(iconorojo);
		
		JPanel paddlecyan = new JPanel();
		paddlecyan.setBounds(240, 135, 70, 43);
		panel.add(paddlecyan);
		
		final JRadioButton btnpaddlecyan = new JRadioButton("");
		paddlecyan.add(btnpaddlecyan);
		
		JPanel iconocyan = new JPanel();
		FlowLayout flowlayoutcyan = (FlowLayout) iconocyan.getLayout();
		flowlayoutcyan.setHgap(15);
		iconocyan.setBackground(Color.CYAN);
		paddlecyan.add(iconocyan);
		
		JPanel paddlegris = new JPanel();
		paddlegris.setBounds(320, 135, 70, 43);
		panel.add(paddlegris);
		
		final JRadioButton btnpaddlegris = new JRadioButton("");
		paddlegris.add(btnpaddlegris);
		
		JPanel iconogris = new JPanel();
		FlowLayout flowlayoutgris = (FlowLayout) iconogris.getLayout();
		flowlayoutgris.setHgap(15);
		iconogris.setBackground(Color.GRAY);
		paddlegris.add(iconogris);
		
		///////////////////////////////////////////////////////////////
		
		
		JPanel ladrillomagenta = new JPanel();
		ladrillomagenta.setBounds(90, 190, 70, 43);
		panel.add(ladrillomagenta);
		
		final JRadioButton btnladrillomagenta = new JRadioButton("");
		ladrillomagenta.add(btnladrillomagenta);
		
		JPanel iconomagenta = new JPanel();
		FlowLayout flowlayoutmagenta = (FlowLayout) iconomagenta.getLayout();
		flowlayoutmagenta.setVgap(10);
		flowlayoutmagenta.setHgap(15);
		iconomagenta.setBackground(Color.MAGENTA);
		ladrillomagenta.add(iconomagenta);
		
		JPanel ladrillogrisclaro = new JPanel();
		ladrillogrisclaro.setBounds(160, 190, 70, 43);
		panel.add(ladrillogrisclaro);
		
		final JRadioButton btnladrillogrisclaro = new JRadioButton("");
		ladrillogrisclaro.add(btnladrillogrisclaro);
		
		JPanel iconogrisclaro = new JPanel();
		FlowLayout flowlayoutgrisclaro = (FlowLayout) iconogrisclaro.getLayout();
		flowlayoutgrisclaro.setVgap(10);
		flowlayoutgrisclaro.setHgap(15);
		iconogrisclaro.setBackground(Color.LIGHT_GRAY);
		ladrillogrisclaro.add(iconogrisclaro);
		
		
		JPanel ladrillogrisoscuro = new JPanel();
		ladrillogrisoscuro.setBounds(240, 190, 70, 43);
		panel.add(ladrillogrisoscuro);
		
		final JRadioButton btnladrillogrisoscuro = new JRadioButton("");
		ladrillogrisoscuro.add(btnladrillogrisoscuro);
		
		JPanel iconogrisoscuro = new JPanel();
		FlowLayout flowlayoutgrisoscuro = (FlowLayout) iconogrisoscuro.getLayout();
		flowlayoutgrisoscuro.setVgap(10);
		flowlayoutgrisoscuro.setHgap(15);
		iconogrisoscuro.setBackground(Color.DARK_GRAY);
		ladrillogrisoscuro.add(iconogrisoscuro);
		
		JPanel ladrillorojo = new JPanel();
		ladrillorojo.setBounds(320, 190, 70, 43);
		panel.add(ladrillorojo);
		
		final JRadioButton btnladrillorojo = new JRadioButton("");
		ladrillorojo.add(btnladrillorojo);
		
		iconorojo = new JPanel();
		flowlayoutrojo = (FlowLayout) iconorojo.getLayout();
		flowlayoutrojo.setVgap(10);
		flowlayoutrojo.setHgap(15);
		iconorojo.setBackground(Color.RED);
		ladrillorojo.add(iconorojo);
		
		
		//////////////////////////////////////
		
		ButtonGroup grupofondo = new ButtonGroup();
		grupofondo.add(btnfondonegro);
		grupofondo.add(btnfondoblanco);
		grupofondo.add(btnfondonaranja);
		grupofondo.add(btnfondoamarillo);
		
		ButtonGroup grupobola = new ButtonGroup();
		grupobola.add(btnbolaroja);
		grupobola.add(btnbolarosa);
		grupobola.add(btnbolaverde);
		grupobola.add(btnazul);
		
		ButtonGroup grupopaddle = new ButtonGroup();
		grupopaddle.add(btnpaddlecyan);
		grupopaddle.add(btnpaddlegris);
		grupopaddle.add(btnpaddlerojo);
		grupopaddle.add(btnpaddleverde);
		
		ButtonGroup grupoladrillo = new ButtonGroup();
		grupoladrillo.add(btnladrillomagenta);
		grupoladrillo.add(btnladrillogrisclaro);
		grupoladrillo.add(btnladrillogrisoscuro);
		grupoladrillo.add(btnladrillorojo);

		
		
		
		
		/////////////////////////////////////////////////////////
		
		
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int fondo = 0, bola = 0, paddle = 0, ladrillo = 0;
				
				
				if(btnfondonegro.isSelected()) {
					fondo = 1;
				}else if(btnfondoblanco.isSelected()) {
					fondo = 2;
				}else if(btnfondonaranja.isSelected()) {
					fondo = 3;
				}else if(btnfondoamarillo.isSelected()) {
					fondo = 4;
				}
				
				if(btnbolaroja.isSelected()) {
					bola = 1;
				}else if(btnbolaverde.isSelected()) {
					bola = 2;
				}else if(btnbolarosa.isSelected()) {
					bola = 3;
				}else if(btnazul.isSelected()) {
					bola = 4;
				}
				
				if(btnpaddleverde.isSelected()) {
					paddle = 1;
				}else if(btnpaddlerojo.isSelected()) {
					paddle = 2;
				}else if(btnpaddlecyan.isSelected()) {
					paddle = 3;
				}else if(btnpaddlegris.isSelected()) {
					paddle = 4;
				}
				
				if(btnladrillomagenta.isSelected()) {
					ladrillo = 1;
				}else if(btnladrillogrisclaro.isSelected()) {
					ladrillo = 2;
				}else if(btnladrillogrisoscuro.isSelected()) {
					ladrillo = 3;
				}else if(btnladrillorojo.isSelected()) {
					ladrillo = 4;
				}
				
				
				//Obtenemos el usuario identificado
				
				String usuarioIdentificado = Controlador.usuarioIdentificado;
				
				
				//Actualizamos sus ajustes personalizados
				
				GestorJugadores gestorJugadores = GestorJugadores.getMiGestorJugadores();
				Jugador elJugador = gestorJugadores.buscarJugador(usuarioIdentificado);
				
				gestorJugadores.actualizarDatosPersonalizacion(elJugador, fondo, bola, paddle, ladrillo);
				
			}
			
		});

		
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		

	}

}

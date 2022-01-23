package eus.ehu.adsi.arkanoid.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.json.JSONException;
import org.json.JSONObject;
import eus.ehu.adsi.arkanoid.Controlador;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class RankingGlobNiv extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingGlobNiv frame = new RankingGlobNiv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws JSONException 
	 * @throws SQLException 
	 */
	public RankingGlobNiv() throws SQLException, JSONException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.BLACK);
		contentPane_1.setBounds(0, 0, 434, 261);
		contentPane.add(contentPane_1);
		
		JLabel lblRankingGlobalPor = new JLabel("Ranking global por niveles");
		lblRankingGlobalPor.setForeground(Color.WHITE);
		lblRankingGlobalPor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRankingGlobalPor.setBounds(25, 24, 210, 29);
		contentPane_1.add(lblRankingGlobalPor);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RankingGlobAbs v0=null;
				try {
					v0 = new RankingGlobAbs();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				v0.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(309, 202, 89, 23);
		contentPane_1.add(btnNewButton_1);
		
		
		JTextArea tArea = new JTextArea();
		tArea.setAutoscrolls(true);
		tArea.setBounds(25, 82, 250, 158);
		tArea.setLineWrap(true);
		
		JSONObject j = Controlador.getControlador().obtenerRankGN();
		int cont = 0;
		
		while (cont < j.length()) {
			
			JSONObject jO=j.getJSONObject(Integer.toString(cont));

			String nombreU = jO.getString("nombreU");
			int puntuacion=jO.getInt("puntuacion");
			int nivel = jO.getInt("nivel");
			
			int num = cont + 1;
			tArea.append("    " + num + "               " + nombreU + "               " + puntuacion + "               " + nivel + "\n");
			
			cont++;
		}
		
		tArea.setEnabled(false);
		tArea.setDisabledTextColor(Color.BLACK);
		contentPane_1.add(tArea);
	
		JLabel lblNewLabel_1 = new JLabel("#");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(35, 64, 46, 14);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(80, 64, 46, 14);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Puntos");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(152, 64, 46, 14);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nivel");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(229, 64, 46, 14);
		contentPane_1.add(lblNewLabel_4);
	}
	
}



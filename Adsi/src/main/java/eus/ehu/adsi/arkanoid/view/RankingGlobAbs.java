package eus.ehu.adsi.arkanoid.view;

import java.awt.EventQueue;
import org.json.JSONObject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.json.JSONException;
import eus.ehu.adsi.arkanoid.Controlador;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class RankingGlobAbs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingGlobAbs frame = new RankingGlobAbs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws JSONException 
	 */
	public RankingGlobAbs() throws SQLException, JSONException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ranking global absoluto");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(25, 24, 210, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver por niveles");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RankingGlobNiv v2=null;
				try {
					v2 = new RankingGlobNiv();
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
		btnNewButton.setBounds(293, 95, 120, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IU_Login v0= new IU_Login();
				v0.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(309, 204, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JTextArea tArea = new JTextArea();
		tArea.setAutoscrolls(true);
		tArea.setBounds(25, 82, 250, 158);
		tArea.setLineWrap(true);

		JSONObject j = Controlador.getControlador().obtenerRankGA();
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
		contentPane.add(tArea);
		
		JLabel lblNewLabel_1 = new JLabel("#");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(35, 62, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(86, 64, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Puntos");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(154, 64, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nivel");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(218, 64, 46, 14);
		contentPane.add(lblNewLabel_4);
	}
	
	
}

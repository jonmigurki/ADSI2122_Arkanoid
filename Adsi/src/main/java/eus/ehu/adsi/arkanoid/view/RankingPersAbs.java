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


public class RankingPersAbs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingPersAbs frame = new RankingPersAbs();
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
	public RankingPersAbs() throws SQLException, JSONException {
		
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
		
		JLabel lblRankingPersonalAbsoluto = new JLabel("Ranking personal absoluto");
		lblRankingPersonalAbsoluto.setForeground(Color.WHITE);
		lblRankingPersonalAbsoluto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRankingPersonalAbsoluto.setBounds(25, 24, 210, 29);
		contentPane_1.add(lblRankingPersonalAbsoluto);
		
		JButton btnNewButton = new JButton("Ver por niveles");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RankingPersNiv v4 = null;
				try {
					v4 = new RankingPersNiv();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				v4.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(301, 83, 123, 23);
		contentPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IU_MenuPrincipal vm= new IU_MenuPrincipal();
				vm.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(312, 205, 89, 23);
		contentPane_1.add(btnNewButton_1);
		
		JTextArea tArea = new JTextArea();
		tArea.setAutoscrolls(true);
		tArea.setBounds(25, 82, 250, 158);
		tArea.setLineWrap(true);
		
		JSONObject j = Controlador.getControlador().obtenerRankPA();
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
		lblNewLabel_1.setBounds(35, 62, 46, 14);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(86, 64, 46, 14);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Puntos");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(154, 64, 46, 14);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nivel");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(218, 64, 46, 14);
		contentPane_1.add(lblNewLabel_4);
	}

}

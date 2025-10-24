package tema2.Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EjemploInterfazVentanaSobreponerVentanas {

	private JFrame frame;
	private int contador = 0;
	private JTextField textField;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploInterfazVentanaSobreponerVentanas window = new EjemploInterfazVentanaSobreponerVentanas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjemploInterfazVentanaSobreponerVentanas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds((1920/2) - (873 / 2), (1080/2) - (551 / 2), 873, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0)); // CardLayout sirve como una baraja de cartas, superpone
																// paneles

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		frame.getContentPane().add(panel, "name_469330433000");
		panel.setLayout(null); // Absulute, sirve para que pueda posicionar los elementos a mi gusto

		JButton btnNewButton = new JButton(">>Click<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				contador++;
				textField.setText(Integer.toString(contador));

			}
		});
		btnNewButton.setBounds(309, 226, 91, 22);
		panel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("NUMERO DE CLICKS");
		lblNewLabel.setBounds(424, 200, 97, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(424, 226, 97, 20);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_1 = new JButton("Siguiente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(758, 478, 89, 23);
		panel.add(btnNewButton_1);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		frame.getContentPane().add(panel_1, "name_471269784400");
		panel_1.setLayout(null);

		btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_1.setVisible(false);
				panel.setVisible(true);

			}
		});
		btnNewButton_2.setBounds(10, 478, 89, 23);
		panel_1.add(btnNewButton_2);

		btnNewButton_3 = new JButton("Siguiente");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_1.setVisible(false);
				panel_2.setVisible(true);

			}
		});
		btnNewButton_3.setBounds(758, 478, 89, 23);
		panel_1.add(btnNewButton_3);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 255, 128));
		frame.getContentPane().add(panel_2, "name_474233363400");
		panel_2.setLayout(null);
		
		btnNewButton_4 = new JButton("Volver");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_2.setVisible(false);
				panel_1.setVisible(true);
				
			}
		});
		btnNewButton_4.setBounds(10, 478, 89, 23);
		panel_2.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Volver al inicio");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(729, 478, 118, 23);
		panel_2.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("GRACIAS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.ITALIC, 95));
		lblNewLabel_1.setBounds(216, 105, 419, 265);
		panel_2.add(lblNewLabel_1);
	}
}

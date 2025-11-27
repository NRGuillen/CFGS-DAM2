package tema2.Ventanas.EnvioGmail;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VentanaEnvioEmail {

	private JFrame frame;
	private JTextPane textPane;
	private JLabel lblNewLabel_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	SimpleEmail conectarEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEnvioEmail window = new VentanaEnvioEmail();
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
	public VentanaEnvioEmail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 858, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Enviar gmail");
		btnNewButton.setBounds(422, 369, 136, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField.getText().isBlank());
				if (!textField.getText().isBlank() && !textField_1.getText().isBlank() && !textField_2.getText().isBlank() && !textPane.getText().isBlank() && !textField_3.getText().isBlank()) {
					conectarEmail.conexionEmail(textField.getText(), textField_1.getText(), textField_2.getText(), textPane.getText(), textField_3.getText());
				} else {
					lblNewLabel_5.setVisible(true);
				}
			}
		});

		textField = new JTextField();
		textField.setBounds(270, 149, 288, 23);
		panel.add(textField);
		textField.setColumns(10);

		textPane = new JTextPane();
		textPane.setBounds(270, 251, 288, 77);
		panel.add(textPane);

		textField_1 = new JTextField();
		textField_1.setBounds(270, 183, 288, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("Introduce tu correo electronico");
		lblNewLabel.setBounds(82, 153, 196, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Introduce la contraseña");
		lblNewLabel_1.setBounds(82, 183, 196, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Introduce el mensaje");
		lblNewLabel_2.setBounds(82, 251, 161, 14);
		panel.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(270, 339, 288, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Introducir el correo de destino");
		lblNewLabel_3.setBounds(82, 343, 196, 14);
		panel.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("Resetear campos");
		btnNewButton_1.setBounds(270, 369, 136, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textPane.setText(null);
				textField_3.setText(null);
				lblNewLabel_5.setVisible(false);

			}
		});

		textField_3 = new JTextField();
		textField_3.setBounds(270, 217, 288, 23);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Introduce el asunto");
		lblNewLabel_4.setBounds(82, 223, 174, 14);
		panel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Error, ha introducido campos vacios");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setVisible(false);
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(270, 403, 288, 14);
		panel.add(lblNewLabel_5);
	}
}

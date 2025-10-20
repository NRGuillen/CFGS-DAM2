package tema2.Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.JSlider;
import javax.swing.JTable;

public class EjemploInterfazVentana {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploInterfazVentana window = new EjemploInterfazVentana();
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
	public EjemploInterfazVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(192, 192, 192));
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(0, 0, 808, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cuadro texto con el enable activado");
		lblNewLabel.setBounds(199, 178, 174, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setToolTipText("Tooltip realizado en textField sirve para ayudar al usuario");
		textField.setBounds(383, 175, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Tooltip realizado en textField_1 sirve para ayudar al usuario");
		textField_1.setEnabled(false);
		textField_1.setBounds(383, 198, 87, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cuadro texto con el enable desactivado");
		lblNewLabel_1.setBounds(182, 201, 191, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(383, 314, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(270, 229, 202, 81);
		frame.getContentPane().add(textArea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(383, 152, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("PasswordField");
		lblNewLabel_2.setBounds(305, 155, 68, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(343, 315, 30, 22);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_3 = new JLabel("JSpinner");
		lblNewLabel_3.setBounds(298, 318, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Text Area");
		lblNewLabel_4.setBounds(211, 258, 112, 14);
		frame.getContentPane().add(lblNewLabel_4);
	}
}

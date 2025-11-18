package tema2.Ventanas.EjemploTraductorClases;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

//Lo podemos abrir con modo diseño, Click derecho clase -> open with -> WindowBuilder 

public class Panel extends JPanel {
	private JTextField textField;
	public Panel() {
		
		setBackground(new Color(255, 255, 255));
		setForeground(new Color(255, 255, 255));
		setSize(new Dimension(800, 600));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(233, 289, 249, 39);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(233, 171, 249, 39);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Traducir");
		btnNewButton.setBounds(233, 239, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reiniciar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(393, 239, 89, 23);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Traductor Ruben Ingles - Español");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(160, 110, 419, 50);
		add(lblNewLabel_1);
		
		
		
		
		
	}
}

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
	private JTextField entrada;
	private JButton traducir;
	private JButton reiniciar;
	private JLabel salida;

	public Panel() {

		setBackground(new Color(255, 255, 255));
		setForeground(new Color(255, 255, 255));
		setSize(new Dimension(800, 600));
		setLayout(null);

		salida = new JLabel("");
		salida.setOpaque(true);
		salida.setBackground(new Color(192, 192, 192));
		salida.setHorizontalAlignment(SwingConstants.CENTER);
		salida.setHorizontalTextPosition(SwingConstants.CENTER);
		salida.setBounds(233, 289, 249, 39);
		add(salida);

		entrada = new JTextField();
		entrada.setBounds(233, 171, 249, 39);
		add(entrada);
		entrada.setColumns(10);

		traducir = new JButton("Traducir");
		traducir.setBounds(233, 239, 89, 23);
		traducir.addActionListener(new EventoTraducir(entrada ,salida)); //Entrada -> lo que mete el usuario, salida -> la palabra traducida
		add(traducir);

		reiniciar = new JButton("Reiniciar");
		reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		reiniciar.setBounds(393, 239, 89, 23);
		add(reiniciar);

		JLabel lblNewLabel_1 = new JLabel("Traductor Ruben Ingles - Español");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(160, 110, 419, 50);
		add(lblNewLabel_1);

	}
}

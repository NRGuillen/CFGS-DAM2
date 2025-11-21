package tema2.Ventanas.Ejercicios;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Component;

import javax.swing.SwingConstants;

import tema2.Ventanas.EjemploInterfazIconoYFondoConImagenes;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;

public class AtrapaLaMosca {

	private JFrame frame;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtrapaLaMosca window = new AtrapaLaMosca();
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
	public AtrapaLaMosca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public int posicionRandomX() {

		int random = (int) (Math.random() * (frame.getWidth() - lblNewLabel_1.getWidth())) + 1;
		System.out.println("X " + random);

		return random;
	}

	public int posicionRandomY() {

		int random = (int) (Math.random() * (frame.getHeight() - lblNewLabel_1.getHeight())) + 1;
		System.out.println("Y " + random);

		return random;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 736, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		System.out.println(frame.getWidth());
		System.out.println(frame.getHeight());

		JLabel lblNewLabel = new JLabel("ATRAPA A LA MOSCA JEJE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(100, 199, 483, 148);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblNewLabel_1.setBounds(posicionRandomX(), posicionRandomY(), lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight());

			}
		});
		System.out.println(lblNewLabel_1.getWidth());
		System.out.println(lblNewLabel_1.getHeight());

		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(AtrapaLaMosca.class.getResource("/tema2/Ventanas/Ejercicios/Captura de pantalla 2025-11-20 101655.png")));
		lblNewLabel_1.setBounds(304, 216, 97, 78);
		lblNewLabel_1.getHeight();
		frame.getContentPane().add(lblNewLabel_1);

	}
}

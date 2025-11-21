package tema2.Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import javax.swing.JProgressBar;

public class EjercicioInterfaz {

	private JFrame frame;
	private Timer tiempo;
	private JProgressBar progressBar;
	int temporizador = 10;
	int temporizador2 = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjercicioInterfaz window = new EjercicioInterfaz();
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
	public EjercicioInterfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 781, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 765, 528);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(491, 66, 70, 53);
		panel.add(lblNewLabel);

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 128, 192));
		progressBar.setStringPainted(true);
		progressBar.setOpaque(true);
		progressBar.setBounds(169, 267, 392, 83);
		panel.add(progressBar);

		JButton btnNewButton = new JButton("START");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(114, 45, 131, 93);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiempo.start();
			}
		});

		int tamaño = 10;

		tiempo = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblNewLabel.setText(String.valueOf(--temporizador));
				progressBar.setValue((temporizador2 * tamaño));
				progressBar.setBackground(new Color(0, 255, 0));
				temporizador2++;

				if (temporizador == 0) {
					tiempo.stop();

					btnNewButton.setEnabled(false);

					if (progressBar.getValue() == 100) {
						String msg = "HOLA QUE TAL";
						JOptionPane.showMessageDialog(null, msg, "Al recleo?", 1);
					}
				}

			}

		});

	}
}

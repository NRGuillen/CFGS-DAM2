package tema2.Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EjemploInterfazLayeredPane {

	private JFrame frame;
	JPanel verde;
	JPanel azul;
	JPanel rosa;
	private JButton btnNewButton_1;
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
					EjemploInterfazLayeredPane window = new EjemploInterfazLayeredPane();
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
	public EjemploInterfazLayeredPane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(layeredPane);

		verde = new JPanel();
		layeredPane.setLayer(verde, 0);
		/*
		 * Para que no se sobrepongan se puedes usar layeredPane o setVisible, con
		 * layers tendrias que poner numeros de capas, 1 2 3, la tercera seria la
		 * visible ya que es como una baraja y la 1 la ultima.
		 */
		verde.setBackground(new Color(128, 255, 0));
		verde.setBounds(0, 0, 434, 261);
		layeredPane.add(verde);
		/*
		 * No lo pongo invisible despues de crearlo, para que sea el unico en salir con
		 * sus botones
		 */
		verde.setLayout(null);

		btnNewButton_5 = new JButton("Cambiar al panel azul");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verde.setVisible(false);
				rosa.setVisible(false);
				azul.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(258, 227, 166, 23);
		verde.add(btnNewButton_5);

		btnNewButton_3 = new JButton("Cambiar al panel rosa");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rosa.setVisible(true);
				azul.setVisible(false);
				verde.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(10, 227, 166, 23);
		verde.add(btnNewButton_3);

		azul = new JPanel();
		layeredPane.setLayer(azul, 0);
		azul.setBackground(new Color(0, 64, 128));
		azul.setBounds(0, 0, 434, 261);
		layeredPane.add(azul);
		azul.setVisible(false); /*
								 * Lo pongo invisible despues de crearlo, para que no salgan sus botones
								 * sobrepuestos en el inicio y luego lo visibilizo con botones
								 */
		azul.setLayout(null);

		JButton btnNewButton_2 = new JButton("Cambiar al panel rosa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				azul.setVisible(false);
				rosa.setVisible(true);
				verde.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(248, 227, 176, 23);
		azul.add(btnNewButton_2);

		btnNewButton_4 = new JButton("Cambiar al panel verde");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verde.setVisible(true);
				rosa.setVisible(false);
				azul.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(10, 227, 181, 23);
		azul.add(btnNewButton_4);

		rosa = new JPanel();
		layeredPane.setLayer(rosa, 0);
		rosa.setBackground(new Color(255, 128, 128));
		rosa.setBounds(0, 0, 434, 261);
		layeredPane.add(rosa);
		rosa.setVisible(false); /*
								 * Lo pongo invisible despues de crearlo, para que no salgan sus botones
								 * sobrepuestos en el inicio y luego lo visibilizo con botones
								 */
		rosa.setLayout(null);

		btnNewButton_1 = new JButton("Cambiar al panel verde");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rosa.setVisible(false);
				verde.setVisible(true);
				azul.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(259, 227, 165, 23);
		rosa.add(btnNewButton_1);

		btnNewButton_5 = new JButton("Cambiar al panel azul");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verde.setVisible(false);
				rosa.setVisible(false);
				azul.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(10, 227, 158, 23);
		rosa.add(btnNewButton_5);
	}
}

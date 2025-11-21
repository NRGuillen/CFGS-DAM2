package tema2.Ventanas.Ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class TraductorEnVentana {

	private JFrame frame;
	private JTextField txtAsd;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraductorEnVentana window = new TraductorEnVentana();
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
	public TraductorEnVentana() {
		initialize();
	}

	public static String Traductor(String nombreTraducir) throws IOException {
		String resultado = null;
		String expReg = "^[a-zA-Zñ]{1,}$";

		if (nombreTraducir != null && nombreTraducir.matches(expReg)) {

			String web = "https://www.spanishdict.com/translate/" + nombreTraducir;

			Document document = Jsoup.connect(web).get();

			// <div id="quickdef1-es" class="jkbnWXMh ct5mIhTF">
			// <a href="/translate/folder?langFrom=en" class="tCur1iYh">folder</a>
			// </div>

			Elements palabra = document.select("div#quickdef1-es a.tCur1iYh"); // selector css
			// el # es para buscar id
			// el . es para buscar clases
			
			if (palabra.size() < 0) {
				Element palabraExiste = document.select("div#quickdef1-es a.tCur1iYh").get(0);

			}

			resultado = palabra.html().toUpperCase();

		}
		return resultado;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 780, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		txtAsd = new JTextField();
		txtAsd.setHorizontalAlignment(SwingConstants.CENTER);
		txtAsd.setBounds(228, 142, 255, 30);
		panel.add(txtAsd);
		txtAsd.setColumns(10);

		JLabel lblNewLabel = new JLabel("Traductor de ruben Español > Inlges");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(171, 60, 400, 71);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Traducir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(false);
				txtAsd.setEditable(false);

				String nombreTraducir = txtAsd.getText();
				System.out.print(nombreTraducir);
				if (nombreTraducir.length() > 0) {
					try {
						String palabraTraducida = Traductor(nombreTraducir);

						lblNewLabel_1.setText(palabraTraducida);
						System.out.print(palabraTraducida);

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

		});
		btnNewButton.setBounds(228, 183, 89, 23);
		panel.add(btnNewButton);

		lblNewLabel_1 = new JLabel("Se muestra palabra traducida");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(228, 217, 253, 30);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Introduce la palabra a traducir (Español > Ingles) ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(217, 114, 278, 34);
		panel.add(lblNewLabel_2);

		btnNewButton_1 = new JButton("Resetear");
		btnNewButton_1.setBounds(394, 183, 89, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton.setVisible(true);
				txtAsd.setText(null);
				lblNewLabel_1.setText(null);
				txtAsd.setEditable(true);
			}
		});

		btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setBounds(312, 296, 89, 23);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
	}
}

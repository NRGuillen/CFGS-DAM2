package tema2.Ventanas.EjemploTraductorClases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventoTraducir implements ActionListener {

	JTextField entrada;
	JLabel salida;

	public EventoTraducir(JTextField entrada, JLabel salida) {
		// TODO Auto-generated constructor stub
		this.entrada = entrada;
		this.salida = salida;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// 1. Control de errores
		if (entrada.getText().isBlank() != true) {

			salida.setText(Operaciones.traducir(entrada.getText()));

		} else {

			JOptionPane.showMessageDialog(null, "No se ha inteoducido un texto correcto", "ERROR", 0);

		}

	}

}

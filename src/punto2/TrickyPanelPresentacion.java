/*
 * Programa: Punto 2 del Laboratorio 12
 * Autor: Miguel Nicolas Diaz Vargas
 * Fecha: Agosto 10 de 2021
 */

package punto2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TrickyPanelPresentacion extends JPanel {

	// variables 
	private JLabel tituloLb;
	private JLabel mensaje1Lb;
	private JLabel mensaje2Lb;
	private JTextField player1JTF;
	private JTextField player2JTF;

	// metodo contructor
	TrickyPanelPresentacion() {

		// configuracion de la ventana
		this.setBackground(new Color(135, 220, 150));
		this.setForeground(SystemColor.textHighlight);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout(0, 0));

		// declaracion de titulo principal
		tituloLb = new JLabel("BIENVENIDO \r\nA TRICKY");
		tituloLb.setFont(new Font("DialogInput", Font.BOLD, 35));
		tituloLb.setBounds(10, 58, 414, 47);
		this.add(tituloLb);

		// mensajes 
		mensaje1Lb = new JLabel("Nombre Player 1:");
		mensaje1Lb.setFont(new Font("Tahoma", Font.BOLD, 11));
		mensaje1Lb.setBounds(58, 116, 109, 18);
		this.add(mensaje1Lb);

		mensaje2Lb = new JLabel("Nombre Player 2:");
		mensaje2Lb.setFont(new Font("Tahoma", Font.BOLD, 11));
		mensaje2Lb.setBounds(257, 116, 109, 18);
		this.add(mensaje2Lb);

		// creacion de TextField para ingresar nombres
		player1JTF = new JTextField();
		player1JTF.setBounds(58, 145, 99, 23);
		player1JTF.setColumns(10);
		this.add(player1JTF);

		player2JTF = new JTextField();
		player2JTF.setBounds(256, 145, 99, 22);
		player2JTF.setColumns(10);
		this.add(player2JTF);

	}

	// creacion de setters y getters
	public JLabel getTituloLb() {
		return tituloLb;
	}

	public void setTituloLb(JLabel tituloLb) {
		this.tituloLb = tituloLb;
	}

	public JLabel getMensaje1Lb() {
		return mensaje1Lb;
	}

	public void setMensaje1Lb(JLabel mensaje1Lb) {
		this.mensaje1Lb = mensaje1Lb;
	}

	public JLabel getMensaje2Lb() {
		return mensaje2Lb;
	}

	public void setMensaje2Lb(JLabel mensaje2Lb) {
		this.mensaje2Lb = mensaje2Lb;
	}

	public JTextField getPlayer1JTF() {
		return player1JTF;
	}

	public void setPlayer1JTF(JTextField player1jtf) {
		player1JTF = player1jtf;
	}

	public JTextField getPlayer2JTF() {
		return player2JTF;
	}

	public void setPlayer2JTF(JTextField player2jtf) {
		player2JTF = player2jtf;
	}

}

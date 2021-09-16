/*
 * Programa: Punto 2 del Laboratorio 12
 * Autor: Miguel Nicolas Diaz Vargas
 * Fecha: Agosto 10 de 2021
 */

package punto2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TrickyPanel extends JPanel {

	// declaracion de variables de instancia
	private JLabel mensaje4LbJuego;
	private JButton imagen1;
	private JButton imagen2;
	
	// creacion de metodo constrcutor
	TrickyPanel() {

		// configuracion de panel
		this.setBackground(new Color(135, 220, 150));
		this.setForeground(SystemColor.textHighlight);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout(0, 0));

		// generacion de botones para logos de jugador 1 y 2
		imagen1 = new JButton();
		imagen1.setBounds(15, 5, 40, 40);
		this.add(imagen1);
		
		imagen2 = new JButton();
		imagen2.setBounds(435, 5, 43, 43);
		this.add(imagen2);
		
		//creacion de imagenes para los botones de de jugador 1 y 2
		ImageIcon cruz = new ImageIcon(getClass().getResource("/Imagenes/cruz.png"));
		Icon cruzIcon = new ImageIcon(cruz.getImage().getScaledInstance(imagen1.getWidth(),
				imagen1.getHeight(), Image.SCALE_DEFAULT));
		imagen1.setIcon(cruzIcon);
		
		ImageIcon circulo = new ImageIcon(getClass().getResource("/Imagenes/circulo.png"));
		Icon circuloIcon = new ImageIcon(circulo.getImage().getScaledInstance(imagen2.getWidth(),
				imagen2.getHeight(), Image.SCALE_DEFAULT));
		imagen2.setIcon(circuloIcon);
		
		// mensaje con error (REVISAR)
		JLabel mensaje5LbJuego = new JLabel("");
		mensaje5LbJuego.setBounds(0, 0, 150, 14);
		this.add(mensaje5LbJuego);

	}

	// Creacion de metodo grafics para reja del tricky
	public void paint(Graphics g) {

		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(160, 85, 10, 350);
		g.fillRect(290, 85, 10, 350);
		g.fillRect(60, 190, 350, 10);
		g.fillRect(60, 310, 350, 10);

	}

	// declaracion de metodos getter y setters
	public JLabel getMensaje4LbJuego() {
		return mensaje4LbJuego;
	}

	public void setMensaje4LbJuego(JLabel mensaje4LbJuego) {
		this.mensaje4LbJuego = mensaje4LbJuego;
	}

	public JButton getImagen1() {
		return imagen1;
	}

	public void setImagen1(JButton imagen1) {
		this.imagen1 = imagen1;
	}

	public JButton getImagen2() {
		return imagen2;
	}

	public void setImagen2(JButton imagen2) {
		this.imagen2 = imagen2;
	}

}

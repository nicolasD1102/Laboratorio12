/*
 * Programa: Punto 2 del Laboratorio 12
 * Autor: Miguel Nicolas Diaz Vargas
 * Fecha: Agosto 10 de 2021
 */

package punto2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// extends de JFrame
public class TrickyVentana extends JFrame {

	// declaracion de lo que contine la ventana
	private TrickyPanel panelJuego;
	private TrickyPanelPresentacion panelPresentacion;
	private JLabel mensaje1LbJuego;
	private JLabel mensaje2LbJuego;
	private JLabel mensaje4LbJuego;
	private JButton jugarBtn;
	private JButton posicion0_0BtGame;
	private JButton posicion0_1BtGame;
	private JButton posicion0_2BtGame;
	private JButton posicion1_0BtGame;
	private JButton posicion1_1BtGame;
	private JButton posicion1_2BtGame;
	private JButton posicion2_0BtGame;
	private JButton posicion2_1BtGame;
	private JButton posicion2_2BtGame;
	private JButton reiniciarJuegoBtGame;
	private int jugador = 1;

	// metodo constructor
	public TrickyVentana() {

		// configuracion de panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(panelPresentacion = new TrickyPanelPresentacion());
		panelPresentacion.setLayout(null);

		// configuracion de boto Jugar
		jugarBtn = new JButton("JUGAR!");
		jugarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// expcion de no entrar ningun nombre
				try {
					// creacion de objeto littleGame 
					TrickyPlayer littleGame = new TrickyPlayer((panelPresentacion.getPlayer1JTF().getText()),
							(panelPresentacion.getPlayer2JTF().getText()));

					// ocultamiento del panel de presentacion
					panelPresentacion.setVisible(false);

					// configuracion de panel del juego
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 500, 500);
					setContentPane(panelJuego = new TrickyPanel());
					panelJuego.setLayout(null);

					// creacion de mensajes
					mensaje1LbJuego = new JLabel(
							"Puntaje " + littleGame.getNickname1() + ": " + littleGame.getPuntaje1());
					mensaje1LbJuego.setFont(new Font("DialogInput", Font.BOLD, 15));
					mensaje1LbJuego.setBounds(60, 11, 200, 14);
					panelJuego.add(mensaje1LbJuego);

					mensaje2LbJuego = new JLabel(
							"Puntaje " + littleGame.getNickname2() + ": " + littleGame.getPuntaje2());
					mensaje2LbJuego.setFont(new Font("DialogInput", Font.BOLD, 15));
					mensaje2LbJuego.setBounds(270, 11, 200, 14);
					panelJuego.add(mensaje2LbJuego);

					mensaje4LbJuego = new JLabel("Juega jugador: " + littleGame.getNickname1());
					mensaje4LbJuego.setFont(new Font("DialogInput", Font.BOLD, 17));
					mensaje4LbJuego.setBounds(130, 50, 300, 20);
					panelJuego.add(mensaje4LbJuego);

					//creacion de botones del tricky
					posicion0_0BtGame = new JButton("");
					CreacionDeBotones(panelJuego, littleGame, posicion0_0BtGame, 0, 0, 60, 88);

					posicion0_1BtGame = new JButton("");
					CreacionDeBotones(panelJuego, littleGame, posicion0_1BtGame, 0, 1, 186, 88);

					posicion0_2BtGame = new JButton("");
					CreacionDeBotones(panelJuego, littleGame, posicion0_2BtGame, 0, 2, 310, 88);

					posicion1_0BtGame = new JButton("");
					CreacionDeBotones(panelJuego, littleGame, posicion1_0BtGame, 1, 0, 60, 210);

					posicion1_1BtGame = new JButton("");
					CreacionDeBotones(panelJuego, littleGame, posicion1_1BtGame, 1, 1, 186, 210);

					posicion1_2BtGame = new JButton("");
					CreacionDeBotones(panelJuego, littleGame, posicion1_2BtGame, 1, 2, 310, 210);

					posicion2_0BtGame = new JButton("");
					CreacionDeBotones(panelJuego, littleGame, posicion2_0BtGame, 2, 0, 60, 325);

					posicion2_1BtGame = new JButton("");
					CreacionDeBotones(panelJuego, littleGame, posicion2_1BtGame, 2, 1, 186, 325);

					posicion2_2BtGame = new JButton("");
					CreacionDeBotones(panelJuego, littleGame, posicion2_2BtGame, 2, 2, 310, 325);

					// conifguracion de boton reiniciar
					reiniciarJuegoBtGame = new JButton("Reiniciar");
					reiniciarJuegoBtGame.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							// reiniciar iconos de botones
							posicion0_0BtGame.setIcon(null);
							posicion0_1BtGame.setIcon(null);
							posicion0_2BtGame.setIcon(null);
							posicion1_0BtGame.setIcon(null);
							posicion1_1BtGame.setIcon(null);
							posicion1_2BtGame.setIcon(null);
							posicion2_0BtGame.setIcon(null);
							posicion2_1BtGame.setIcon(null);
							posicion2_2BtGame.setIcon(null);

							// reiniciar matriz del juego
							littleGame.reiniciarJuego();

							// reinica jugador que empieza
							jugador = 1;

							// reinicar puntaje
							littleGame.setPuntaje1(0);
							littleGame.setPuntaje2(0);

							// reiniciar mensajes de puntajes
							mensaje1LbJuego
									.setText("Puntaje " + littleGame.getNickname1() + ": " + littleGame.getPuntaje1());
							mensaje2LbJuego
									.setText("Puntaje " + littleGame.getNickname2() + ": " + littleGame.getPuntaje2());
							mensaje4LbJuego.setText("Juega jugador: " + littleGame.getNickname1());

						}
					});
					reiniciarJuegoBtGame.setBounds(370, 430, 100, 20);
					panelJuego.add(reiniciarJuegoBtGame);

				// excepcion
				} catch (NullPointerException nfe) {
					JOptionPane.showMessageDialog(jugarBtn, "No ingresó NickNames", "Error", 2);
				}

			}

		});
		jugarBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		jugarBtn.setBounds(153, 196, 109, 33);
		panelPresentacion.add(jugarBtn);

	}

	// metodo para creacion de botones
	void CreacionDeBotones(TrickyPanel panelJuego, TrickyPlayer littleGame, JButton boton, int posicionMatrizX,
			int posicionMatrizY, int posicionX, int posicionY) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// verificacion que la casilla no ha sido usada
				if (littleGame.matrix[posicionMatrizX][posicionMatrizY] == 0) {
					
					// ejecucion de metodo ganador para determinar si hubo algun ganador
					if (littleGame.ganador(jugador, posicionMatrizX, posicionMatrizY) == 1) {
						
						// generacion de ventana emergerte comunicando el ganador de la partida
						JOptionPane.showMessageDialog(boton, ("Gana jugador " + littleGame.getGanador()), "Ganador", 2);

						// si hubo ganador se reinicia los iconos
						posicion0_0BtGame.setIcon(null);
						posicion0_1BtGame.setIcon(null);
						posicion0_2BtGame.setIcon(null);
						posicion1_0BtGame.setIcon(null);
						posicion1_1BtGame.setIcon(null);
						posicion1_2BtGame.setIcon(null);
						posicion2_0BtGame.setIcon(null);
						posicion2_1BtGame.setIcon(null);
						posicion2_2BtGame.setIcon(null);

						// reinicia el jugador que empieza
						jugador = 1;
						
						// actualizar puntajes de jugadores
						mensaje1LbJuego
								.setText("Puntaje " + littleGame.getNickname1() + ": " + littleGame.getPuntaje1());
						mensaje2LbJuego
								.setText("Puntaje " + littleGame.getNickname2() + ": " + littleGame.getPuntaje2());
						
						// actualizar mensajes de jugador actual
						mensaje4LbJuego.setText("Juega jugador: " + littleGame.getNickname1());
						
					// verificacion si no hubo ningun ganador y no se han llenado todas la casillas
					} else if (littleGame.ganador(jugador, posicionMatrizX, posicionMatrizY) == 3) {
						
						// verificacion de  qué jugador jugó, en este caso jugador 1
						if (jugador == 1) {

							// se configura el boton presionado para que aparezca imagen correspondiente
							ImageIcon cruz = new ImageIcon(getClass().getResource("/Imagenes/cruz.png"));
							Icon cruzIcon = new ImageIcon(cruz.getImage().getScaledInstance(boton.getWidth(),
									boton.getHeight(), Image.SCALE_DEFAULT));
							boton.setIcon(cruzIcon);

							// actualizacion de siguiente jugador
							jugador = 2;
							mensaje4LbJuego.setText("Juega jugador: " + littleGame.getNickname2());
						
						// verificacion de  qué jugador jugó, en este caso jugador 1
						} else {

							// se configura el boton presionado para que aparezca imagen correspondiente
							ImageIcon circulo = new ImageIcon(getClass().getResource("/Imagenes/circulo.png"));
							Icon circuloIcon = new ImageIcon(circulo.getImage().getScaledInstance(boton.getWidth(),
									boton.getHeight(), Image.SCALE_DEFAULT));
							boton.setIcon(circuloIcon);
							
							// actualizacion de siguiente jugador
							jugador = 1;
							mensaje4LbJuego.setText("Juega jugador: " + littleGame.getNickname1());
						}

					// si se acabo el juego y no hubo ganador
					} else if (littleGame.ganador(jugador, posicionMatrizX, posicionMatrizY) == 0) {

						// reinicio de botones
						posicion0_0BtGame.setIcon(null);
						posicion0_1BtGame.setIcon(null);
						posicion0_2BtGame.setIcon(null);
						posicion1_0BtGame.setIcon(null);
						posicion1_1BtGame.setIcon(null);
						posicion1_2BtGame.setIcon(null);
						posicion2_0BtGame.setIcon(null);
						posicion2_1BtGame.setIcon(null);
						posicion2_2BtGame.setIcon(null);

						// ventana emergente que comunica que no gano nadie
						JOptionPane.showMessageDialog(boton, "Nadie Gano", "Error", 2);

						// actualizacion de siguiente jugador
						jugador = 1;
						littleGame.reiniciarJuego();
					}
				}
			}
		});
		boton.setBounds(posicionX, posicionY, 90, 90);
		boton.setBackground(new Color(135, 200, 150));
		panelJuego.add(boton);
	}

	// creacion de metodos getters y setters
	public TrickyPanel getPanelJuego() {
		return panelJuego;
	}

	public void setPanelJuego(TrickyPanel panelJuego) {
		this.panelJuego = panelJuego;
	}

	public TrickyPanelPresentacion getPanelPresentacion() {
		return panelPresentacion;
	}

	public void setPanelPresentacion(TrickyPanelPresentacion panelPresentacion) {
		this.panelPresentacion = panelPresentacion;
	}

	public JLabel getMensaje1LbJuego() {
		return mensaje1LbJuego;
	}

	public void setMensaje1LbJuego(JLabel mensaje1LbJuego) {
		this.mensaje1LbJuego = mensaje1LbJuego;
	}

	public JLabel getMensaje2LbJuego() {
		return mensaje2LbJuego;
	}

	public void setMensaje2LbJuego(JLabel mensaje2LbJuego) {
		this.mensaje2LbJuego = mensaje2LbJuego;
	}

	public JLabel getMensaje4LbJuego() {
		return mensaje4LbJuego;
	}

	public void setMensaje4LbJuego(JLabel mensaje4LbJuego) {
		this.mensaje4LbJuego = mensaje4LbJuego;
	}

	public JButton getJugarBtn() {
		return jugarBtn;
	}

	public void setJugarBtn(JButton jugarBtn) {
		this.jugarBtn = jugarBtn;
	}

	public JButton getPosicion0_0BtGame() {
		return posicion0_0BtGame;
	}

	public void setPosicion0_0BtGame(JButton posicion0_0BtGame) {
		this.posicion0_0BtGame = posicion0_0BtGame;
	}

	public JButton getPosicion0_1BtGame() {
		return posicion0_1BtGame;
	}

	public void setPosicion0_1BtGame(JButton posicion0_1BtGame) {
		this.posicion0_1BtGame = posicion0_1BtGame;
	}

	public JButton getPosicion0_2BtGame() {
		return posicion0_2BtGame;
	}

	public void setPosicion0_2BtGame(JButton posicion0_2BtGame) {
		this.posicion0_2BtGame = posicion0_2BtGame;
	}

	public JButton getPosicion1_0BtGame() {
		return posicion1_0BtGame;
	}

	public void setPosicion1_0BtGame(JButton posicion1_0BtGame) {
		this.posicion1_0BtGame = posicion1_0BtGame;
	}

	public JButton getPosicion1_1BtGame() {
		return posicion1_1BtGame;
	}

	public void setPosicion1_1BtGame(JButton posicion1_1BtGame) {
		this.posicion1_1BtGame = posicion1_1BtGame;
	}

	public JButton getPosicion1_2BtGame() {
		return posicion1_2BtGame;
	}

	public void setPosicion1_2BtGame(JButton posicion1_2BtGame) {
		this.posicion1_2BtGame = posicion1_2BtGame;
	}

	public JButton getPosicion2_0BtGame() {
		return posicion2_0BtGame;
	}

	public void setPosicion2_0BtGame(JButton posicion2_0BtGame) {
		this.posicion2_0BtGame = posicion2_0BtGame;
	}

	public JButton getPosicion2_1BtGame() {
		return posicion2_1BtGame;
	}

	public void setPosicion2_1BtGame(JButton posicion2_1BtGame) {
		this.posicion2_1BtGame = posicion2_1BtGame;
	}

	public JButton getPosicion2_2BtGame() {
		return posicion2_2BtGame;
	}

	public void setPosicion2_2BtGame(JButton posicion2_2BtGame) {
		this.posicion2_2BtGame = posicion2_2BtGame;
	}

	public JButton getReiniciarJuegoBtGame() {
		return reiniciarJuegoBtGame;
	}

	public void setReiniciarJuegoBtGame(JButton reiniciarJuegoBtGame) {
		this.reiniciarJuegoBtGame = reiniciarJuegoBtGame;
	}

	public int getJugador() {
		return jugador;
	}

	public void setJugador(int jugador) {
		this.jugador = jugador;
	}

}

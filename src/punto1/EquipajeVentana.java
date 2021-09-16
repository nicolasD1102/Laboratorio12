/*
 * Programa: Punto 1 del Laboratorio 12
 * Autor: Miguel Nicolas Diaz Vargas
 * Fecha: Agosto 9 de 2021
 */

package punto1;

// importaciones
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Component;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class EquipajeVentana extends JFrame {

	// Variables de instancia
	private EquipajePanel panel;
	private JButton sortearBt;
	private JButton BorrarBt;
	int aleatorio = 0;

	// metodo constructor
	public EquipajeVentana() {

		// definicion de caracteristicas del Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // para que cuando sea cerrada la ventana, deje de usar recursos
		setBounds(100, 100, 400, 300);
		setContentPane(panel = new EquipajePanel());
		panel.getCantidadJSp().setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		setTitle("Revisados: " + panel.getRevisados() + "   No revisados: " + panel.getNoRevisados());// titulo de la ventana

		// definicion de boton
		sortearBt = new JButton("Sortear");
		sortearBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // definicion de accion al presional

				// declaracion de variable aleatorio
				int aleatorio = 0;
				
				// if para saber qué tipo de aleatorio ejecutar dependiendo de Interior o Exterior
				if (panel.getProcedenciaJCB().getSelectedItem() == "Interior") {
					
					// si la cantidad de maletas menor a 5 y mayor a 0 se usa la aletoriedad 
					if (((Integer) panel.getCantidadJSp().getValue()) <= 5
							&&  ((Integer)panel.getCantidadJSp().getValue()) >= 0) {

						aleatorio = (int) Math.floor(Math.random() * 3 + 1);
						
						// si el aleatorio es 1 entonces entonces se revisa y se aumenta el numero de revisados, igual de modo contrario
						if (aleatorio == 1) {
							panel.setRevisar(true);
							panel.setRevisados(panel.getRevisados() + 1);
						} else {
							panel.setRevisar(false);
							panel.setNoRevisados(panel.getNoRevisados() + 1);
						}

					// si es mayor a 5 y menor a 10 se revisa
					} else if (((Integer) panel.getCantidadJSp().getValue()) > 5
							&& ((Integer) panel.getCantidadJSp().getValue()) <= 10) {
						panel.setRevisar(true);
						panel.setRevisados(panel.getRevisados() + 1);
					
					// si es mayor a 10 entonces no deja avanzar
					} else {
						JOptionPane.showMessageDialog(sortearBt, "Seleccione una cantidad de bultos ente 1 y 10",
								"Error", 2);
					}

				// si es exterior se aplican nuevas condiciones
				} else if (panel.getProcedenciaJCB().getSelectedItem() == "Exterior") {
					
					// si el numero de maletas es mayor a 0 y menor a 5 se toma el aleatorio
					if (((Integer) panel.getCantidadJSp().getValue()) <= 5
							&& ((Integer) panel.getCantidadJSp().getValue()) >= 0) {

						aleatorio = (int) Math.floor(Math.random() * 7 + 1);

						// si es 2 y 4 entonces se revisa
						if (aleatorio == 2 || aleatorio == 4) {
							panel.setRevisar(true);
							panel.setRevisados(panel.getRevisados() + 1);
						} else {
							panel.setRevisar(false);
							panel.setNoRevisados(panel.getNoRevisados() + 1);
						}

					// si el numero de maletas es mayor a 5 y menor a 10 se revisa
					} else if (((Integer) panel.getCantidadJSp().getValue()) > 5
							&& ((Integer) panel.getCantidadJSp().getValue()) <= 10) {
						panel.setRevisar(true);
						panel.setRevisados(panel.getRevisados() + 1);
					
					// si es mayor a 10 no deja avanzar
					} else {
						JOptionPane.showMessageDialog(sortearBt, "Seleccione una cantidad de bultos ente 1 y 10",
								"Error", 2);
					}
					
				// no deja avanzar si no se selecciona procedencia
				} else {
					JOptionPane.showMessageDialog(sortearBt, "No selecciono una procedencia", "Error", 2);
				}
				
				// opcion para repintar la el punto
				repaint();
				// aplicar titulo con nuevos valores de revisado y no revisados
				setTitle("Revisados: " + panel.getRevisados() + "   No revisados: " + panel.getNoRevisados());
			}
		});
		sortearBt.setBounds(10, 117, 126, 22);
		panel.add(sortearBt);

		// boton de reiniciar datos 
		BorrarBt = new JButton("Reiniciar Datos");
		BorrarBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.getCantidadJSp().setValue (0);
				panel.getProcedenciaJCB().setSelectedItem ("-Seleccione-");
			}
		});
		BorrarBt.setBounds(160, 117, 126, 22);
		panel.add(BorrarBt);

	}
	
	// metodo para pintar punto
	public void paint(Graphics g) {

		super.paint(g);

		if (panel.isRevisar() == false) {
			g.setColor(Color.RED);
			g.fillOval(50, 210, 50, 50);
		} else if (panel.isRevisar() == true) {
			g.setColor(Color.GREEN);
			g.fillOval(50, 210, 50, 50);
		}

	}
	
}

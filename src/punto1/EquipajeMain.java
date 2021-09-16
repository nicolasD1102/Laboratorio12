/*
 * Programa: Punto 1 del Laboratorio 12
 * Autor: Miguel Nicolas Diaz Vargas
 * Fecha: Agosto 9 de 2021
 */

package punto1;

import java.awt.EventQueue;


public class EquipajeMain {
	
	// main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// declaracion del frame
					EquipajeVentana frame = new EquipajeVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

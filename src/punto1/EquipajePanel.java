/*
 * Programa: Punto 1 del Laboratorio 12
 * Autor: Miguel Nicolas Diaz Vargas
 * Fecha: Agosto 9 de 2021
 */

package punto1;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

// creacion del panel del grame
public class EquipajePanel extends JPanel{

	// declaracion de variable / objetos de la ventana
	private JLabel tituloLb;
	private JLabel mensaje1Lb;
	private JLabel mensaje2Lb;
	private JLabel mensaje3Lb;
	private JSpinner cantidadJSp;
	private JComboBox procedenciaJCB;
	private boolean revisar = false; 
	private int revisados = 0;
	private int noRevisados = 0;
	
	// declaracion de metodo constructor
	public EquipajePanel () {
		
		// configuracion de caracteristicas del panel
		this.setBackground(new Color(135, 206, 235));
		this.setForeground(SystemColor.textHighlight);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		// configuracion de titulo principal
		tituloLb = new JLabel(); 
		tituloLb.setHorizontalAlignment(SwingConstants.LEFT);
		tituloLb.setForeground(new Color(0, 0, 0));
		tituloLb.setFont(new Font("Cambria", Font.PLAIN, 20));
		tituloLb.setBounds(10, 11, 204, 22);
		tituloLb.setText("Sorteador de Personas");
		this.add(tituloLb);
		
		// configuracion de mensajes
		mensaje1Lb = new JLabel("Cantidad de bultos:");
		mensaje1Lb.setHorizontalAlignment(SwingConstants.LEFT);
		mensaje1Lb.setFont(new Font("Dialog", Font.PLAIN, 12));
		mensaje1Lb.setBounds(10, 44, 114, 22);
		this.add(mensaje1Lb);
		
		mensaje2Lb = new JLabel("Procedencia: ");
		mensaje2Lb.setHorizontalAlignment(SwingConstants.LEFT);
		mensaje2Lb.setFont(new Font("Dialog", Font.PLAIN, 12));
		mensaje2Lb.setBounds(160, 44, 114, 22);
		this.add(mensaje2Lb);
		
		mensaje3Lb = new JLabel("Resultado:");
		mensaje3Lb.setHorizontalAlignment(SwingConstants.LEFT);
		mensaje3Lb.setFont(new Font("Dialog", Font.PLAIN, 12));
		mensaje3Lb.setBounds(10, 150, 114, 22);
		this.add(mensaje3Lb);
		
		// configuracion de spinner
		cantidadJSp = new JSpinner();
		cantidadJSp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cantidadJSp.setBounds(10, 77, 126, 21);
		this.add(cantidadJSp);
		
		// declaracion de ComboBox
		procedenciaJCB = new JComboBox();
		procedenciaJCB.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione-", "Interior", "Exterior"}));
		procedenciaJCB.setBounds(160, 76, 126, 22);
		this.add(procedenciaJCB);
		
	}

	// declaracion de getter y setters
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

	public JLabel getMensaje3Lb() {
		return mensaje3Lb;
	}

	public void setMensaje3Lb(JLabel mensaje3Lb) {
		this.mensaje3Lb = mensaje3Lb;
	}

	public JSpinner getCantidadJSp() {
		return cantidadJSp;
	}

	public void setCantidadJSp(JSpinner cantidadJSp) {
		this.cantidadJSp = cantidadJSp;
	}

	public JComboBox getProcedenciaJCB() {
		return procedenciaJCB;
	}

	public void setProcedenciaJCB(JComboBox procedenciaJCB) {
		this.procedenciaJCB = procedenciaJCB;
	}

	public boolean isRevisar() {
		return revisar;
	}

	public void setRevisar(boolean revisar) {
		this.revisar = revisar;
	}

	public int getRevisados() {
		return revisados;
	}

	public void setRevisados(int revisados) {
		this.revisados = revisados;
	}

	public int getNoRevisados() {
		return noRevisados;
	}

	public void setNoRevisados(int noRevisados) {
		this.noRevisados = noRevisados;
	}
	
}

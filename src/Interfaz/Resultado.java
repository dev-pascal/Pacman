package Interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Resultado extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public Resultado() {
		
	}
	
	public void printResultado(String resultado) {
		this.setSize(310,310);
		JLabel lb = new JLabel(new ImageIcon(resultado+".png"));
		this.setBackground(Color.BLACK);
		this.add(lb);
	}
	
	public JPanel getPanel() {
		return this;
	}
}

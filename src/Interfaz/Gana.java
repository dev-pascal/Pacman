package Interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gana extends JPanel {
	public Gana () {
		this.setSize(310,310);
		JLabel lb = new JLabel(new ImageIcon("won.png"));
		this.setBackground(Color.BLACK);
		this.add(lb);
		this.setVisible(true);
	}
	public JPanel getPanel () {
		return this;
	}
}

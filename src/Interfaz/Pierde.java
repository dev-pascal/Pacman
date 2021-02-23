package Interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pierde extends JPanel {
	public Pierde () {
		this.setSize(310,310);
		JLabel lb = new JLabel(new ImageIcon("lose.png"));
		this.setBackground(Color.BLACK);
		this.add(lb);
		this.setVisible(true);
	}
	public JPanel getPanel() {
		return this;
	}
}

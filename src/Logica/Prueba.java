package Logica;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Prueba extends JFrame {
	public Prueba () {
		this.setTitle("hola");
		this.setSize(310,310);
		JLabel lb = new JLabel(new ImageIcon("lose.png"));
		this.getContentPane().setBackground(Color.BLACK);
		this.add(lb);
		this.setVisible(true);
		this.repaint();
	}
	public static void main (String args[]) {
		new Prueba();
	}
}

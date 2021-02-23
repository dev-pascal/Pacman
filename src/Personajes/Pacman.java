package Personajes;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enumerativos.Direccion;
import Enumerativos.Identificador;
import Interfaz.Gana;
import Interfaz.Pierde;
import Logica.Juego;
import Logica.Posicion;

public class Pacman extends Personaje implements Runnable, KeyListener {
	
	private int puntaje;
	
	public Pacman() {
		super();
	}
	
	public Pacman(Juego juego, Posicion pos) {
		super(juego, Identificador.Pacman, pos);
	}
	
	public void comenzarJugada() {
		new Thread(this).start();
	}
	
	public void setPuntaje (int puntaje) {
		this.puntaje=puntaje;
	}
	
	public int getPuntaje () {
		return this.puntaje;
	}
	
	public void run() {
		int i = this.getPos().getX();
		int j = this.getPos().getY();
		Juego.v[i][j].ocuparCasillero(this);
		Juego.v[i][j].getLabel().setIcon(new ImageIcon(this.getDerecha()));
		this.getJuego().addKeyListener(this);
			try {
				TimeUnit.MILLISECONDS.sleep(400);
				while (this.getVida()==1 && this.getPuntaje()<420) {
					super.mover(this.getDireccion());
					TimeUnit.MILLISECONDS.sleep(400);
				}
				this.getJuego().getContentPane().removeAll();
				JPanel nue = null;
				int milsec = 1500;
				if (this.getVida()==0) {
					nue = new Pierde().getPanel();
				}
				else {
					nue = new Gana().getPanel();
				}
				TimeUnit.MILLISECONDS.sleep(milsec);
				this.getJuego().setContentPane(nue);
				this.getJuego().getContentPane().revalidate();
				this.getJuego().getContentPane().repaint();
				TimeUnit.MILLISECONDS.sleep(2500);
				System.exit(0);
			}
			catch (InterruptedException e) {
				throw new RuntimeException();
		    }
		}
		@Override
		public void keyPressed(KeyEvent e) {
			String tecla = KeyEvent.getKeyText(e.getKeyCode());
			if (tecla.equals("Arriba") || tecla.equals("Abajo") || tecla.equals("Izquierda") || tecla.equals("Derecha")) {
				this.setDireccion(Direccion.valueOf(Direccion.class, tecla));
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
}

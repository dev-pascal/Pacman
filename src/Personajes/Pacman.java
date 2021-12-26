package Personajes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import Enumerativos.Direccion;
import Enumerativos.Identificador;
import Interfaz.Bolita;
import Interfaz.Casillero;
import Interfaz.Resultado;
import Interfaz.Imagen;
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
	
	public void run() {
		/*Muestra Pacman en pantalla*/
		int i = this.getPos().getX();
		int j = this.getPos().getY();
		this.setDireccion(Direccion.Right);
		Juego.getCasillero(i,j).ocuparCasillero(this, this.getDireccionPixel(this.getDireccion()));
		this.getJuego().addKeyListener(this);
			try {
				TimeUnit.MILLISECONDS.sleep(400);
				while (this.getVida()==1 && this.getPuntaje()<420) {
					mover(this.getDireccion());
					TimeUnit.MILLISECONDS.sleep(400);
				}
				this.getJuego().getContentPane().removeAll();
				JPanel screenLose = null;
				int milsec = 1500;
				Resultado resultadoFinal = new Resultado();
				if (this.getVida()==0) {
					resultadoFinal.printResultado("img/lose");
				}
				else {
					resultadoFinal.printResultado("img/won");
				}
				screenLose = resultadoFinal.getPanel();
				TimeUnit.MILLISECONDS.sleep(milsec);
				this.getJuego().setContentPane(screenLose);
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
		if (tecla.equals("Up") || tecla.equals("Down") || tecla.equals("Left") || tecla.equals("Right")) {
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
	
	public void pasarPorBolita(Imagen ant) {
		Casillero casilleroAct = Juego.getCasillero(this.getPos().getX(), this.getPos().getY());
		Bolita bolita = (Bolita) casilleroAct.getComida();
		ant.setUrl("img/vacio.png");
		casilleroAct.setComida(null);
		(bolita).sumarPuntos((Pacman) this);
	}
	
	public void setPuntaje (int puntaje) {
		this.puntaje=puntaje;
	}
	
	public int getPuntaje () {
		return this.puntaje;
	}
		
}

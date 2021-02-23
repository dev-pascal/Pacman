package Logica;

import javax.swing.ImageIcon;

import Enumerativos.Direccion;
import Interfaz.Casillero;
import Personajes.Blinky;
import Personajes.Fantasma;
import Personajes.Pacman;
import Personajes.Personaje;

public class Controladora {
	
	private static Controladora instancia = null;
	private static boolean colision;
	
	public static void instanciar () {
		if (instancia==null) {
			instancia = new Controladora();
		}
	}
	
	public static Controladora getInstancia() {
		return instancia;
	}
	
	public static boolean hayColision() {
		return colision;
	}
	
	public static void setColision(boolean nuevaColision) {
		colision=nuevaColision;
	}
	
	public static boolean hayColisiones (Casillero casillero, Personaje personaje, Direccion direccion) {
		//el chocado-- casillero
		//el que choca -- personaje
		int i = casillero.getPos().getX();
		int j = casillero.getPos().getY();
		setColision(true);
		if (Juego.getCasillero(i,j).getEntidad()!=null) {
			/*El Fantasma choca al pacman*/
			if (casillero.getEntidad() instanceof Pacman && personaje instanceof Fantasma) {
				casillero.getLabel().setIcon(new ImageIcon("vacio.png"));
				Pacman pacman = (Pacman) casillero.getEntidad();
				casillero.desocuparCasillero(false);
				pacman.setVida(0);
				pacman.setPos(new Posicion(10,0));
			}
			else {
				/*El Pacman choca al fantasma*/
				if (personaje instanceof Pacman && casillero.getEntidad() instanceof Fantasma) {
					Casillero casilleroPacman = Juego.getCasillero(personaje.getPos().getX(), personaje.getPos().getY());
					casilleroPacman.desocuparCasillero(false);
					casilleroPacman.getLabel().setIcon(new ImageIcon("vacio.png"));
					personaje.setVida(0);
					personaje.setPos(new Posicion(10,0));
				}
				/*Ambos fantasmas tocan el mismo casillero, pueden atravesarse entre ellos pues son fantasmas...*/
				if (personaje instanceof Fantasma && casillero.getEntidad() instanceof Fantasma) {
					setColision(false);
				}
			}
		}
		else {
			setColision(false);
		}
		return hayColision();
	}
}

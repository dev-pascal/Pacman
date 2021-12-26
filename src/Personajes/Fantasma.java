package Personajes;

import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

import Enumerativos.Direccion;
import Enumerativos.Identificador;
import Interfaz.Bolita;
import Interfaz.Casillero;

import java.util.Random;

import Interfaz.Imagen;
import Logica.Juego;
import Logica.Posicion;

public class Fantasma extends Personaje implements Runnable {

	public Fantasma(Juego juego, Identificador nombre, Posicion posicion) {
		super(juego, nombre, posicion);
	}

	public void comenzarJugada() {
		new Thread(this).start();
	}
	
	public void run() {
		int i = this.getPos().getX();
		int j = this.getPos().getY();
		this.setDireccion(Direccion.Right);
		Juego.v[i][j].ocuparCasillero(this, this.getDireccionPixel(this.getDireccion()));
		String [] arreglo = {"Up", "Down", "Left", "Right"};
		while (true) {
			int random = (int) Math.floor(Math.random()*(3-0+1)+0);
			Direccion direccion = Direccion.valueOf(Direccion.class, arreglo[random]);
			Casillero casillero = Juego.getCasillero(this.getPos().getX(), this.getPos().getY());
			if (casillero.getSig(direccion, this)!=null) {
				this.setDireccion(direccion);
				for (int k=0;k<4;k++) {
					mover(this.getDireccion());
					try {
						TimeUnit.MILLISECONDS.sleep(390);
					}
					catch (InterruptedException e) {
						throw new RuntimeException();
					}
				}
			}
		}
	}
	
	public void pasarPorBolita(Imagen ant) {
		ant.setUrl("img/puntos.png");
	}
}

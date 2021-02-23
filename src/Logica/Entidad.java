package Logica;

import Interfaz.Bolita;
import Personajes.Pacman;

public class Entidad {
	
	private Posicion pos;
	
	public Entidad () {
	}
	
	public Entidad (Posicion pos) {
		this.pos=pos;
	}
	
	public Posicion getPos () {
		return this.pos;
	}
	
	public void setPos (Posicion pos) {
		this.pos=pos;
	}
	
}

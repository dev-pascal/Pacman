package Interfaz;

import Logica.Entidad;
import Logica.Posicion;
import Personajes.Pacman;

public abstract class Comida {
	
	private int puntos;
	
	public Comida () {
	}
	
	public Comida (int puntos) {
		this.puntos=puntos;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public abstract void sumarPuntos (Pacman pacman);
	
}

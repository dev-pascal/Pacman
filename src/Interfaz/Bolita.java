package Interfaz;

import Logica.Posicion;
import Personajes.Pacman;

public class Bolita extends Comida {

	public Bolita () {
		super(10);
	}
	
	@Override
	public void sumarPuntos(Pacman pacman) {
		pacman.setPuntaje(pacman.getPuntaje()+super.getPuntos());
	}

}

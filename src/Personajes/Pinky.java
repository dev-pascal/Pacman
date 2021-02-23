package Personajes;

import Enumerativos.Identificador;
import Logica.Juego;
import Logica.Posicion;

public class Pinky extends Fantasma {
	
	public Pinky(Juego juego, Posicion posicion) {
		super(juego, Identificador.Pinky, posicion);
	}
	
	public void comenzarJugada () {
		super.comenzarJugada();
	}

}
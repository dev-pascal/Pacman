package Personajes;

import Enumerativos.Identificador;
import Logica.Juego;
import Logica.Posicion;

public class Blinky extends Fantasma {
	
	public Blinky(Juego juego, Posicion posicion) {
		super(juego, Identificador.Blinky, posicion);
	}
	
	public void comenzarJugada () {
		super.comenzarJugada();
	}

}

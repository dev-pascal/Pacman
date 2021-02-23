package Personajes;

import Enumerativos.Identificador;
import Logica.Juego;
import Logica.Posicion;

public class Clyde extends Fantasma {
	
	public Clyde(Juego juego, Posicion posicion) {
		super(juego, Identificador.Clyde, posicion);
	}
	
	public void comenzarJugada () {
		super.comenzarJugada();
	}

}
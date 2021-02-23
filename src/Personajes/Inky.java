package Personajes;

import Enumerativos.Identificador;
import Logica.Juego;
import Logica.Posicion;

public class Inky extends Fantasma {
	
	public Inky(Juego juego, Posicion posicion) {
		super(juego, Identificador.Inky, posicion);
	}
	
	public void comenzarJugada () {
		super.comenzarJugada();
	}

}
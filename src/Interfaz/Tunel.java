package Interfaz;

import Logica.Posicion;

public class Tunel extends Casillero {

	public Tunel(Posicion pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	public void loop(Posicion pos) {
		switch (pos.getX()) {
			case 0:
				pos.setX(17);
				break;
			case 17:
				pos.setX(0);
				break;
		}
		switch (pos.getY()) {
			case 0:
				pos.setY(17);
				break;
			case 17:
				pos.setY(0);
				break;
		}
	}

}

package Interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Enumerativos.Direccion;
import Logica.Controladora;
import Logica.Entidad;
import Logica.Juego;
import Logica.Posicion;
import Personajes.Pacman;
import Personajes.Personaje;

public abstract class Casillero {
	private Comida comida;
	private Posicion pos;
	private JLabel label;
	private Entidad entidad;
	private boolean ocupado;
	/*Hay un obstaculo cuando entidad==null y ocupado==true
	Es vacio cuando entidad == null y ocupado == false
	Hay un personaje cuando entidad!=null y ocupado==true
	Ignoren el comentario de arriba creo que es mentira :v*/
	
	public Casillero(Posicion pos) {
		this.pos = pos;
	}
	
	public Casillero(Posicion pos, Comida comida) {
		this.pos=pos;
		this.comida=comida;
	}
	
	public Comida getComida() {
		return comida;
	}

	public void setComida(Comida comida) {
		this.comida = comida;
	}

	public Posicion getPos() {
		return pos;
	}

	public void setPos(Posicion pos) {
		this.pos = pos;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public boolean estaOcupado () {
		return this.ocupado;
	}
	
	public Entidad getEntidad () {
		return this.entidad;
	}
	
	public void setEntidad (Entidad entidad) {
		this.entidad=entidad;
	}
	
	public void ocuparCasillero (Entidad entidad) {
		if (!(entidad instanceof Personaje)) {
			this.ocupado=true;
		}
		this.setEntidad(entidad);
	}
	
	public void desocuparCasillero(boolean hayBolita) {
		if (!hayBolita) {
			this.entidad=null;
		}
		this.ocupado=false;
	}

	public Casillero getSig (Direccion direccion, Personaje personaje) {
		int i = this.pos.getX();
		int j = this.pos.getY();
		Posicion pos = new Posicion(i,j);
		Casillero respuesta = null;
		boolean exito = false;
		if (i>0 && (i+1)<18) {
			switch (direccion.getDireccion()) {
				case ("Arriba"):
					pos.actualizar(0, -1);
					i--;
					exito=true;
					break;
				case ("Abajo"):
					pos.actualizar(0, 1);
					i++;
					exito=true;
					break;
				}
		}
		else {
			if (i==0) {
				switch (direccion.getDireccion()) {
					case ("Abajo"):
						pos.actualizar(0, 1);
						i++;
						exito=true;
						break;
					case ("Arriba"):
						if (this instanceof Tunel) {
							pos.setX(17);
							i=17;
							exito=true;
						}
						break;
				}
			}
			else {
				if (i==17) {
					switch (direccion.getDireccion()) {
						case ("Arriba"):
							pos.actualizar(0, -1);
							i--;
							exito=true;
							break;
						case ("Abajo"):
							if (this instanceof Tunel) {
								pos.setX(0);
								i=0;
								exito=true;
							}
							break;
					}
				}
			}
		}
		if (j>0 && (j+1)<18) {
			switch (direccion.getDireccion()) {
				case ("Izquierda"):
					pos.actualizar(-1, 0);
					j--;
					exito=true;
					break;
				case ("Derecha"):
					pos.actualizar(1, 0);
					j++;
					exito=true;
					break;
			}
		}
		else {
			if (j==0) {
				switch (direccion.getDireccion()) {
					case ("Derecha"):
						pos.actualizar(1,0);
						exito=true;
						j++;
						break;
					case ("Izquierda"):
						if (this instanceof Tunel) {
							pos.setY(17);
							j=17;
							exito=true;
						}
						break;
				}
			}
			else {
				if (j==17) {
					switch (direccion.getDireccion()) {
						case ("Izquierda"):
							pos.actualizar(-1,0);
							j--;
							exito=true;
							break;
						case ("Derecha"):
							if (this instanceof Tunel) {
								pos.setY(0);
								j=0;
								exito=true;
							}
							break;
					}	
				}
			}
		}
		if (exito && !Juego.getCasillero(i,j).estaOcupado()) {
			respuesta=Juego.getCasillero(i,j);
			respuesta.setPos(new Posicion(i,j));
			exito=Controladora.hayColisiones(respuesta, personaje, direccion);
			if (exito) {
				respuesta=null;
			}
		}
		return respuesta;
	}
	
}

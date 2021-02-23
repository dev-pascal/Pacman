package Personajes;

import javax.swing.ImageIcon;

import Enumerativos.Direccion;
import Enumerativos.Identificador;
import Interfaz.Bolita;
import Interfaz.Casillero;
import Interfaz.Comida;
import Logica.Entidad;
import Logica.Juego;
import Logica.Posicion;

public abstract class Personaje extends Entidad {
	
	private Juego juego;
	private Direccion direccion = Direccion.Derecha;
	private Identificador nombre;
	private int vida=1;
	private String [] urlImgs = new String [4];
	
	public Personaje () {
		super();
	}
	
	public Personaje (Juego juego, Identificador nombre, Posicion pos) {
		super(pos);
		this.juego=juego;
		this.nombre=nombre;
		switch (nombre.getID()) {
			case ("Pacman"):
				this.urlImgs[0]="pacman_right.png";
				this.urlImgs[1]="pacman_left.png";
				this.urlImgs[2]="pacman_down.png";
				this.urlImgs[3]="pacman_up.png";
				break;
			case ("Blinky"):
				this.urlImgs[0]="blinky_right.png";
				this.urlImgs[1]="blinky_left.png";
				this.urlImgs[2]="blinky_right.png";
				this.urlImgs[3]="blinky_left.png";
				break;
			case ("Inky"):
				this.urlImgs[0]="inky_right.png";
				this.urlImgs[1]="inky_left.png";
				this.urlImgs[2]="inky_right.png";
				this.urlImgs[3]="inky_left.png";
				break;
			case ("Clyde"):
				this.urlImgs[0]="clyde_right.png";
				this.urlImgs[1]="clyde_left.png";
				this.urlImgs[2]="clyde_right.png";
				this.urlImgs[3]="clyde_left.png";
				break;
			case ("Pinky"):
				this.urlImgs[0]="pinky_right.png";
				this.urlImgs[1]="pinky_left.png";
				this.urlImgs[2]="pinky_right.png";
				this.urlImgs[3]="pinky_left.png";
				break;
		}
	}
	
	public void setUrlImgs (String [] urlImgs) {
		this.urlImgs = urlImgs;
	}

	public Identificador getNombre() {
		return nombre;
	}

	public void setNombre(Identificador nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getDerecha () {
		return this.urlImgs[0];
	}
	
	public String getIzquierda () {
		return this.urlImgs[1];
	}
	
	public String getAbajo () {
		return this.urlImgs[2];
	}
	
	public String getArriba () {
		return this.urlImgs[3];
	}
	
	public Direccion getDireccion () {
		return this.direccion;
	}
	
	public void setDireccion (Direccion direccion) {
		this.direccion=direccion;
	}
	
	public String getDireccionPixel (Direccion direccion) {
		String respuesta = null;
		switch (direccion.getDireccion()) {
			case ("Derecha"):
				respuesta=urlImgs[0];
				break;
			case ("Izquierda"):
				respuesta=urlImgs[1];
				break;
			case ("Abajo"):
				respuesta=urlImgs[2];
				break;
			case ("Arriba"):
				respuesta=urlImgs[3];
				break;
		}
		return respuesta;
	}
	
	public Juego getJuego () {
		return this.juego;
	}
	
	public void mover(Direccion direccion) {
		Casillero casilleroAct = Juego.getCasillero(this.getPos().getX(), this.getPos().getY());
		Casillero respuesta = casilleroAct.getSig(direccion, this);
		if (respuesta!=null) {
			String ant = null;
			boolean hayBolita = false;
			if (casilleroAct.getComida()!=null) {
				if (casilleroAct.getComida() instanceof Bolita) {
					Bolita bolita = (Bolita) casilleroAct.getComida();
					if (this instanceof Fantasma) {
						ant="puntos.png";
					}
					else {
						if (this instanceof Pacman) {
							ant="vacio.png";
							casilleroAct.setComida(null);
							(bolita).sumarPuntos((Pacman) this);
						}
					}
				}
			}
			else {
				ant="vacio.png";
			}
			this.setPos(respuesta.getPos());
			casilleroAct.desocuparCasillero(hayBolita);
			casilleroAct.getLabel().setIcon(new ImageIcon(ant));
			Casillero casilleroNue = Juego.getCasillero(this.getPos().getX(), this.getPos().getY());
			casilleroNue.ocuparCasillero(this);
			ImageIcon img = new ImageIcon(getDireccionPixel(direccion));
			switch (direccion.getDireccion()) {
				case ("Arriba"):
					img=new ImageIcon(this.getArriba());
					break;
				case ("Abajo"):
					img=new ImageIcon(this.getAbajo());
					break;
				case ("Izquierda"):
					img=new ImageIcon(this.getIzquierda());
					break;
				case ("Derecha"):
					img=new ImageIcon(this.getDerecha());
					break;
			}
			casilleroNue.getLabel().setIcon(img);
		}
	}

	public abstract void comenzarJugada();
}
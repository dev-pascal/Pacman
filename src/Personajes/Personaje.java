package Personajes;

import javax.swing.ImageIcon;

import Enumerativos.Direccion;
import Enumerativos.Identificador;
import Interfaz.Bolita;
import Interfaz.Casillero;
import Interfaz.Comida;
import Logica.Entidad;
import Interfaz.Imagen;
import Logica.Juego;
import Logica.Posicion;

public abstract class Personaje extends Entidad {
	
	private Juego juego;
	private Direccion direccion;
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
				this.urlImgs[0]="img/pacman_right.png";
				this.urlImgs[1]="img/pacman_left.png";
				this.urlImgs[2]="img/pacman_down.png";
				this.urlImgs[3]="img/pacman_up.png";
				break;
			case ("Blinky"):
				this.urlImgs[0]="img/blinky_right.png";
				this.urlImgs[1]="img/blinky_left.png";
				this.urlImgs[2]="img/blinky_right.png";
				this.urlImgs[3]="img/blinky_left.png";
				break;
			case ("Inky"):
				this.urlImgs[0]="img/inky_right.png";
				this.urlImgs[1]="img/inky_left.png";
				this.urlImgs[2]="img/inky_right.png";
				this.urlImgs[3]="img/inky_left.png";
				break;
			case ("Clyde"):
				this.urlImgs[0]="img/clyde_right.png";
				this.urlImgs[1]="img/clyde_left.png";
				this.urlImgs[2]="img/clyde_right.png";
				this.urlImgs[3]="img/clyde_left.png";
				break;
			case ("Pinky"):
				this.urlImgs[0]="img/pinky_right.png";
				this.urlImgs[1]="img/pinky_left.png";
				this.urlImgs[2]="img/pinky_right.png";
				this.urlImgs[3]="img/pinky_left.png";
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
			case ("Right"):
				respuesta=urlImgs[0];
				break;
			case ("Left"):
				respuesta=urlImgs[1];
				break;
			case ("Down"):
				respuesta=urlImgs[2];
				break;
			case ("Up"):
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
			Imagen ant = new Imagen();
			boolean hayBolita = false;
			if (casilleroAct.getComida()!=null) {
				pasarPorBolita(ant);
			}
			else {
				ant.setUrl("img/vacio.png");
			}
			this.setPos(respuesta.getPos());
			casilleroAct.desocuparCasillero(hayBolita, ant.getUrl());
			Casillero casilleroNue = Juego.getCasillero(this.getPos().getX(), this.getPos().getY());
			casilleroNue.ocuparCasillero(this, this.getDireccionPixel(direccion));
		
		}
	}

	public abstract void pasarPorBolita(Imagen img);

	public abstract void comenzarJugada();
}
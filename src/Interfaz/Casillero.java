package Interfaz;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Enumerativos.Direccion;
import Logica.Controladora;
import Logica.Entidad;
import Logica.Juego;
import Logica.Posicion;
import Personajes.Personaje;

public abstract class Casillero {
	private Comida comida;
	private Posicion pos;
	private JLabel label;
	private Entidad entidad;
	private boolean ocupado;
	private String url;
	/*Hay un obstaculo cuando entidad==null y ocupado==true
	Es vacio cuando entidad == null y ocupado == false
	Hay un personaje cuando entidad!=null y ocupado==true
	Ignoren el comentario de Up creo que es mentira :v*/
	
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
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void ocuparCasillero (Entidad entidad, String pixel) {
		if (!(entidad instanceof Personaje)) {
			this.ocupado=true;
		}
		this.setEntidad(entidad);
		this.getLabel().setIcon(new ImageIcon(pixel));
		this.setUrl(pixel);
	}
	
	public void desocuparCasillero(boolean hayBolita, String pixel) {
		if (!hayBolita) {
			this.entidad=null;
		}
		this.ocupado=false;
		this.getLabel().setIcon(new ImageIcon(pixel));
		this.setUrl(pixel);
	}

	public Casillero getSig (Direccion direccion, Personaje personaje) {
		int i = this.pos.getX();
		int j = this.pos.getY();
		Posicion pos = new Posicion(i,j);
		Casillero respuesta = null;
		boolean exito = false;
		if (i>0 && (i+1)<18) {
			switch (direccion.getDireccion()) {
				case ("Up"):
					pos.actualizar(-1,0);
					break;
				case ("Down"):
					pos.actualizar(1,0);
					break;
				}
		}
		else {
			if (i==0) {
				switch (direccion.getDireccion()) {
					case ("Down"):
						pos.actualizar(1,0);
						break;
					case ("Up"):
						loop(pos);
						break;
				}
			}
			else {
				if (i==17) {
					switch (direccion.getDireccion()) {
						case ("Up"):
							pos.actualizar(-1,0);
							break;
						case ("Down"):
							loop(pos);
							break;
					}
				}
			}
		}
		if (j>0 && (j+1)<18) {
			switch (direccion.getDireccion()) {
				case ("Left"):
					pos.actualizar(0,-1);
					break;
				case ("Right"):
					pos.actualizar(0,1);
					break;
			}
		}
		else {
			if (j==0) {
				switch (direccion.getDireccion()) {
					case ("Right"):
						pos.actualizar(0,1);
						break;
					case ("Left"):
						loop(pos);
						break;
				}
			}
			else {
				if (j==17) {
					switch (direccion.getDireccion()) {
						case ("Left"):
							pos.actualizar(0,-1);
							break;
						case ("Right"):
							loop(pos);
							break;
					}	
				}
			}
		}
		//Se almacena la próxima posición según la dirección mandada como parámetro
		i = pos.getX();
		j = pos.getY();
		//Se verifica si está ocupado ese casillero
		if (!Juego.getCasillero(i,j).estaOcupado()) {
			respuesta=Juego.getCasillero(i,j);
			respuesta.setPos(new Posicion(i,j));
			exito=Controladora.hayColisiones(respuesta, personaje, direccion);
			if (exito) {
				respuesta=null;
			}
		}
		return respuesta;
	}
	
	public abstract void loop(Posicion pos);
	
}

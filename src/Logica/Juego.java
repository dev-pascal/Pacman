package Logica;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Interfaz.Bolita;
import Interfaz.Casillero;
import Interfaz.Tunel;
import Interfaz.Vacio;
import Personajes.*;

public class Juego extends JFrame {
	
	private List<Personaje> personajes = new LinkedList<Personaje>();
	private static final long serialVersionUID = 1L;
	public static Casillero [][] v = new Casillero [18][18];
	private static Juego instancia = null;
	private static final int tamaño_nivel = 18;
	
	public static int getTamaño() {
		return tamaño_nivel;
	}
	
	private Juego () {
		
		this.cargarPanel();
		this.cargarMapa();
		Controladora.instanciar();
		this.cargarPersonajes();
		this.setVisible(true);
	}
	
	private void cargarPanel () {
		
		this.setTitle("Pacman");
		this.setSize(310,310);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(tamaño_nivel,tamaño_nivel));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void cargarPersonajes () {
		
		Personaje pacman = new Pacman(this, new Posicion(2,8));
		Fantasma blinky = new Blinky(this, new Posicion(13,10));
		Fantasma inky = new Inky(this, new Posicion(8,0));
		Fantasma clyde = new Clyde(this, new Posicion(1,1));
		Fantasma pinky = new Pinky (this, new Posicion(5,16));
		
		personajes.add(pacman);
		personajes.add(blinky);
		personajes.add(inky);
		personajes.add(clyde);
		personajes.add(pinky);
		
		for (Personaje psj: personajes) {
			psj.comenzarJugada();
		}
		
	}
	
	public static Juego getInstancia () {
		return instancia;
	}
	
	private static void instanciar () {
		if (instancia==null) {
			instancia = new Juego();
		}
	}
	
	public static Casillero getCasillero (int i, int j) {
		return v[i][j];
	}
	
	public static void main (String args[]) {
		instanciar();
	}
	private void cargarMapa () {
		for (int i=0;i<tamaño_nivel;i++) {
			for (int j=0;j<tamaño_nivel;j++) {
				if ((i==8 && j==0) || (i==8 && j==17) || (i==13 && j==0) || (i==13 && j==17) || (i==0 && j==8) || (i==17 || j==8)) {
					v[i][j] = new Tunel(new Posicion(i,j));
				}
				else {
					v[i][j] = new Vacio(new Posicion(i,j));
				}
				if ((i==3 && j==1) || (i==3 && j==7) || (i==3 && j==10) || (i==3 && j==16)) {
					v[i][j] = new Vacio(new Posicion(i,j));
					v[i][j].setComida(new Bolita());
				}
				v[i][j].setLabel(new JLabel(new ImageIcon("img/vacio.png")));
				this.add(v[i][j].getLabel());
			}
		}
		v[0][0].ocuparCasillero(null, "img/obs01.png");
		for (int j=1; j<7; j++) {
			v[0][j].ocuparCasillero(null, ("img/obs5.png"));
		}
		for (int j=10; j<18; j++) {
			v[0][j].ocuparCasillero(null, "img/obs5.png");
		}
		v[0][17].ocuparCasillero(null, "img/obs3.png");
		v[0][17].getLabel().setIcon(new ImageIcon("img/obs3.png"));
		v[6][0].ocuparCasillero(null, "img/obs4.png");
		v[6][0].getLabel().setIcon(new ImageIcon("img/obs4.png"));
		for (int i=1; i<6; i++) {
			v[i][0].ocuparCasillero(null, "img/obs0.png");
			v[i][0].getLabel().setIcon(new ImageIcon("img/obs0.png"));
		}
		for (int i=1; i<6; i++) {
			v[i][17].ocuparCasillero(null, "img/obs0.png");
			v[i][17].getLabel().setIcon(new ImageIcon("img/obs0.png"));
		}
		v[6][17].ocuparCasillero(null, "img/obs6.png");
		v[6][17].getLabel().setIcon(new ImageIcon("img/obs6.png"));
		for (int j=1; j<7; j++) {
			v[6][j].ocuparCasillero(null, "img/obs5.png");
			v[6][j].getLabel().setIcon(new ImageIcon("img/obs5.png"));
		}
		
		
		v[2][2].ocuparCasillero(null, "img/obs01.png");
		v[2][2].getLabel().setIcon(new ImageIcon("img/obs01.png"));
		v[4][2].ocuparCasillero(null, "img/obs4.png");
		v[4][2].getLabel().setIcon(new ImageIcon("img/obs4.png"));
		v[2][6].ocuparCasillero(null, "img/obs3.png");
		v[2][6].getLabel().setIcon(new ImageIcon("img/obs3.png"));
		v[4][6].ocuparCasillero(null, "img/obs6.png");
		v[4][6].getLabel().setIcon(new ImageIcon("img/obs6.png"));
		v[3][2].ocuparCasillero(null, "img/obs0.png");
		v[3][2].getLabel().setIcon(new ImageIcon("img/obs0.png"));
		v[3][6].ocuparCasillero(null, "img/obs0.png");
		v[3][6].getLabel().setIcon(new ImageIcon("img/obs0.png"));
		
		for (int j=3; j<6; j++) {
			v[2][j].ocuparCasillero(null, "img/obs5.png");
			v[2][j].getLabel().setIcon(new ImageIcon("img/obs5.png"));
		}
		for (int j=3; j<6; j++) {
			v[4][j].ocuparCasillero(null, "img/obs5.png");
			v[4][j].getLabel().setIcon(new ImageIcon("img/obs5.png"));
		}
		
		v[2][11].ocuparCasillero(null, "img/obs01.png");
		v[2][11].getLabel().setIcon(new ImageIcon("img/obs01.png"));
		v[4][11].ocuparCasillero(null, "img/obs4.png");
		v[4][11].getLabel().setIcon(new ImageIcon("img/obs4.png"));
		v[2][15].ocuparCasillero(null, "img/obs3.png");
		v[2][15].getLabel().setIcon(new ImageIcon("img/obs3.png"));
		v[4][15].ocuparCasillero(null, "img/obs6.png");
		v[4][15].getLabel().setIcon(new ImageIcon("img/obs6.png"));
		v[3][11].ocuparCasillero(null, "img/obs0.png");
		v[3][11].getLabel().setIcon(new ImageIcon("img/obs0.png"));
		v[3][15].ocuparCasillero(null, "img/obs0.png");
		v[3][15].getLabel().setIcon(new ImageIcon("img/obs0.png"));
		
		for (int j=12; j<15; j++) {
			v[2][j].ocuparCasillero(null, "img/obs5.png");
			v[2][j].getLabel().setIcon(new ImageIcon("img/obs5.png"));
		}
		for (int j=12; j<15; j++) {
			v[4][j].ocuparCasillero(null, "img/obs5.png");
			v[4][j].getLabel().setIcon(new ImageIcon("img/obs5.png"));
		}
		
		for (int j=10; j<17; j++) {
			v[6][j].ocuparCasillero(null, "img/obs5.png");
			v[6][j].getLabel().setIcon(new ImageIcon("img/obs5.png"));
		}
		v[6][9].ocuparCasillero(null, "img/obs01.png");
		v[6][9].getLabel().setIcon(new ImageIcon("img/obs01.png"));
		
		v[6][7].ocuparCasillero(null, "img/obs3.png");
		v[6][7].getLabel().setIcon(new ImageIcon("img/obs3.png"));
		
		v[7][7].ocuparCasillero(null, "img/obs6.png");
		v[7][7].getLabel().setIcon(new ImageIcon("img/obs6.png"));
		

		v[7][9].ocuparCasillero(null, "img/obs4.png");
		v[7][9].getLabel().setIcon(new ImageIcon("img/obs4.png"));
		
		for (int j=10; j<18; j++) {
			v[7][j].ocuparCasillero(null, "img/obs5.png");
			v[7][j].getLabel().setIcon(new ImageIcon("img/obs5.png"));
		}
		
		for (int j=0; j<7; j++) {
			v[7][j].ocuparCasillero(null, "img/obs5.png");
			v[7][j].getLabel().setIcon(new ImageIcon("img/obs5.png"));
		}
		
		for (int j=0; j<5; j++) {
			v[9][j].ocuparCasillero(null, "img/obs5.png");
			v[9][j].getLabel().setIcon(new ImageIcon("img/obs5.png"));
		}
		
		for (int j=12; j<18; j++) {
			v[9][j].ocuparCasillero(null, "img/obs5.png");
			v[9][j].getLabel().setIcon(new ImageIcon("img/obs5.png"));
		}
		
		v[9][5].ocuparCasillero(null, "img/obs3.png");
		v[9][5].getLabel().setIcon(new ImageIcon("img/obs3.png"));
		
		v[9][11].ocuparCasillero(null, "img/obs01.png");
		v[9][11].getLabel().setIcon(new ImageIcon("img/obs01.png"));
		
		for (int j=0; j<5; j++) {
			v[12][j].ocuparCasillero(null,("img/obs5.png"));
		}
		
		for (int j=12; j<18; j++) {
			v[12][j].ocuparCasillero(null,("img/obs5.png"));
		}
		
		for (int j=0; j<5; j++) {
			v[14][j].ocuparCasillero(null,("img/obs5.png"));
		}
		
		for (int j=12; j<18; j++) {
			v[14][j].ocuparCasillero(null,("img/obs5.png"));
		}
		
		v[15][5].ocuparCasillero(null,("img/obs0.png"));
		
		v[16][5].ocuparCasillero(null,("img/obs4.png"));
		
		v[16][5].ocuparCasillero(null,("img/obs4.png"));
		
		v[16][6].ocuparCasillero(null,("img/obs5.png"));
		
		v[16][7].ocuparCasillero(null,("img/obs3.png"));
		
		v[16][10].ocuparCasillero(null,("img/obs5.png"));
		
		v[16][9].ocuparCasillero(null,("img/obs01.png"));
		
		v[17][7].ocuparCasillero(null,("img/obs0.png"));
		
		v[17][9].ocuparCasillero(null,("img/obs0.png"));
		
		
		v[15][11].ocuparCasillero(null,("img/obs0.png"));
		
		v[16][11].ocuparCasillero(null,("img/obs6.png"));
		
		v[0][7].ocuparCasillero(null,("img/obs6.png"));
		
		v[0][9].ocuparCasillero(null,("img/obs4.png"));
		
		v[9][5].ocuparCasillero(null,("img/obs3.png"));
		
		for (int i=10; i<12; i++) {
			v[i][5].ocuparCasillero(null,("img/obs0.png"));
		}
		
		for (int i=10; i<12; i++) {
			v[i][11].ocuparCasillero(null,("img/obs0.png"));
		}
		
		v[12][5].ocuparCasillero(null,("img/obs6.png"));
		
		v[12][11].ocuparCasillero(null,("img/obs4.png"));
		
		v[14][5].ocuparCasillero(null,("img/obs3.png"));
		
		v[14][11].ocuparCasillero(null,("img/obs01.png"));
		
		v[10][8].ocuparCasillero(null,("img/obs5.png"));
		
		v[14][8].ocuparCasillero(null,("img/obs5.png"));
		
		for (int i=11; i<14; i++) {
			v[i][7].ocuparCasillero(null,("img/obs0.png"));
		}
		
		for (int i=11; i<14; i++) {
			v[i][9].ocuparCasillero(null,("img/obs0.png"));
		}
		
		v[10][7].ocuparCasillero(null, "img/obs01.png");
		
		v[10][9].ocuparCasillero(null, "img/obs3.png");
		
		v[14][7].ocuparCasillero(null, "img/obs4.png");
		
		v[14][9].ocuparCasillero(null, "img/obs6.png");
		
		for (int j=1; j<8; j++) {
			if (j%2!=0) {
				v[1][j].getLabel().setIcon(new ImageIcon("img/puntos.png"));
				v[1][j].setComida(new Bolita());
			}
		}
		
		for (int j=1; j<8; j++) {
			if (j%2!=0) {
				v[5][j].getLabel().setIcon(new ImageIcon("img/puntos.png"));
				v[5][j].setComida(new Bolita());
			}
		}
		
		for (int j=10; j<18; j++) {
			if (j%2==0) {
				v[1][j].getLabel().setIcon(new ImageIcon("img/puntos.png"));
				v[1][j].setComida(new Bolita());
			}
		}
		
		for (int j=10; j<18; j++) {
			if (j%2==0) {
				v[5][j].getLabel().setIcon(new ImageIcon("img/puntos.png"));
				v[5][j].setComida(new Bolita());
			}
		}
		
		v[3][1].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		
		v[3][7].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		
		v[3][10].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		
		v[3][16].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		
		v[8][0].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[8][0].setComida(new Bolita());

		v[8][2].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[8][2].setComida(new Bolita());
		
		v[8][4].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[8][4].setComida(new Bolita());
		
		v[8][12].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[8][12].setComida(new Bolita());
		
		v[8][14].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[8][14].setComida(new Bolita());
		
		v[8][16].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[8][16].setComida(new Bolita());
		
		v[9][6].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[9][6].setComida(new Bolita());
		
		v[9][8].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[9][8].setComida(new Bolita());
		
		v[9][10].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[9][10].setComida(new Bolita());
		
		v[11][6].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[11][6].setComida(new Bolita());
		
		v[11][10].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[11][10].setComida(new Bolita());
		
		v[13][0].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[13][0].setComida(new Bolita());
		
		v[13][2].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[13][2].setComida(new Bolita());
		
		v[13][4].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[13][4].setComida(new Bolita());
		
		v[13][6].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[13][6].setComida(new Bolita());
		
		v[13][10].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[13][10].setComida(new Bolita());
		
		v[13][12].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[13][12].setComida(new Bolita());
		
		v[13][14].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[13][14].setComida(new Bolita());
		
		v[13][16].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[13][16].setComida(new Bolita());
		
		v[15][6].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[15][6].setComida(new Bolita());
		
		v[15][8].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[15][8].setComida(new Bolita());
		
		v[15][10].getLabel().setIcon(new ImageIcon("img/puntos.png"));
		v[15][10].setComida(new Bolita());
		
	}
	public static Casillero[][] getCasilleros() {
		return v;
	}
	
}

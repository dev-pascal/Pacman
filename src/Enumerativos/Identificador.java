package Enumerativos;

public enum Identificador {
	Pacman("Pacman"), Blinky("Blinky"), Inky("Inky"), Clyde("Clyde"), Pinky("Pinky");
	private String identificador;
	private Identificador (String identificador) {
		this.identificador=identificador;
	}
	public String getID () {
		return this.identificador;
	}
}

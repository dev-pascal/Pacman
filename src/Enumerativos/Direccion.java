package Enumerativos;

public enum Direccion {
	Arriba("Arriba"), Abajo("Abajo"), Izquierda("Izquierda"), Derecha("Derecha");
	private String direccion;
	private Direccion (String direccion) {
		this.direccion=direccion;
	}
	public String getDireccion () {
		return this.direccion;
	}
}

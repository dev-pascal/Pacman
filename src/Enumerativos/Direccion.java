package Enumerativos;

public enum Direccion {
	Up("Up"), Down("Down"), Left("Left"), Right("Right");
	private String direccion;
	private Direccion (String direccion) {
		this.direccion=direccion;
	}
	public String getDireccion () {
		return this.direccion;
	}
}

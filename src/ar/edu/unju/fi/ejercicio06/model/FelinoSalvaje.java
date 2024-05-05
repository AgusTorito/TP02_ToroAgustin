package ar.edu.unju.fi.ejercicio06.model;

public class FelinoSalvaje {
	private String Nombre;
	private byte Edad;
	private float Peso;
	
	public FelinoSalvaje(String nombre, byte edad, float peso) {
		super();
		Nombre = nombre;
		Edad = edad;
		Peso = peso;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public byte getEdad() {
		return Edad;
	}

	public void setEdad(byte edad) {
		Edad = edad;
	}

	public float getPeso() {
		return Peso;
	}

	public void setPeso(float peso) {
		Peso = peso;
	}

	@Override
	public String toString() {
		return "FelinoSalvaje [Nombre=" + Nombre + ", Edad=" + Edad + ", Peso=" + Peso + "]";
	}
	
	
}

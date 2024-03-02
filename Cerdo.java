package opcionalGranja;

public class Cerdo extends Animal {

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Cerdo(String nombre, double peso, int edad, String color) {
		super(nombre, peso, edad);
		this.color = color;
	}

	public void tipoAnimal(Boolean cerdo) {
		System.out.println(super.getNombre() + " es un cerdo");
		cerdo = true;
	}

	public void tipoAnimal() {
		System.out.println(super.getNombre() + " es un cerdo");
	}
	
	public void atr() {
		System.out.print(" color piel: " + this.color);
	}
}

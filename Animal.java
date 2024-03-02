package opcionalGranja;

public class Animal {

	private String nombre;
	private double peso;
	private int edad;
	private boolean vivo = true;
	
	
	public boolean isVivo() {
		return vivo;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Animal(String nombre, double peso, int edad) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.edad = edad;
	}
	
	public void tipoAnimal(Boolean cerdo) {
	}
	public void tipoAnimal() {
	}
	public void atr() {
	}
	
	@Override
	  public String toString() {
		return  this.nombre + ": peso: " + this.peso + " Kg, edad: " + this.edad + " años" ;
	}
	
}

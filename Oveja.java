package opcionalGranja;

public class Oveja extends Animal {

	public String tipoPelo;

	public String getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(String tipoPelo) {
		this.tipoPelo = tipoPelo;
	}

	public Oveja(String nombre, double peso, int edad, String tipoPelo) {
		super(nombre, peso, edad);
		this.tipoPelo = tipoPelo;
	}

	public void tipoAnimal(Boolean cerdo) {
		System.out.println(super.getNombre() + " es una oveja");
	}

	public void tipoAnimal() {
		System.out.println(super.getNombre() + " es una oveja");
	}

	public void atr() {
		System.out.print(" tipo de pelo: " + this.tipoPelo);
	}
	
}

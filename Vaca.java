package opcionalGranja;

import java.util.Random;

public class Vaca extends Animal {

	private boolean tipo; // true=leche false=carne
	private double lecheObtenida;


	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public Vaca(String nombre, double peso, int edad, boolean tipo) {
		super(nombre, peso, edad);
		this.tipo = tipo;
	}

	public void tipoAnimal(Boolean cerdo) {
		System.out.println(super.getNombre() + " es una vaca");
	}
	public void tipoAnimal() {
		System.out.println(super.getNombre() + " es una vaca");
	}
	
	public void atr() {
		String tipo;
		if (this.tipo==true) {
			tipo = "leche";
		}else {
			tipo = "carne";
		}
		System.out.print(" uso: " + tipo);
	}
	
	public double ordeñar() {
		Random r  = new Random();
		double numAle = r.nextDouble(6)+3;
		
		numAle=Math.round(numAle*10.0)/10.0;
	
		this.lecheObtenida+=numAle;
		
		
		
		return numAle;
	}
	
}

package opcionalGranja;

import java.util.Scanner;

public class Principal {

	static Vaca v1 = new Vaca("Romera", 230.5, 3, true);
	static Vaca v2 = new Vaca("Facunda", 205.2, 3, false);
	static Vaca v3 = new Vaca("Fina", 245.4, 4, true);

	static Cerdo c1 = new Cerdo("Petro", 90.2, 2, "rosado");

	static Oveja o1 = new Oveja("Mota", 40, 3, "rizado");
	static Oveja o2 = new Oveja("Coral", 50, 4, "liso");
	static Oveja o3 = new Oveja("Cebra", 37.6, 1, "rizado");

	static Animal animales[] = { v1, v2, v3, c1, o1, o2, o3 };

	static double totalLeche;
	static double gananciasTotales;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while (true) {

			int opcion = 0;

			System.out.println("Menú principal");
			System.out.println("1.- Listado de animales");
			System.out.println("2.- Mostrar tipo de animal");
			System.out.println("3.- Sumar año a un animal");
			System.out.println("4.- Cambiar peso animal");
			System.out.println("5.- Marcar animal como muerto");
			System.out.println("6.- Adquirir nuevo cerdo");
			System.out.println("7.- Listado de animales completo");
			System.out.println("8.- Obtención de leche");
			System.out.println("9.- Venta de leche");

			System.out.println("\nElige una opción (1-9)");

			opcion = excepcion(opcion);

			switch (opcion) {

			case 1:
				listadoAnimales();

				break;

			case 2:
				tipoAnimal();

				break;

			case 3:
				sumarAnyo();

				break;

			case 4:
				cambiarPeso();

				break;

			case 5:
				marcarMuerto();

				break;

			case 6:
				adquirirCerdo();

				break;

			case 7:
				listadoAniCom();

				break;

			case 8:
				obtencionLeche();

				break;

			case 9:
				ventaLeche();

				break;

			default:
				// opción por defecto, por si ponen un numero fuera de rango
				System.out.println("Tienes que elegir un número entre 1 y 4 \n");
				break;
			} // fin del switch
		} // fin del while
	} // fin del main

	private static void ventaLeche() {
		// TODO Auto-generated method stub
		System.out.println("\nVENTA DE LECHE");
		System.out.println("Leche en stock: " + totalLeche);

		System.out.println("Cuanta se quiere vender?");

		double elegir = -1;
		elegir = excepcionMinMax(elegir, 0, totalLeche);
		totalLeche-=elegir;

		double ganancias = elegir * 0.5;
		gananciasTotales += ganancias;

		System.out.println("Ganancias por esta venta: " + ganancias + " euros");
		System.out.println("Ganancias acumuladas: " + gananciasTotales + " euros");
		intro();
	}

	private static void obtencionLeche() {
		// TODO Auto-generated method stub
		for (Animal a : animales) {
			if (a instanceof Vaca) {
				if (a.isVivo()) {
					if (((Vaca) a).isTipo() == true) {
						double obt = ((Vaca) a).ordeñar();
						totalLeche += obt;
						System.out.println("Leche obtenida por " + a.getNombre() + ": " + obt);
					}
				} else {
					System.out.println(a.getNombre() + " está muerta");
				}
			}
		}
		intro();
	}

	private static void listadoAniCom() {
		// TODO Auto-generated method stub
		System.out.println("\nLISTADO DE ANIMALES COMPLETO");
		for (Animal a : animales) {
			if (a != null && a.isVivo()) {
				System.out.print(a);
				a.atr();
				System.out.println();
			}
		}
		intro();
	}

	private static void adquirirCerdo() {
		// TODO Auto-generated method stub
		Boolean cerdo = false;
		Scanner scLine = new Scanner(System.in);
		System.out.println("\nADQUIRIR UN NUEVO CERDO");
		for (Animal a : animales) {
			a.tipoAnimal(cerdo);
		}
		if (cerdo) {
			System.out.println("Ya hay un cerdo");

		} else {
			System.out.println("Introduce el nombre del cerdo");
			String nombre = scLine.nextLine();
			System.out.println("Introduce el peso");
			double peso = -1;
			peso = excepcionMin(peso, 0);
			System.out.println("Introduce la edad");
			int edad = -1;
			edad = excepcionMin(edad, -1);
			System.out.println("Introduce el color del cerdo");
			String color = scLine.nextLine();

			for (Animal a : animales) {
				if (a == null) {
					a = new Cerdo(nombre, peso, edad, color);
					break;
				}
			}
		}
		intro();
	}

	private static void marcarMuerto() {
		// TODO Auto-generated method stub
		System.out.println("\nMARCAR ANIMAL COMO MUERTO");
		for (int i = 0; i < animales.length; i++) {
			if (animales[i] != null)
				System.out.println(i + ".- " + animales[i].getNombre());
		}
		int elegir = -1;
		elegir = elegirAnimal(elegir);
		System.out.println("El animal " + animales[elegir].getNombre() + " ha muerto");

		if (animales[elegir] instanceof Cerdo)
			animales[elegir] = null;
		else
			animales[elegir].setVivo(false);
	}

	private static void cambiarPeso() {
		// TODO Auto-generated method stub
		System.out.println("\nCAMBIAR PESO A ANIMAL");
		for (int i = 0; i < animales.length; i++) {
			if (animales[i] != null && animales[i].isVivo())
				System.out.println(i + ".- " + animales[i].getNombre() + " peso: " + animales[i].getPeso());
		}

		int elegir = -1;
		elegir = elegirAnimal(elegir);

		System.out.println("Nuevo peso?");
		double peso = -1;
		peso = excepcionMin(peso, 0);

		double mayor = Math.max(peso, animales[elegir].getPeso());
		if (mayor == peso) {
			
			double diferencia = peso - animales[elegir].getPeso();
			System.out.println(animales[elegir].getNombre() + " ha ganado " + diferencia + " Kg");
			animales[elegir].setPeso(peso);
		} else {
			double diferencia = animales[elegir].getPeso() - peso;
			System.out.println(animales[elegir].getNombre() + " ha perdido " + diferencia + " Kg");
			animales[elegir].setPeso(peso);
		}

		intro();

	}

	private static int elegirAnimal(int elegir) {
		// TODO Auto-generated method stub
		boolean bien = false;
		System.out.println("Elija el animal");
		while (!bien) {
			elegir = excepcion(elegir);
			for (int i = 0; i < animales.length; i++) {
				if (elegir == i && animales[i].isVivo()) {
					bien = true;
				}
			}
			if (!bien) {
				System.out.println("Elija un animal válido");
			}
		}
		return elegir;
	}

	private static void sumarAnyo() {
		// TODO Auto-generated method stub
		System.out.println("\nSUMAR AÑO A ANIMAL");
		for (int i = 0; i < animales.length; i++) {
			if (animales[i] != null && animales[i].isVivo())
				System.out.println(i + ".- " + animales[i].getNombre() + " edad: " + animales[i].getEdad());
		}

		int elegir = -1;
		elegir = elegirAnimal(elegir);

		animales[elegir].setEdad(animales[elegir].getEdad() + 1);

		System.out.println(animales[elegir].getNombre() + " ahora tiene " + animales[elegir].getEdad() + " años");
		intro();

	}

	private static void tipoAnimal() {
		// TODO Auto-generated method stub
		System.out.println("\nMOSTRAR TIPO DE ANIMAL");
		for (int i = 0; i < animales.length; i++) {
			if (animales[i] != null && animales[i].isVivo())
				System.out.println(i + ".- " + animales[i].getNombre());
		}

		int elegir = -1;
		elegir = elegirAnimal(elegir);

		animales[elegir].tipoAnimal();
		intro();

	}

	private static void listadoAnimales() {
		// TODO Auto-generated method stub

		System.out.println("\nLISTADO DE ANIMALES");
		for (Animal a : animales) {
			if (a != null && a.isVivo())
				System.out.println(a);
		}
		intro();
	}

	private static void intro() {
		// TODO Auto-generated method stub
		Scanner scLine = new Scanner(System.in);
		System.out.println("\nPulsa enter para volver al menú principal\n");
		scLine.nextLine();
	}

	private static int excepcionMinMax(int elegir, int min, int max) {
		// TODO Auto-generated method stub
		boolean error = true;
		while (error) {
			error = false;
			try {
				Scanner scInt = new Scanner(System.in);
				elegir = scInt.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("\nNo has introducido un número");
				error = true;
			}
			if (!error && (elegir < min || elegir > max)) {
				error = true;
				System.out.println("Introduce un número dentro del rango (" + min + "-" + max + ")");
			}
		}
		return elegir;
	}
	private static double excepcionMinMax(double elegir, double min, double max) {
		// TODO Auto-generated method stub
		boolean error = true;
		while (error) {
			error = false;
			try {
				Scanner scDouble = new Scanner(System.in);
				elegir = scDouble.nextDouble();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("\nNo has introducido un número");
				error = true;
			}
			if (!error && (elegir < min || elegir > max)) {
				error = true;
				System.out.println("Introduce un número dentro del rango (" + min + "-" + max + ")");
			}
		}
		return elegir;
	}

	private static double excepcionMin(double peso, int min) {
		// TODO Auto-generated method stub
		boolean error = true;
		while (error) {
			error = false;
			try {
				Scanner scDouble = new Scanner(System.in);
				peso = scDouble.nextDouble();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("\nNo has introducido un número");
				error = true;
			}
			if (!error && peso < min) {
				error = true;
				System.out.println("Introduce un número mayor que " + min);
			}
		}
		return peso;
	}

	private static int excepcionMin(int peso, int min) {
		// TODO Auto-generated method stub
		boolean error = true;
		while (error) {
			error = false;
			try {
				Scanner scInt = new Scanner(System.in);
				peso = scInt.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("\nNo has introducido un número");
				error = true;
			}
			if (!error && peso < min) {
				error = true;
				System.out.println("Introduce un número mayor que " + min);
			}
		}
		return peso;
	}

	private static int excepcion(int opcion) {
		// TODO Auto-generated method stub
		boolean bien = true;
		try {
			Scanner scInt = new Scanner(System.in);
			opcion = scInt.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("\nNo has introducido un número");
			bien = false;
		}
		if (bien) {
			return opcion;
		} else {
			return opcion = -1;
		}
	}

}

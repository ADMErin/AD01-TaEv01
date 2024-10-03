package ejercicios;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class cuatroB {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		String dni = "";;
		int peso = 0;
		SuperHeroe personaje = new SuperHeroe();
		
		guardarSuperHeroes();
		dni = pedirDni(teclado, dni);
		peso = pedirPeso(teclado, peso);
		compararPersonaje(teclado, dni, personaje, peso);

	}
	
	public static void guardarSuperHeroes() {
		try {
			File archivo = new File("C:\\Users\\memen\\Desktop\\2ºFP\\Acceso a Datos\\Tareas\\ejercicio1\\src\\ejercicios\\ObjetosSuperHeroes.dat");
			FileOutputStream fichero = new FileOutputStream(archivo);
			
			ObjectOutputStream dataObjetos = new ObjectOutputStream(fichero);
			
			SuperHeroe heroe;
			
			int [] ids= {1, 2, 3, 4, 5, 6, 7};
			String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
			String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
			String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
			String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
			int[] pesos = {76,84,66,136,78,102,70};
			int[] alturas = {178,183,156,152,177,182,188};
			
			int x = dnis.length;
			
			for (int i = 0; i<x; i++) {
				heroe = new SuperHeroe(ids[i], dnis[i], noms[i], identidades[i], tipos[i], pesos[i], alturas[i]);
				dataObjetos.writeObject(heroe);
			}
			dataObjetos.close();
			System.out.println("La carga de objetos ha terminado correctamente");
		}
		catch (IOException excepcion) {
			System.out.print("Problemas de entrada/salida");
		}
	}
	
	public static String pedirDni(Scanner teclado, String dni) {

		Pattern formatoUsuario = Pattern.compile("[0-9]{8}[A-Z]");
		Matcher comparaFormato = formatoUsuario.matcher(dni);
			      
		do {
			System.out.println("Introduzca un DNI válido (ocho digitos y letra Mayúscula) del personaje para el control del peso: ");
			dni = teclado.next();
			comparaFormato = formatoUsuario.matcher(dni);
		} while (!comparaFormato.matches());
		return dni;
	}
	
	public static int pedirPeso(Scanner teclado, int peso) {
		System.out.println("Introduzca su peso actual: ");
		peso = teclado.nextInt();
		return peso;
	}

	public static void compararPersonaje(Scanner teclado, String dni, SuperHeroe personaje, int peso) {
		try {
			File archivo = new File("C:\\Users\\memen\\Desktop\\2ºFP\\Acceso a Datos\\Tareas\\ejercicio1\\src\\ejercicios\\ObjetosSuperHeroes.dat");
			ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(archivo));
			
	        boolean encontrado = false;

	        while (true) {
	            try {
	                personaje = (SuperHeroe) dataIS.readObject(); // leer un SuperHeroe
	                
	                if (dni.equalsIgnoreCase(personaje.getDni())) {
	                	compararPeso(personaje, peso);
	                	encontrado = true;
	                    break;
	                }
	            } catch (EOFException eof) {
	                break; // Fin del archivo
	            }
	        }

	        if (!encontrado) {
	            System.out.println("No existe ningún personaje con ese DNI");
	        }

	        dataIS.close();
		}	
		catch (IOException excepcion) {
			System.out.print("Problemas de entrada/salida");
		}
		catch (ClassNotFoundException  cnfe) {
			System.out.println("No se encuentra la clase SuperHeroe.");
		}
	}
	
	public static void compararPeso(SuperHeroe personaje, int peso) {
		String nombre = personaje.getNombre();
		int pesoRegistrado = personaje.getPeso();
		if (peso < pesoRegistrado) {
			System.out.println(nombre + " ha adelgazado " + (pesoRegistrado - peso) + " kilos");
		}
		else if (peso > pesoRegistrado) {
			System.out.println(nombre + " ha engordado " + (peso - pesoRegistrado ) + " kilos");
		}
		else {
			System.out.println(nombre + " se mantiene en su peso");
		}
	}
}

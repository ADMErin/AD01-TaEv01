package ejercicios;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class CuatroC {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		String tipo = "";;
		SuperHeroe personaje = new SuperHeroe();
		
		tipo = pedirTipo(teclado, tipo);
		buscarPersonaje(personaje, tipo);
		teclado.close();
	}

	public static String pedirTipo(Scanner teclado, String tipo) {
		System.out.println("Introduzca un tipo de personaje: ");
		tipo = teclado.next();
		return tipo;
	}
	
	public static void buscarPersonaje(SuperHeroe personaje, String tipo) {
		try {
			File archivo = new File("C:\\Users\\memen\\Desktop\\2ºFP\\Acceso a Datos\\Tareas\\ejercicio1\\src\\ejercicios\\ObjetosSuperHeroes.dat");
			ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(archivo));
			
	        boolean encontrado = false;
	        int contador = 0;
	        while (true) {
	            try {
	                personaje = (SuperHeroe) dataIS.readObject(); // leer un SuperHeroe
	                
	                if (tipo.equalsIgnoreCase(personaje.getTipo())) {
	                	contador ++;
	                	encontrado = true;
	                    System.out.println(personaje.toString());
	                }
	            } catch (EOFException eof) {
	                break; // Fin del archivo
	            }
	        }
	        
	        if (!encontrado) {
	            System.out.println("No existe ningún personaje de ese tipo");
	        }
	        else {
	        	System.out.println("Se han encontrado " + contador + " personajes " + tipo);
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
}

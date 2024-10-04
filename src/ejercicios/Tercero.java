package ejercicios;

import java.io.*;
import java.util.*;

public class Tercero {

	public static void main(String[] args) {
		try {
			File entrada = new File(
					"C:\\Users\\memen\\Desktop\\2ºFP\\Acceso a Datos\\Tareas\\TaEv01\\src\\ejercicios\\muestra.pdf");
			FileInputStream fichEntrada = new FileInputStream(entrada);
			
			//Creamos un array de bytes donde guardar los 4 primeros del archivo
			byte[] archivo = new byte[4];
			fichEntrada.read(archivo);
			byte[] pdf = { 37, 80, 68, 70 };
			
			//Comparamos los dos arrays
			if (Arrays.equals(archivo, pdf)) {
				System.out.print("El archivo pdf, es valido");
			} else {
				System.out.print("El archivo pdf, no es valido");
			}
			fichEntrada.close();

		} catch (FileNotFoundException excepcion) {
			System.out.println("No se encuentra el archivo");
		} catch (IOException excepcion) {
			System.out.println("Error de salida");
		}
	}
}

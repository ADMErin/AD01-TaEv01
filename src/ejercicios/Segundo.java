package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Segundo {

	public static void main(String[] args) {
		try {
			File entrada = new File(
					"C:\\Users\\memen\\Desktop\\2ºFP\\Acceso a Datos\\Tareas\\TaEv01\\src\\ejercicios\\Nombres.txt");
			File salida = new File(
					"C:\\Users\\memen\\Desktop\\2ºFP\\Acceso a Datos\\Tareas\\TaEv01\\src\\ejercicios\\salidaNombres.txt");

			BufferedReader fichEntrada = new BufferedReader(new FileReader(entrada));
			BufferedWriter fichSalida = new BufferedWriter(new FileWriter(salida));
			
			String linea;
			while ((linea = fichEntrada.readLine()) != null) {
				
				//Recoge la linea del archivo por palabras en un array
				String[] nombreCompleto = linea.split(" ");
				
				//Recoge el nombre del array
				String nombre = nombreCompleto[0];
				
				//Comprueba la longitud del nombre
				if (nombre.length() == 5) {
					fichSalida.write(nombre);
					fichSalida.write("\n");
				}
			}
			fichEntrada.close();
			fichSalida.close();
		} catch (FileNotFoundException excepcion) {
			System.out.println("No se encuentra el archivo");
		} catch (IOException excepcion) {
			System.out.println("Error de salida");
		}
	}
}

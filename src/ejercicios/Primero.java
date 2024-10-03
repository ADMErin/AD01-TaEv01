package ejercicios;

import java.io.*;

public class Primero {

	public static void main(String[] args) {
		try {
			File entrada = new File(
					"C:\\Users\\memen\\Desktop\\2ºFP\\Acceso a Datos\\Tareas\\ejercicio1\\src\\ejercicios\\entrada.txt");
			File salida = new File(
					"C:\\Users\\memen\\Desktop\\2ºFP\\Acceso a Datos\\Tareas\\ejercicio1\\src\\ejercicios\\salida.txt");

			BufferedReader fichEntrada = new BufferedReader(new FileReader(entrada));
			FileWriter fichSalida = new FileWriter(salida);

			String linea;
			String[] palabras;
			while ((linea = fichEntrada.readLine()) != null) {
				palabras = linea.split(" ");

				for (int i = 0; i < palabras.length; i++) {
					String palabra = palabras[i];
					String reverso = "";
					for (int x = palabra.length() - 1; x >= 0; x--) {
						reverso += palabra.charAt(x);
					}
					fichSalida.write(reverso + " ");
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

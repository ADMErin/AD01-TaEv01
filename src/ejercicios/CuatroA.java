package ejercicios;

import java.io.*;

public class CuatroA {

	public static void main(String[] args) {

		try {
			File archivo = new File(
					"C:\\Users\\memen\\Desktop\\2ºFP\\Acceso a Datos\\Tareas\\ejercicio1\\src\\ejercicios\\superHeroes.dat");
			RandomAccessFile fichero = new RandomAccessFile(archivo, "rw");

			int[] ids = { 1, 2, 3, 4, 5, 6, 7 };
			String[] dnis = { "01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D",
					"06060606F" };
			String[] noms = { "Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin" };
			String[] identidades = { "Peter Parker", "Norman Osborn", "Ororo Munroe", "James Howlett",
					"Raven Darkholme", "Tony Stark", "Zhang Tong" };
			String[] tipos = { "heroe", "villano", "heroe", "heroe", "villano", "heroe", "villano" };
			int[] pesos = { 76, 84, 66, 136, 78, 102, 70 };
			int[] alturas = { 178, 183, 156, 152, 177, 182, 188 };

			StringBuffer buffer = null;
			int x = dnis.length;

			for (int i = 0; i < x; i++) {
				buffer = new StringBuffer(dnis[i]);
				buffer.setLength(9);

				fichero.writeInt(ids[i]);
				fichero.writeChars(buffer.toString());
				fichero.writeChars(noms[i]);
				fichero.writeChars(identidades[i]);
				fichero.writeChars(tipos[i]);
				fichero.writeInt(pesos[i]);
				fichero.writeInt(alturas[i]);
			}
			fichero.close();
			System.out.print("La carga de los personajes ha terminado correctamente");
		} catch (IOException excepcion) {
			System.out.print("Problemas de entrada/salida");
		}
	}
}

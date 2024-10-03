package ejercicios;

import java.io.Serializable;

public class SuperHeroe implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2277138193376717828L;
	private int id;
	private String dni;
	private String nombre;
	private String identidad;
	private String tipo;
	private int peso;
	private int altura;
	
	public SuperHeroe (int id, String dni, String nombre, String identidad, String tipo, int peso, int altura ) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.identidad = identidad;
		this.tipo = tipo;
		this.peso = peso;
		this.altura = altura;
	}
	public SuperHeroe() {
		super();
	}
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getIdentidad() {
		return identidad;
	}
	public int getPeso() {
		return peso;
	}
	@Override
	public String toString() {
		return "SuperHeroe [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", identidad=" + identidad + ", tipo="
				+ tipo + ", peso=" + peso + ", altura=" + altura + "]";
	}
	
}

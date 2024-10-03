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
	public String getTipo() {
		return tipo;
	}
	public int getPeso() {
		return peso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getId() {
		return id;
	}
	public int getAltura() {
		return altura;
	}
	@Override
	public String toString() {
	    return String.format("SuperHeroe [id=%-1d, dni=%-9s, nombre=%-15s, identidad=%-20s, tipo=%-10s, peso=%-3d, altura=%-4d]",
	            id, dni, nombre, identidad, tipo, peso, altura);
	}
	
}

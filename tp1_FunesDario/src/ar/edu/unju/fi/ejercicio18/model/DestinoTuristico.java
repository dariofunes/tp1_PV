package ar.edu.unju.fi.ejercicio18.model;

public class DestinoTuristico {
	private String codigo;
	private String nombre;
	private float precio;
	private Pais pais;
	private int cantidadDias;
	
	public DestinoTuristico() {
		// TODO Auto-generated constructor stub
	}

	public DestinoTuristico(String codigo, String nombre, float precio, Pais pais, int cantidadDias) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.pais = pais;
		this.cantidadDias = cantidadDias;
	}

	@Override
	public String toString() {
		return "Codigo= " + codigo + "\nNombre= " + nombre + "\nPrecio= " + precio + "\nPais= " + pais
				+ "\nCantidad de Días= " + cantidadDias + " días\n";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}
}

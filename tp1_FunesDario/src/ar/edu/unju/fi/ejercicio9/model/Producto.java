package ar.edu.unju.fi.ejercicio9.model;

public class Producto {
	private String nombre;
	private Integer codigo;
	private Float precio;
	private Integer descuento; //comprendido entre 0 y 50
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Float calcularDescuento() {
		return this.getPrecio()-this.getPrecio()*this.getDescuento()/100;
	}
	
	public String mostrarDatos() {
		return "\nProducto\nNombre= " + nombre + "\nCodigo= " + codigo + "\nPrecio= " + precio 
				+ "\nDescuento= " + descuento + "\nPrecio con Descuento= " + this.calcularDescuento() + "\n";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
}

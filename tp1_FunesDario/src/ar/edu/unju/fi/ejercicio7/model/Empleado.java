package ar.edu.unju.fi.ejercicio7.model;

public class Empleado {
	private final float SALARIO_MINIMO = 210000.00f;
	private final float AUMENTO_POR_MERITO = 20000.00f;
	
	private String nombre;
	private Integer legajo;
	private Float salario;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(String nombre, Integer legajo, Float salario) {
		this.nombre = nombre;
		this.legajo = legajo;
		if(salario>=SALARIO_MINIMO)
			this.salario = salario;
		else
			this.salario = SALARIO_MINIMO;
	}

	public String mostrarDatos() {
		return "\nNombre del Empleado= " + nombre + "\nLegajo= " + legajo + "\nSalario= $" + salario + "\n";
	}
	
	public void darAumento() {
		this.setSalario(this.getSalario()+AUMENTO_POR_MERITO);
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}
	
}

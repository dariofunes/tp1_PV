package ar.edu.unju.fi.ejercicio6.model;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
	private Integer dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String provincia;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(Integer dni, String nombre, LocalDate fechaNacimiento, String provincia) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = provincia;
	}
	
	public Persona(Integer dni, String nombre, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = "Jujuy";
	}
	
	public int edad() {
		//int anio = LocalDate.now().getYear();
		//return anio - this.getFechaNacimiento().getYear();
		Period periodo = Period.between(this.getFechaNacimiento(),LocalDate.now());
		return periodo.getYears();
	}
	
	public boolean esMayorEdad() {
		if(this.edad()<18)
			return false;
		else
			return true;
	}
	
	@Override
	public String toString() {
		String mensaje;
		if(this.esMayorEdad())
			mensaje = "La persona es mayor de edad";
		else
			mensaje = "La persona no es mayor de edad";
		return "\nPersona\nDNI= " + dni + "\nNombre= " + nombre + "\nFecha de Nac.= " + fechaNacimiento + 
				"\nProvincia= "	+ provincia + "\nEdad= " + this.edad() + "\t" + mensaje + "\n";
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
}

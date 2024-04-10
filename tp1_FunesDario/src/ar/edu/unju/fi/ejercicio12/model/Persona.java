package ar.edu.unju.fi.ejercicio12.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Persona {
	private String nombre;
	private Calendar fechaNacimiento;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public String mostrarDatos() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		return "\nNombre: " + nombre + "\nFecha de Nac.: " + fmt.format( fechaNacimiento.getTime() ) 
			+ "\nEdad: " + this.edad() + " años" + "\nSigno del Zodiaco: " + this.signoZodiaco() 
			+ "\nEstación: " + this.estacionNacimiento();
	}
	
	public String signoZodiaco() {
		int anio = this.getFechaNacimiento().get(Calendar.YEAR);
		Calendar fecha = Calendar.getInstance();
		int mes = 0;
		fecha.set(anio, mes, 20);//se coloca 20 en vez de 21 por la condicion del if de mas abajo. 
								//Porque una vez que es el dia 21 el signo ya cambio, si es 20 aun no cambio.
		String [ ] signos = {"Capricornio","Acuario","Piscis","Aries","Tauro","Geminis","Cancer","Leo",
				"Virgo","Libra","Escorpio","Sagitario","Capricornio"};
		for(String signo : signos) {
			//System.out.println(fecha.getTime()+"\n"+signo+"\n"+this.getFechaNacimiento().before(fecha)+"\n");
			if(this.getFechaNacimiento().before(fecha)) {
				return signo;
			}
			fecha.set(anio, ++mes, 20); //para los dias podriamos hacer un arreglo con las fechas exactas 
										//en las que cambian los signos para hacer mas preciso el metodo. 
		}
		return "Error: no se pudo encontrar su signo del zodiaco";
	}
	
	public String estacionNacimiento() {
		int anio = this.getFechaNacimiento().get(Calendar.YEAR);
		Calendar fecha = Calendar.getInstance();
		int mes = 2;
		fecha.set(anio, mes, 20);
		String [ ] estaciones = {"Verano","Otoño","Invierno","Primavera","Verano"};
		for(String estacion : estaciones) {
			if(this.getFechaNacimiento().before(fecha)) {
				return estacion;
			}
			mes += 3;
			fecha.set(anio, mes, 20); 
		}
		return "Error: no se pudo encontrar la estacion del año.";
	}
	
	public long edad() {
		Calendar hoy = Calendar.getInstance();
		long edad = hoy.getTimeInMillis() - this.getFechaNacimiento().getTimeInMillis();
		return edad/1000/60/60/24/30/12;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}

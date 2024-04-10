package ar.edu.unju.fi.ejercicio12.main;

import java.util.Calendar;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio12.model.Persona;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Persona persona = new Persona();
		System.out.println("Ingrese el nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Ingrese el dia de nacimiento: ");
		int dia = sc.nextInt();
		System.out.println("Ingrese el mes de nacimiento: ");
		int mes = sc.nextInt();
		System.out.println("Ingrese el año de nacimiento: ");
		int anio = sc.nextInt();
		sc.close();
		
		Calendar fechaNacimiento = Calendar.getInstance();
		fechaNacimiento.set(anio, mes-1, dia);
		persona.setNombre(nombre);
		persona.setFechaNacimiento(fechaNacimiento);
		
		System.out.println(persona.mostrarDatos());
		
	}

}

package ar.edu.unju.fi.ejercicio6.main;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio6.model.Persona;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Ingrese el DNI: ");
		int dni = sc.nextInt();
		System.out.println("Fecha de Nac.\nIngrese el dia de nacimiento: ");
		int diaNacimiento = sc.nextInt();
		System.out.println("Ingrese el mes de nacimiento: ");
		int mesNacimiento = sc.nextInt();
		System.out.println("Ingrese el año de nacimiento: ");
		int anioNacimiento = sc.nextInt();
		sc.nextLine();
		LocalDate fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
		System.out.println("Ingrese la provincia: ");
		String provincia = sc.nextLine();
		
		Persona persona1 = new Persona();
		persona1.setNombre(nombre);
		persona1.setDni(dni);
		persona1.setFechaNacimiento(fechaNacimiento);
		persona1.setProvincia(provincia);
		System.out.println(persona1.toString());
		
		
		System.out.println("Ingrese el nombre: ");
		nombre = sc.nextLine();
		System.out.println("Ingrese el DNI: ");
		dni = sc.nextInt();
		System.out.println("Fecha de Nac.\nIngrese el dia de nacimiento: ");
		diaNacimiento = sc.nextInt();
		System.out.println("Ingrese el mes de nacimiento: ");
		mesNacimiento = sc.nextInt();
		System.out.println("Ingrese el año de nacimiento: ");
		anioNacimiento = sc.nextInt();
		sc.nextLine();
		fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
		System.out.println("Ingrese la provincia: ");
		provincia = sc.nextLine();
		
		Persona persona2 = new Persona(dni, nombre, fechaNacimiento, provincia);
		System.out.println(persona2.toString());
		
		
		System.out.println("Ingrese el nombre: ");
		nombre = sc.nextLine();
		System.out.println("Ingrese el DNI: ");
		dni = sc.nextInt();
		System.out.println("Fecha de Nac.\nIngrese el dia de nacimiento: ");
		diaNacimiento = sc.nextInt();
		System.out.println("Ingrese el mes de nacimiento: ");
		mesNacimiento = sc.nextInt();
		System.out.println("Ingrese el año de nacimiento: ");
		anioNacimiento = sc.nextInt();
		fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
		
		Persona persona3 = new Persona(dni, nombre, fechaNacimiento);
		System.out.println(persona3.toString());
		
		sc.close();
	}

}

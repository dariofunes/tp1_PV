package ar.edu.unju.fi.ejercicio8.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio8.model.CalculadoraEspecial;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese un valor entero: ");
		Integer n = sc.nextInt();
		CalculadoraEspecial calc = new CalculadoraEspecial();
		calc.setN(n);
		System.out.println("El resultado de la sumatoria es: "+ calc.calcularSumatoria());
		System.out.println("El resultado de la productoria es: "+calc.calcularProductoria());
		sc.close();
	}

}

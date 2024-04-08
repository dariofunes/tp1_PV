package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese un numero entero: ");
		int valor = sc.nextInt();
		if(valor%2==0)
			System.out.println(valor*3);
		else
			System.out.println(valor*2);
	}

}

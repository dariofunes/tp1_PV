package ar.edu.unju.fi.ejercicio4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=20;
		while(n>10 || n<=0) {
			System.out.println("Ingrese un numero entre 1 y 10: ");
			n = sc.nextInt();
		}
		System.out.print("El factorial de "+n+" es: ");
		int factorial=1;
		while(n>=2) {
			factorial*=n;
			n--;
		}
		System.out.println(factorial);
		sc.close();
	}

}

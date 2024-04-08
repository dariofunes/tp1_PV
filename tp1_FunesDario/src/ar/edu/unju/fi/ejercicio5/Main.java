package ar.edu.unju.fi.ejercicio5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=20;
		while(n>9 || n<=0) {
			System.out.println("Ingrese un numero entre 1 y 9: ");
			n = sc.nextInt();
		}
		
		for(int i=0;i<=10;i++) {
			System.out.println(n+" x "+i+" = "+n*i);
		}
		sc.close();
	}

}

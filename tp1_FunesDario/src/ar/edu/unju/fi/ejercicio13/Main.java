package ar.edu.unju.fi.ejercicio13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] array = new int[8];
		System.out.println("Ingrese 8 valores enteros.");
		for(int i=0;i<array.length;i++) {
			System.out.println("Ingrese un valor: ");
			array[i] = sc.nextInt();
		}
		sc.close();
		for(int i=0;i<array.length;i++) {
			System.out.println("Array["+ i +"] = "+ array[i]);
		}
	}

}

package ar.edu.unju.fi.ejercicio15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanio = 0;
		while(tamanio<5 || tamanio>10) {
			System.out.println("Ingrese el tamaño del arreglo: (entre 5 y 10)");
			tamanio = sc.nextInt();
		}
		sc.nextLine();
		String [] array = new String[tamanio];
		System.out.println("Ingrese " + tamanio + " nombres de personas.");
		for(int i=0;i<array.length;i++) {
			System.out.println("Ingrese un nombre: ");
			array[i] = sc.nextLine();
		}
		
		sc.close();
		for(int i=0;i<array.length;i++) {
			System.out.println("Array["+ i +"] = "+ array[i]);
		}
		System.out.println("\n\n");
		for(int i=array.length-1;i>=0;i--) {
			System.out.println("Array["+ i +"] = "+ array[i]);
		}
	}

}

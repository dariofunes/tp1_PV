package ar.edu.unju.fi.ejercicio14;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanio = 0;
		while(tamanio<3 || tamanio>10) {
			System.out.println("Ingrese el tamaño del arreglo: (entre 3 y 10)");
			tamanio = sc.nextInt();
		}
		
		int [] array = new int[tamanio];
		System.out.println("Ingrese " + tamanio + " valores enteros.");
		for(int i=0;i<array.length;i++) {
			System.out.println("Ingrese un valor: ");
			array[i] = sc.nextInt();
		}
		
		sc.close();
		int sum = 0;
		for(int i=0;i<array.length;i++) {
			System.out.println("Array["+ i +"] = "+ array[i]);
			sum += array[i];
		}
		System.out.println("La suma de todos los valores es: "+sum);
	}

}

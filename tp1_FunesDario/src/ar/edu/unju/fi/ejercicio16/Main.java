package ar.edu.unju.fi.ejercicio16;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] nombres = new String[5];
		
		System.out.println("Ingrese 5 nombres de personas.");
		for(int i=0;i<nombres.length;i++) {
			System.out.println("Ingrese un nombre: ");
			nombres[i] = sc.nextLine();
		}
		
		int i=0;
		while(i<nombres.length) {
			System.out.println("Array["+ i +"] = "+ nombres[i]);
			i++;
		}
		System.out.println("\nEl tamaño del arreglo es: " + nombres.length+"\n\n");
		
		System.out.println("Ingrese un valor (entre 0 y 4) para eliminarlo del arreglo: ");
		byte indice = sc.nextByte();
		sc.close();
		if(indice==nombres.length-1)
			nombres[indice] = "";
		else {
			i=indice;
			String aux;
			do {
				aux = nombres[i+1];
				nombres[i]=aux;
				nombres[i+1]="";
				i++;
			}while(i<nombres.length-1);
		}
		
		for(i=0;i<nombres.length;i++) {
			System.out.println("Array["+ i +"] = "+ nombres[i]);
		}
	}

}

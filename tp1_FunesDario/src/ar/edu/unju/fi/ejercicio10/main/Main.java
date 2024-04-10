package ar.edu.unju.fi.ejercicio10.main;

import java.util.Scanner;
import ar.edu.unju.fi.ejercicio10.model.Pizza;

public class Main {
	
	public static void generarPizzas() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while(i<3) {
			Integer diametro = 0;
			while(diametro!=20 && diametro!=30 && diametro!=40) {
				System.out.println("Ingrese el diametro de la pizza: (20,30,40)");
				diametro = sc.nextInt();
			}
			System.out.println("Ingrese si desea ingredientes especiales: (true o false)");
			boolean ingredientesEspeciales = sc.nextBoolean();
			
			Pizza pizza = new Pizza();
			pizza.setDiametro(diametro);
			pizza.setIngredientesEspeciales(ingredientesEspeciales);
			pizza.calcularPrecio();
			pizza.calcularArea();
			
			System.out.println("\n** Pizza "+(i+1)+" **"+pizza.mostrarDatos());
			i++;
		}
		sc.close();
	}

	public static void main(String[] args) {
		generarPizzas();
	}

}

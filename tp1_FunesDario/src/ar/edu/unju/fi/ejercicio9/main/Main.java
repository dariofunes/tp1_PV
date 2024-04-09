package ar.edu.unju.fi.ejercicio9.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio9.model.Producto;

public class Main {

	public static void cargarProductos() {
		Scanner sc = new Scanner(System.in);
		int i = 3;
		while(i > 0) {
			System.out.println("Ingrese el nombre del producto: ");
			String nombre = sc.nextLine();
			System.out.println("Ingrese el codigo del producto: ");
			Integer codigo = sc.nextInt();
			System.out.println("Ingrese el precio del producto: ");
			Float precio = sc.nextFloat();
			Integer descuento = 51;
			while(descuento<0 || descuento>50) {
				System.out.println("Ingrese el descuento del producto: ");
				descuento = sc.nextInt();
			}
			sc.nextLine();
			
			Producto producto = new Producto();
			producto.setNombre(nombre);
			producto.setCodigo(codigo);
			producto.setPrecio(precio);
			producto.setDescuento(descuento);
			
			System.out.println(producto.mostrarDatos());
			i--;
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		cargarProductos();
	}

}

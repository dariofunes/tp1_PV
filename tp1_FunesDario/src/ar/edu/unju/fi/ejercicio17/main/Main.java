package ar.edu.unju.fi.ejercicio17.main;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio17.model.Jugador;

public class Main {
	
	public static String[] pedirDatos(Scanner sc) {
		String[] datos = new String[2];
		System.out.println("Ingrese el nombre del jugador: ");
		datos[0] = sc.next();
		System.out.println("Ingrese el apellido del jugador: ");
		datos[1] = sc.next();
		return datos;
	}
	
	public static void cantidadJugadoresNacionalidad(ArrayList<Jugador> jugadores, Scanner sc) {
		System.out.println("Ingrese la nacionalidad por la que desea buscar: ");
		String nacionalidad = sc.next();
		Iterator<Jugador> iterador = jugadores.iterator();
		int sum = 0;
		while(iterador.hasNext()) {
			Jugador j = iterador.next();
			if(j.getNacionalidad().equalsIgnoreCase(nacionalidad))
				sum++;
		}
		System.out.println("La cantidad de jugadores de "+nacionalidad+" son: "+sum);
	}
	
	public static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner sc) {
		String[] datos = pedirDatos(sc);
		Iterator<Jugador> iterador = jugadores.iterator();
		boolean encontrado = false;
		while(iterador.hasNext() && !encontrado) { // mientras iterator tiene siguiente o bandera, hacer
			Jugador j = iterador.next();
			if(j.getNombre().equalsIgnoreCase(datos[0]) && j.getApellido().equalsIgnoreCase(datos[1])){
				iterador.remove();
				encontrado = !encontrado;
				System.out.println("El jugador se ha eliminado correctamente.");
			}
		}
		if(!encontrado)
			System.out.println("El jugador no se ha encontrado.");
		else {
			System.out.println("Desea ver la lista actualizada de los jugadores. (s/n)");
			if(sc.next().charAt(0)=='s' || sc.next().charAt(0)=='S')
				mostrarJugadores(jugadores);
		}
	}
	
	public static void modificarJugador(ArrayList<Jugador> jugadores, Scanner sc) {
		System.out.println("Ingrese los datos del Jugador como se encuentra en la lista. Si no sabe ingrese el valor 3 en el menu principal.");
		String[] datos = pedirDatos(sc);
		int indice = 0;
		for(int i=0;i<jugadores.size();i++) {
			if(jugadores.get(i).getNombre().equalsIgnoreCase(datos[0]) && jugadores.get(i).getApellido().equalsIgnoreCase(datos[1])) {
				indice = i;
				System.out.println("El jugador ha sido encontrado.");
			}
		}
		//jugadores.removeIf(jugador -> (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)));
		jugadores.remove(indice);
		System.out.println("Ingrese de nuevo todos los datos del jugador.");
		jugadores.add(indice, altaJugador(sc));
	}
	
	public static void mostrarJugadores(ArrayList<Jugador> jugadores) {
		if(jugadores.isEmpty())
			System.out.println("No agrego ningún jugador aún. La lista esta vacia.");
		else {
			jugadores.sort(Comparator.comparing(Jugador::getApellido));
			jugadores.forEach(jugador -> System.out.println(jugador));
		}
			/*for(Jugador j : jugadores) {
				System.out.println(j);
			}*/
	}
	
	public static void mostrarUnJugador(ArrayList<Jugador> jugadores, Scanner sc) { //deberia ser una funcion buscar que devuelva el jugador encontado, sino mensaje de error
		String[] datos = pedirDatos(sc);
		boolean encontrado = false;
		for(Jugador j : jugadores) {
			if(j.getNombre().equalsIgnoreCase(datos[0]) && j.getApellido().equalsIgnoreCase(datos[1])) {
				System.out.println(j);
				encontrado = true;
			}
		}
		if(!encontrado)
			System.out.println("El jugador no se ha encontrado.");
	}
	
	public static Jugador altaJugador(Scanner sc) {
		Jugador jugador = new Jugador();
		System.out.println("Ingrese el nombre del jugador: ");
		jugador.setNombre(sc.next());
		System.out.println("Ingrese el apellido del jugador: ");
		jugador.setApellido(sc.next());
		boolean valido = false;
		while(!valido) {
			try {
				System.out.println("Fecha de Nac.\nIngrese el dia de nacimiento: ");
				int diaNacimiento = sc.nextInt();
				System.out.println("Ingrese el mes de nacimiento: ");
				int mesNacimiento = sc.nextInt();
				System.out.println("Ingrese el año de nacimiento: ");
				int anioNacimiento = sc.nextInt();
				jugador.setFechaNacimiento(LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento));
				valido = true;
			}catch (DateTimeException e) {
				System.out.println("Error: Fecha inválida. Vuelva a ingresar la fecha.");
			}
		}
		
		System.out.println("Ingrese la nacionalidad del jugador: ");
		jugador.setNacionalidad(sc.next());
		valido = false;
		while(!valido) {
			try {
				System.out.println("Ingrese la altura del jugador: ");
				jugador.setAltura(sc.nextFloat());//controlar q el valor sea un float
				System.out.println("Ingrese el peso del jugador: ");
				jugador.setPeso(sc.nextFloat());
				valido = true;
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("El valor ingresado para el peso o la altura son inválidos. Por favor vuelva a ingresar estos datos.");
			}
		}
		String posicion = "";
		while(!posicion.equalsIgnoreCase("delantero") && !posicion.equalsIgnoreCase("medio") && !posicion.equalsIgnoreCase("defensa") && !posicion.equalsIgnoreCase("arquero")) {
			System.out.println("Ingrese la posicion del jugador: (delantero, medio, defensa, arquero)");
			posicion = sc.next();
		}
		jugador.setPosicion(posicion);
		return jugador;	//agregar al arraylist que viene en el argumento de este metodo
	}
	
	public static int seleccionarOpcion(int opcion, Scanner sc, ArrayList<Jugador> jugadores) {
		switch (opcion) {
		case 1: {
			System.out.println("Estas por agregar un nuevo jugador.");
			jugadores.add(altaJugador(sc));
			/*jugadores.add(new Jugador("Hector", "Funes", LocalDate.of(1991, 10, 1), "Arg", 1.79f, 105.6f, "delantero"));
			jugadores.add(new Jugador("Claudia", "Ortiz", LocalDate.of(1971, 5, 3), "Arg", 1.68f, 92.4f, "medio"));
			jugadores.add(new Jugador("Marcelo", "Funes", LocalDate.of(2006, 8, 31), "Arg", 1.81f, 79.2f, "defensa"));
			jugadores.add(new Jugador("Dario", "Funes", LocalDate.of(1997, 11, 5), "Arg", 1.8f, 88.7f, "arquero"));
			jugadores.add(new Jugador("Brenda", "Pacheco", LocalDate.of(1998, 2, 9), "Arg", 1.6f, 92.5f, "medio"));
			*/
			break;
		}
		case 2:{
			mostrarUnJugador(jugadores,sc);
			break;
		}
		case 3:{
			mostrarJugadores(jugadores);
			break;
		}
		case 4:{
			modificarJugador(jugadores,sc);
			break;
		}
		case 5:{
			eliminarJugador(jugadores,sc);
			break;
		}
		case 6:{
			System.out.println("La cantidad total de jugadores es: "+jugadores.size());
			break;
		}
		case 7:{
			cantidadJugadoresNacionalidad(jugadores,sc);
			break;
		}
		case 8:{
			System.out.println("Realmente desea salir? (s/n)");
			if(sc.next().charAt(0)=='s') {
				System.out.println("Programa Terminado.");
				return 8;
			}
			break;
		}
		default:
			System.out.println("Valor Inesperado. Ingrese un valor entre 1 y 8.\n");
			return 0; //throw new IllegalArgumentException("Valor inesperado: " + opcion);//podemos return 0;
		}
		return 0;
	}
	
	public static void menu() {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while(opcion!=8) {
			System.out.println("****** Menu de Opciones *****");
			System.out.println("1- Alta Jugador\n2- Mostrar los datos de un jugador");
			System.out.println("3- Mostrar todos los jugadores\n4- Modificar los datos de un jugador");
			System.out.println("5- Eliminar un jugador\n6- Cantidad total de jugadores");
			System.out.println("7- Cantidad de jugadores de una nacionalidad\n8- Salir");
			System.out.println("Elija un opcion: ");
			try {
				opcion = sc.nextInt();
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("El valor ingresado es inválido.");
			}
			
			if(opcion>1 && opcion<8 && jugadores.isEmpty())
				System.out.println("La lista de jugadores esta VACIA.\n");
			else
				opcion = seleccionarOpcion(opcion,sc,jugadores);
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		menu();
	}

}

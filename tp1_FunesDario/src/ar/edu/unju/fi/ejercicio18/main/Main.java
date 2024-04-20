package ar.edu.unju.fi.ejercicio18.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.model.Pais;

public class Main {
	
	private static void destinosUnPais(ArrayList<DestinoTuristico> destinos, Scanner sc) {
		System.out.println("Ingrese el código del pais: ");
		String codigo = sc.next();
		/*
		 * Iterator<DestinoTuristico> iterador = destinos.iterator(); DestinoTuristico
		 * d; while(iterador.hasNext()) { d = iterador.next();
		 * if(d.getPais().getCodigo().equalsIgnoreCase(codigo)) System.out.println(d); }
		 */
		for(DestinoTuristico d : destinos) {
			if(d.getPais().getCodigo().equalsIgnoreCase(codigo))
				System.out.println(d);
		}
	}
	
	private static void mostrarDestinosPorNombre(ArrayList<DestinoTuristico> destinos) {
		destinos.sort(Comparator.comparing(DestinoTuristico::getNombre));
		destinos.forEach(destino -> System.out.println(destino));
	}
	
	private static void eliminarDestino(ArrayList<DestinoTuristico> destinos, Scanner sc) {
		System.out.println("Ingrese el código del Destino Turistico: ");
		String codigo = sc.next();
		if(buscarDestino(destinos,codigo)!=null)
			System.out.println("Destino Turistico se ha eliminado exitosamente.");
		else
			System.out.println("El codigo es erroneo. Vuelva a intentar.");
		
	}
	
	private static void borrarDestinos(ArrayList<DestinoTuristico> destinos, Scanner sc) {
		System.out.println("Esta seguro que desea ELIMINAR todos los Destinos Turisticos de la lista? (s/n)");
		char resp = sc.next().charAt(0);
		if(resp=='s' || resp=='S') {
			destinos.clear();
			System.out.println("Se ha eliminado toda la lista de Destinos Turisticos correctamente.");
		}else
			System.out.println("NO se borraron los Destinos Turisticos");
	}
	
	private static DestinoTuristico buscarDestino(ArrayList<DestinoTuristico> destinos,String codigo) {
		Iterator<DestinoTuristico> iterador = destinos.iterator();
		DestinoTuristico d;
		while(iterador.hasNext()) {
			d = iterador.next();
			if(d.getCodigo().equalsIgnoreCase(codigo)) {
				iterador.remove();
				return d;
			}
		}
		return null;
	}
	
	private static void modificarPais(ArrayList<DestinoTuristico> destinos,ArrayList<Pais> paises, Scanner sc) {
		System.out.println("Ingrese el código del Destino Turistico: ");
		String codigo = sc.next();
		DestinoTuristico d = buscarDestino(destinos,codigo);
		boolean valido = false;
		while(!valido) {
			try {
				paises.forEach(pais -> System.out.println(pais));
				System.out.println("Ingrese el nuevo codigo de pais, los codigos validos se muestra arriba: ");
				codigo = sc.next();
				d.setPais(paises.get(buscarPais(paises,codigo)));
				valido = true;
			}catch (IndexOutOfBoundsException e) {
				System.out.println("Error: Codigo del país inválido. Vuelva a ingresar el codigo.");
			}
		}
		if(d!=null) {
			destinos.add(d);
			System.out.println("Destino Turistico modificado exitosamente.");
		}else
			System.out.println("El codigo es erroneo. Vuelva a intentar.");
	}
	
	private static void mostrarDestinos(ArrayList<DestinoTuristico> destinos) {
		System.out.println("Se muestran todos los Destinos Turisticos: ");
		for(DestinoTuristico d : destinos) {
			System.out.println(d);
		}
	}
	
	private static int buscarPais(ArrayList<Pais> paises, String codigo) {
		for(int i=0;i<paises.size();i++) {
			if(paises.get(i).getCodigo().equalsIgnoreCase(codigo))
				return i;
		}
		return -1;
	}
	
	public static void alta(ArrayList<DestinoTuristico> destinos,Scanner sc, ArrayList<Pais> paises) {
		DestinoTuristico destino = new DestinoTuristico();
		System.out.println("Ingrese el código del Destino Turistico: ");
		destino.setCodigo(sc.next());
		System.out.println("Ingrese el nombre del Destino Turistico: ");
		destino.setNombre(sc.next());
		boolean valido = false;
		while(!valido) {
			try {
				paises.forEach(pais -> System.out.println(pais));
				System.out.println("Ingrese el codigo de pais, los codigos se muestra arriba: ");
				String codigo = sc.next();
				destino.setPais(paises.get(buscarPais(paises,codigo)));
				valido = true;
			}catch (IndexOutOfBoundsException e) {
				System.out.println("Error: Codigo del país inválido. Vuelva a ingresar los datos.");
			}
		}
		
		valido = false;
		while(!valido) {
			try {
				System.out.println("Ingrese el precio del Destino Turistico: ");
				destino.setPrecio(sc.nextFloat());
				System.out.println("Ingrese la cantidad de días del Viaje: ");
				destino.setCantidadDias(sc.nextInt());
				valido = true;
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("El valor ingresado para el precio o la caantidad de días es inválido. Por favor vuelva a ingresar estos datos.");
			}
		}
		destinos.add(destino);
	}
	
	private static int seleccionarOpcion(int opcion, Scanner sc, ArrayList<DestinoTuristico> destinos, ArrayList<Pais> paises) {
		switch (opcion) {
		case 1: {
			/*
			System.out.println("Estas por agregar un nuevo Destino Turístico.");
			alta(destinos,sc,paises);
			*/
			destinos.add(new DestinoTuristico("D1", "Francia", 10000000.00f, new Pais("Fra", "Francia"), 4));
			destinos.add(new DestinoTuristico("D2", "Roma", 15000000.00f, new Pais("Ita", "Italia"), 7));
			destinos.add(new DestinoTuristico("D3", "Bogota", 11000000.00f, new Pais("Col", "Colombia"), 3));
			destinos.add(new DestinoTuristico("D4", "Buenos Aires", 14000000.00f, new Pais("Arg", "Argentina"), 9));
			destinos.add(new DestinoTuristico("D7", "Jujuy", 9000000.00f, new Pais("Arg", "Argentina"), 5));
			destinos.add(new DestinoTuristico("D5", "Tokio", 17000000.00f, new Pais("Jap", "Japon"), 5));
			destinos.add(new DestinoTuristico("D6", "Pekin", 20000000.00f, new Pais("Zin", "China"), 2));
			break;
		}
		case 2:{
			mostrarDestinos(destinos);
			break;
		}
		case 3:{
			modificarPais(destinos,paises,sc);
			break;
		}
		case 4:{
			borrarDestinos(destinos,sc);
			break;
		}
		case 5:{
			eliminarDestino(destinos,sc);
			break;
		}
		case 6:{
			mostrarDestinosPorNombre(destinos);
			break;
		}
		case 7:{
			System.out.println("Se muestran todos los Paises: ");
			paises.forEach(pais -> System.out.println(pais.getNombre()));
			break;
		}
		case 8:{
			destinosUnPais(destinos,sc);
			break;
		}
		case 9:{
			System.out.println("Realmente desea salir? (s/n)");
			if(sc.next().charAt(0)=='s') {
				System.out.println("Programa Terminado.");
				return 9;
			}
			break;
		}
		default:
			System.out.println("Valor Inesperado. Ingrese un valor entre 1 y 9.\n");
			return 0; //throw new IllegalArgumentException("Valor inesperado: " + opcion);//podemos return 0;
		}
		return 0;
	}
	
	private static void menu() {
		ArrayList<DestinoTuristico> destinos = new ArrayList<>();
		ArrayList<Pais> paises = new ArrayList<>();
		paises.add(new Pais("Arg","Argentina"));
		paises.add(new Pais("Bra","Brasil"));
		paises.add(new Pais("Chi","Chile"));
		paises.add(new Pais("Col","Colombia"));
		paises.add(new Pais("USA","Estados Unidos"));
		paises.add(new Pais("Esp","España"));
		paises.add(new Pais("Fra","Francia"));
		paises.add(new Pais("Ita","Italia"));
		paises.add(new Pais("Ing","Inglaterra"));
		paises.add(new Pais("Bel","Belgica"));
		paises.add(new Pais("Can","Canada"));
		paises.add(new Pais("Zin","China"));
		paises.add(new Pais("Jap","Japon"));
		//System.out.println("Cod - Paises");
		//paises.forEach(pais -> System.out.println(pais));
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while(opcion!=9) {
			System.out.println("****** Menu de Opciones *****");
			System.out.println("1- Alta de Destino Turístico\n2- Mostrar todos los Destinos Turísticos"
					+"\n3- Modificar el País de un Destino Turístico\n4- Borrar toda la lista de Destinos Turísticos"
					+"\n5- Eliminar un Destino Turístico\n6- Mostrar los Destinos Turísticos Ordenados Por Nombre"
					+"\n7- Mostrar todos los Países\n8- Mostrar los Destinos Turísticos de un País\n9- Salir"
					+"\nElija un opcion: ");
			try {
				opcion = sc.nextInt();
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("El valor ingresado es inválido.");
			}
			if(opcion>1 && opcion<9 && destinos.isEmpty())
				System.out.println("La lista de Destinos Turisticos esta VACIA.\n");
			else
				opcion = seleccionarOpcion(opcion,sc,destinos,paises);
		}
		sc.close();
	}

	public static void main(String[] args) {
		menu();
	}

}

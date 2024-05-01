package ar.edu.unju.fi.ejercicio04.main;

import ar.edu.unju.fi.ejercicio04.model.Jugador;
import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<Jugador> jugador = new ArrayList<Jugador>();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		int op = 0;
		
		do {
			
			try
			{
			System.out.println("Menu de Opciones: ");
			System.out.println("1- Alta del Jugador: ");
			System.out.println("2- Mostrar todos los jugadores: ");
			System.out.println("3- Modificar del Jugador: ");
			System.out.println("4- Eliminar un Jugador: ");
			System.out.println("5- Salir del Programa: ");
			op = scanner.nextInt();
			}catch(Exception e)
			{
				System.out.println("!!!Error al ingresar el valor, por favor ingrese de nuevo un numero valido");
				scanner.next();
				continue;
			}
			switch(op)
			{
				case 1:
					System.out.println("Ingrese el nombre del jugador: ");
                    String nombre = scanner.next();
                    System.out.println("Ingrese el apellido del jugador: ");
                    String apellido = scanner.next();
                    System.out.println("Ingrese la fecha de nacimiento del jugador (dd-MM-yyyy): ");
                    LocalDate fechaNacimiento = LocalDate.parse(scanner.next(), formato);
                    System.out.println("Ingrese la nacionalidad del jugador: ");
                    String nacionalidad = scanner.next();
                    System.out.println("Ingrese la estatura del jugador: ");
                    double estatura = scanner.nextDouble();
                    System.out.println("Ingrese el peso del jugador: ");
                    double peso = scanner.nextDouble();
                    System.out.println("Ingrese la posición del jugador: ");
                    String posicionStr = scanner.next();
                    Posicion posicion = Posicion.valueOf(posicionStr.toUpperCase());
                    jugador.add(new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion));
                    System.out.println("Jugador creado con EXITO!");
                break;
				case 2:
					for (Jugador jugadores : jugador) {
			            System.out.println("Nombre: " + jugadores.getNombre());
			            System.out.println("Apellido: " + jugadores.getApellido());
			            System.out.println("Fecha de Nacimiento: " + jugadores.getFechaNacimiento());
			            System.out.println("Nacionalidad: " + jugadores.getNacionalidad());
			            System.out.println("Estatura: " + jugadores.getEstatura());
			            System.out.println("Peso del Jugador: " + jugadores.getPeso());
			            System.out.println("Posicion: " + jugadores.getPosicion());
			            System.out.println("---------------------------------");}
                break;
				case 3:
					System.out.println("Ingrese el nombre del jugador: ");
                    String nombreMod = scanner.next();
                    System.out.println("Ingrese el apellido del jugador: ");
                    String apellidoMod = scanner.next();
                    Jugador jugadorMod = null;
                    for (Jugador jugadores : jugador) {
                        if (jugadores.getNombre().equals(nombreMod) && jugadores.getApellido().equals(apellidoMod)) {
                            jugadorMod = jugadores;
                            break;
                        }
                    }
                    if (jugadorMod != null) {
                        System.out.println("Ingrese la nueva posición del jugador:");
                        String nuevaPosicionStr = scanner.next();
                        Posicion nuevaPosicion = Posicion.valueOf(nuevaPosicionStr.toUpperCase());
                        jugadorMod.setPosicion(nuevaPosicion);
                    } else {
                        System.out.println("El Jugador no se encontrado.");
                    }
                 break;
				case 4:
					System.out.println("Ingrese el nombre del jugador que quiere eliminar: ");
                    String nombreRemove = scanner.next();
                    System.out.println("Ingrese el apellido del jugador que quiere eliminar: ");
                    String apellidoRemove = scanner.next();
                    Iterator<Jugador> iterator = jugador.iterator();
                    while (iterator.hasNext()) {
                        Jugador jugadores = iterator.next();
                        if (jugadores.getNombre().equals(nombreRemove) && jugadores.getApellido().equals(apellidoRemove)) {
                            iterator.remove();
                            break;
                        }
                    }
				break;
				case 5:
					System.out.println("Saliendo del programa...Hasta luego!");
				break;
				default:
					System.out.println("Opcion ingresada incorrecta!! Ingrese de vuelta un numero valido");
				break;
			}
			
		}while(op != 5);
		
		scanner.close();
	}

}

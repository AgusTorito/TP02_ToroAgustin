package ar.edu.unju.fi.ejercicio02.main;

import ar.edu.unju.fi.ejercicio02.model.Efemeride;
import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<Efemeride> efem = new ArrayList<Efemeride>();
		
		int opcion = 0;
		do {
			
			try {
				System.out.println("------------Menu----------");
				System.out.println("1- Crear una Efemeride");
				System.out.println("2- Mostrar Efemeridess");
				System.out.println("3- Eliminar Efemeride");
				System.out.println("4- Modificar Efemeride");
				System.out.println("5- Salir del Programa");
				opcion = scanner.nextInt();
				}catch(Exception e)
				{
					System.out.println("Error: Entrada inválida. Por favor, ingresa un número válido.");
	                scanner.next();
	                continue;
				}
			
			switch(opcion)
			{
				case 1:
					System.out.println("Ingrese el codigo de la efemeride: ");
					String codigo = scanner.next();
					System.out.println("Ingrese el dia de la efemeride: ");
					int dia = scanner.nextInt();
					System.out.println("Ingrese los detalles de la efemeride: ");
					scanner.nextLine();
					String detalles = scanner.nextLine();
					System.out.println("Ingrese el mes de la Efemeride [1 a 12]: ");
					int numeroMes = scanner.nextInt();
					Mes mes;
					if(numeroMes >= 1 && numeroMes <= 12)
					{
						mes = Mes.values()[numeroMes - 1];
					}
					else
					{
						System.out.println("Valor ingresado incorrecto");
						break;
					}
					
					Efemeride efemeride = new Efemeride(codigo, mes, dia, detalles);
					efem.add(efemeride);
				break;
				
				case 2:
					for (Efemeride ef : efem) {
			            System.out.println("Código: " + ef.getCodigo());
			            System.out.println("Mes: " + ef.getMes());
			            System.out.println("Dia: " + ef.getDia());
			            System.out.println("Detalles: " + ef.getDetalle());
			            System.out.println("---------------------------------");
			        }
				break;
				case 3:
					if(efem.isEmpty())
					{
						System.out.println("No se encuentra ninguna efemeride para eliminar");
						break;
					}
					else
					{
						System.out.println("Ingrese el codigo de la efemeride que quiere eliminar: ");
						String numCod = scanner.next();
						efem.removeIf(ef -> ef.getCodigo().equals(numCod));//error correjido
						break;
					}
				case 4:
					if (efem.isEmpty()) {
                        System.out.println("No hay efemerides para modificar.");
                        break;
                    }
                    System.out.print("Ingrese codigo de efemeride a modificar: ");
                    String codigoModificar = scanner.next();
                    Efemeride efemerideModificar = efem.stream().filter(ef -> ef.getCodigo().equals(codigoModificar)).findFirst().orElse(null);//error correjido
                    
                    if (efemerideModificar == null) {
                        System.out.println("Efeméride no encontrada.");
                        break;
                    }
                    System.out.print("Ingrese nuevo día: ");
                    int nuevoDia = scanner.nextInt();
                    System.out.print("Ingrese nuevo detalle: ");
                    scanner.nextLine();
                    String nuevoDetalle = scanner.nextLine();
                    System.out.print("Ingrese nuevo mes (1-12): ");
                    int nuevoMesNumero = scanner.nextInt();
                    Mes nuevoMes;
                    nuevoMes = Mes.values()[nuevoMesNumero - 1];
                    if (nuevoMes == null) {
                        System.out.println("Mes inválido.");
                        break;
                    }
                    efemerideModificar.setMes(nuevoMes);
                    efemerideModificar.setDia(nuevoDia);
                    efemerideModificar.setDetalle(nuevoDetalle);
                    break;
				case 5:
					System.out.println("Saliendo del Programa...");
				break;
				default:
					System.out.println("Opcion incorrecta");
				break;
			}
			
		}while(opcion != 5);
		scanner.close();
	}

}

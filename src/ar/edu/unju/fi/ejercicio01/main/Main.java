package ar.edu.unju.fi.ejercicio01.main;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		List<Producto> productos = new ArrayList<Producto>();
		int op=0;
		do
		{
			try {
			System.out.println("------------Menu----------");
			System.out.println("1- Crear un Producto");
			System.out.println("2- Mostrar los Productos Creados");
			System.out.println("3- Modificar un Producto");
			System.out.println("4- Salir del programa");
			op = scanner.nextInt();
			}catch(Exception e)
			{
				System.out.println("Error: Entrada inválida. Por favor, ingresa un número válido.");
                scanner.next(); // Limpia el buffer del scanner
                continue;
			}
			switch(op)
			{
				case 1: 
					System.out.print("Ingrese código del producto: ");
			        String codigo = scanner.next();
			        System.out.print("Ingrese descripción del producto: ");
			        scanner.nextLine();
			        String descripcion = scanner.nextLine();			 
			        System.out.print("Ingrese precio unitario del producto: ");
			        double precioUnitario = scanner.nextDouble();

			        System.out.println("---- Origen de fabricación ------");
			        System.out.println("1 - Argentina");
			        System.out.println("2 - China");
			        System.out.println("3 - Brasil");
			        System.out.println("4 - Uruguay");
			        System.out.print("Elija una opción: ");
			        int origenFabricacionOpcion = scanner.nextInt();
			        Producto.OrigenFabricacion origenFabricacion = getOrigenFabricacion(origenFabricacionOpcion);

			        System.out.println("------ Categoría ------");
			        System.out.println("1 – Telefonía");
			        System.out.println("2 – Informática");
			        System.out.println("3 – Electro hogar");
			        System.out.println("4 – Herramientas");
			        System.out.print("Elija una opción: ");
			        int categoriaOpcion = scanner.nextInt();
			        Producto.Categoria categoria = getCategoria(categoriaOpcion);

			        Producto producto = new Producto();
			        producto.setCodigo(codigo);
			        producto.setDescripcion(descripcion);
			        producto.setPrecioU(precioUnitario);
			        producto.setOrigenfabricacion(origenFabricacion);
			        producto.setCategoria(categoria);

			        productos.add(producto);
			        System.out.println("Producto creado con éxito!");
				break;
				case 2:
					for (Producto prod : productos) {
			            System.out.println("Código: " + prod.getCodigo());
			            System.out.println("Descripción: " + prod.getDescripcion());
			            System.out.println("Precio unitario: " + prod.getPrecioU());
			            System.out.println("Origen de fabricación: " + prod.getOrigenfabricacion());
			            System.out.println("Categoría: " + prod.getCategoria());
			            System.out.println("---------------------------------");
			        }
				break;
				case 3:
					if (productos.isEmpty()) {
				        System.out.println("No hay productos para modificar.");
				        break;
				    }

				    // Muestra la lista de productos para que el usuario elija cuál modificar
				    for (int i = 0; i < productos.size(); i++) {
				        System.out.println((i + 1) + ". " + productos.get(i));
				    }

				    System.out.print("Elija el producto que quiere modificar: ");
				    int indiceProducto = scanner.nextInt() - 1;

				    Producto productoSeleccionado = productos.get(indiceProducto);

				    System.out.println("1 – Modificar descripción");
				    System.out.println("2 – Modificar precio unitario");
				    System.out.println("3 – Modificar origen de fabricación");
				    System.out.println("4 – Modificar categoría");
				    System.out.print("Elija una opción: ");
				    int opcionModificacion = scanner.nextInt();

				    switch (opcionModificacion) {
				        case 1:
				            System.out.print("Ingrese nueva descripción: ");
				            scanner.nextLine();
				            productoSeleccionado.setDescripcion(scanner.nextLine());
				            break;
				        case 2:
				            System.out.print("Ingrese nuevo precio unitario: ");
				            productoSeleccionado.setPrecioU(scanner.nextDouble());
				            break;
				        case 3:
				            System.out.println("Origen de fabricación ");
				            for (int i = 0; i < Producto.OrigenFabricacion.values().length; i++) {
				                System.out.println((i + 1) + " - " + Producto.OrigenFabricacion.values()[i]);
				            }
				            System.out.print("Elija una opción: ");
				            int indiceOrigenFabricacion = scanner.nextInt() - 1;
				            productoSeleccionado.setOrigenfabricacion(Producto.OrigenFabricacion.values()[indiceOrigenFabricacion]);
				            break;
				        case 4:
				            System.out.println("Categoría ");
				            for (int i = 0; i < Producto.Categoria.values().length; i++) {
				                System.out.println((i + 1) + " – " + Producto.Categoria.values()[i]);
				            }
				            System.out.print("Elija una opción: ");
				            int indiceCategoria = scanner.nextInt() - 1;
				            productoSeleccionado.setCategoria(Producto.Categoria.values()[indiceCategoria]);
				            break;
				        default:
				            System.out.println("Opción inválida.");
				        break;
				    }
				        case 4: 
				        	System.out.println("Saliendo del programa");
				        break;
				        default:
				            System.out.println("Opción inválida.");
				        break;
				    }			

		}while(op != 4);
		scanner.close();//Sirve para cerrar el scanner cuando no sea necesario
	}

	private static Producto.OrigenFabricacion getOrigenFabricacion(int opcion) {
        switch (opcion) {
            case 1:
                return Producto.OrigenFabricacion.ARGENTINA;
            case 2:
                return Producto.OrigenFabricacion.CHINA;
            case 3:
                return Producto.OrigenFabricacion.BRASIL;
            case 4:
                return Producto.OrigenFabricacion.URUGUAY;
            default:
                throw new RuntimeException("Opción de origen de fabricación inválida");
        }
    }

    private static Producto.Categoria getCategoria(int opcion) {
        switch (opcion) {
            case 1:
                return Producto.Categoria.TELEFONIA;
            case 2:
                return Producto.Categoria.INFORMATICA;
            case 3:
                return Producto.Categoria.ELECTROHOGAR;
            case 4:
                return Producto.Categoria.HERRAMIENTAS;
            default:
                throw new RuntimeException("Opción de categoría inválida");
        }
		
	}

}

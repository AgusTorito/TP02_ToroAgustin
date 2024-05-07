package ar.edu.unju.fi.ejercicio07.main;

import ar.edu.unju.fi.ejercicio07.model.Producto;
import ar.edu.unju.fi.ejercicio07.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio07.model.Producto.OrigenFabricacion;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Comparator;


public class Main {
	private static List<Producto> productos = new ArrayList<Producto>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		CargarProductos(productos);
		
		int op=0;
		boolean bandera=false;
		
		do {
			
			do {
			System.out.println("-------Menu------");
			System.out.println("1- Mostrar los Productos");
			System.out.println("2- Mostrar los Productos Faltantes");
			System.out.println("3- Incrementar los precios de los productos en un 20%");
			System.out.println("4- Mostrar los Productos que corresponden a la categoria Electrohogar y esten disponibles para la venta");
			System.out.println("5- Ordenar los Productos por precio de forma descendente");
			System.out.println("6- Mostrar los productos con los nombres en mayusculas");
			System.out.println("7- Salir del Programa...");
			try
			{
				op = scanner.nextInt();
				if(op < 1 || op > 7)
				{
					System.out.println("Opcion ingresada no valida!!!");
				}
				else
				{
					bandera=true;
				}
				}catch(NumberFormatException e)
				{
					System.out.println("Ingrese de vuelta el numero");
					scanner.close();
					continue;
				}
			}while(bandera!=true);
			
			switch(op)
			{
				case 1:  
					mostrarProductos(productos);
				break;
				case 2:
					mostrarNoDisponibles(productos);
				break;
				case 3: 
					System.out.println("Aumento de precio de todos los Productos");
					List<Producto> productosAumentados = AumentarPrecio(productos);
					mostrarProductos(productosAumentados);
				break;
				case 4:
					List<Producto> pelec = productosElectrohogar(productos, "ELECTROHOGAR");
					mostrarProductos(pelec);
				break;
				case 5:
					OrdenarProductos(productos);
					mostrarProductos(productos);
				break;
				case 6:
					MostrarMayusculas(productos);
				break;
				case 7: System.out.println("Saliendo del Programa... Hasta luego Estimado!");
				break;
			}
			
		}while(op != 7);				
		scanner.close();
	}
	
	
	
	public static void CargarProductos(List<Producto> productos)
	{
		productos.add(new Producto("123", "PC de escritorio", 600000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		productos.add(new Producto("456", "Cocina", 800000, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("789", "Lavaropa", 700000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("159", "Celuar Moto g52", 200000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		productos.add(new Producto("753", "Celuar Samsung A20", 250000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false));
		productos.add(new Producto("486", "Caja de Herramientas", 100000, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto("153", "Prime Video", 2000, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
		productos.add(new Producto("426", "Nexflix", 4000, OrigenFabricacion.CHINA, Categoria.TELEFONIA, false));
		productos.add(new Producto("268", "Monitor", 50000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		productos.add(new Producto("684", "Teclado Gamar RGB", 20000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false));
		productos.add(new Producto("624", "Mouse Gamer RGB", 600000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		productos.add(new Producto("639", "Heladera", 700000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("654", "Bicicleta Rodado 3", 500000, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, false));
		productos.add(new Producto("582", "Maguera", 50000, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto("528", "Star Plus", 1000, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true));	
	}
	
	public static void mostrarProductos(List<Producto> productos)
	{
		Consumer<Producto> mostrar = e -> {if(e.isEstado())
				System.out.println("Codigo del Producto: "+e.getCodigo());
				System.out.println("Nombre del Producto: "+e.getDescripcion());
				System.out.println("Precio del Producto: $"+e.getPrecioU());
				System.out.println("Origen de Fabricacion: "+e.getOrigenfabricacion());
				System.out.println("Categoria: "+e.getCategoria());
				System.out.println("\n");
		};
		productos.forEach(mostrar);
	}
	
	public static void mostrarNoDisponibles(List<Producto> productos)
	{
		Predicate<Producto> mostrar = p -> !p.isEstado();
		productos.stream().filter(mostrar).forEach(System.out::println);
		
	}
	
	public static List<Producto> AumentarPrecio(List<Producto> productos)
	{
		Function<Producto, Producto> nuevoProducto = p -> {
			p.setPrecioU(p.getPrecioU()*1.20d);
			return p;
		};
		
		return productos.stream().map(p -> new Producto(p.getCodigo(), p.getDescripcion(), p.getPrecioU() * 1.20d, p.getOrigenfabricacion(), p.getCategoria(), p.isEstado()))
        .collect(Collectors.toCollection(() -> new ArrayList<>()));	
	}
	
	public static List<Producto> productosElectrohogar(List<Producto> productos, String c)
	{
		Predicate<Producto> categoria = h -> h.getCategoria().equals(c) && h.isEstado();
		return productos.stream().filter(categoria).collect(Collectors.toList());
	}
	
	public static void OrdenarProductos(List<Producto> productos)
	{
		productos.sort(new Comparator<Producto>() {
	        public int compare(Producto productos1, Producto productos2) {
	            return Double.compare(productos2.getPrecioU(), productos1.getPrecioU());
	        }
	    });
	}
	
	public static void MostrarMayusculas(List<Producto> productos)
	{
		 productos.stream()
         .map(q -> q.getDescripcion().toUpperCase())
         .forEach(n -> System.out.println(n));
	}
	
}

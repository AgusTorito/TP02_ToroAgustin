package ar.edu.unju.fi.ejercicio05.main;

import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio05.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Producto> productos = new ArrayList<Producto>();
		CargarProductos(productos);
		
		int opcion = 0;
		boolean v = false;
		
		do{
			do {
				v=false;
				System.out.println("Menu");
				System.out.println("1- Mostrar Productos");
				System.out.println("2- Realizar Compra");
				System.out.println("3- Salir del programa");
				try {
				opcion = scanner.nextInt();
				if(opcion < 1 || opcion > 3)
				{
					System.out.println("Numero no valido!!");
				}
				else
				{
					v=true;
				}
				}catch(NumberFormatException e){
					System.out.println("Ingrese de vuelta el numero");
					scanner.close();
					continue;
				}
			}while(v!=true);
		
			switch(opcion)
			{
				case 1: 
					ProductoDisponibles(productos);
				break;
				case 2: 
					RealizarCompra(productos);
				break;
				case 3:
					System.out.println("Saliendo del Programa...");
				break;
			}
			
		}while(opcion != 3);
		scanner.close();
	}
	
	public static void CargarProductos(ArrayList<Producto> productos)
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
	
	public static void ProductoDisponibles(ArrayList<Producto> productos)
	{
		for(Producto prod : productos)
		{			
				System.out.println("Codigo de Producto: "+prod.getCodigo());
				System.out.println("Descripcion del Producto: "+prod.getDescripcion());
				System.out.println("Precio del Producto: "+prod.getPrecioU());
				System.out.println("Origen de Fabricacion del Producto: "+prod.getOrigenfabricacion());
				System.out.println("Categoria del Producto: "+prod.getCategoria());
				if(prod.isEstado())
				{
					System.out.println("DISPONIBLE\n");
				}
				else
				{
					System.out.println("NO DISPONIBLE\n");
				}
		}
	}
	
	public static void RealizarCompra(ArrayList<Producto> productos)
	{
		List<Producto> productoSeleccionado = new ArrayList<Producto>();
		double CompraTotal = 0;
		
		System.out.println("Ingrese el codigo del producto que desea comprar(Para terminar la transaccion, ingresar el 0)");
		String codigoProducto;
		do {
			codigoProducto = scanner.nextLine();
			if(!codigoProducto.equals("0"))
			{
				Producto prodSelec = buscarProdCodigo(productos, codigoProducto);
				if(prodSelec != null && prodSelec.isEstado())
				{
					productoSeleccionado.add(prodSelec);
					CompraTotal += prodSelec.getPrecioU();
				}
			}
			
		}while(!codigoProducto.equals("0"));
		
		System.out.println("Resumen de la compra");
		for(Producto producto : productoSeleccionado)
		{
			System.out.println(producto.getDescripcion()+" - $"+producto.getPrecioU());
		}
		System.out.println("Total de la compra: $"+ CompraTotal);
		
		System.out.println("\nSeleccione el metodo de Pago: ");
		System.out.println("1- Pago en Efectivo(10% de descuento): ");
		System.out.println("2- Pago con Tarjeta(15% de aumento): ");
		int metodoPago = scanner.nextInt();
		
		switch(metodoPago)
		{
			case 1: 
				PagoEfectivo pagoEfectivo = new PagoEfectivo(CompraTotal, LocalDate.now());
				pagoEfectivo.realizarPago(CompraTotal);
				pagoEfectivo.imprimirRecibo();
			break;
			case 2:
				scanner.nextLine();
				System.out.println("Ingrese el numero de tarjeta: ");
				String NumeroTarjeta = scanner.nextLine();
				PagoTarjeta pagoTarjeta = new PagoTarjeta(NumeroTarjeta, LocalDate.now(), CompraTotal);
				pagoTarjeta.realizarPago(CompraTotal);
				pagoTarjeta.imprimirRecibo();
			break;
			default:
				System.out.println("Opcion Incorrecta!!!");
			break;
		}
	}

	public static Producto buscarProdCodigo(ArrayList<Producto> productos, String codigo) {
	    for (Producto producto : productos) {
	        if (producto.getCodigo().equals(codigo)) {
	            return producto;
	        }
	    }
	    return null;
	}
}

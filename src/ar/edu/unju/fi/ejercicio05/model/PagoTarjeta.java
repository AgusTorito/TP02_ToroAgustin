package ar.edu.unju.fi.ejercicio05.model;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;
import java.time.LocalDate;

public class PagoTarjeta {
	private String NumeroTarjeta;
	private LocalDate FechaPago;
	private double MontoPagado;
	
	public PagoTarjeta(String NumeroTarjeta, LocalDate FechaPago, double MontoPagado)
	{
		this.NumeroTarjeta = NumeroTarjeta;
		this.FechaPago = FechaPago;
		this.MontoPagado = MontoPagado;
	}
	
	public void realizarPago(double monto)
	{
		MontoPagado = monto + (monto * 0.15);
	}
	
	public void imprimirRecibo()
	{
		System.out.println("El numero de Tarjeta es: "+NumeroTarjeta);
		System.out.println("La fecha de Pago es: "+FechaPago);
		System.out.println("El monto Pagado es $: "+MontoPagado);
	}
}

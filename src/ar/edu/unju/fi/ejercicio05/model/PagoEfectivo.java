package ar.edu.unju.fi.ejercicio05.model;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;
import java.time.LocalDate;

public class PagoEfectivo implements Pago {
	private double MontoPagado;
	private LocalDate FechaPago;
	
	public PagoEfectivo(double MontoPagado, LocalDate FechaPago)
	{
		this.FechaPago = FechaPago;
		this.MontoPagado = MontoPagado;
	}
	
	@Override
	public void realizarPago(double monto)
	{
		MontoPagado=monto-(monto*0.10);
	}
	
	@Override
	public void imprimirRecibo()
	{
		System.out.println("Monto de Pago $: "+MontoPagado);
		System.out.println("Fecha de Pago: "+FechaPago);
	}
	
}

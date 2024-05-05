package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;
import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		//Definicion de expresion lambda que define el convertidor de FelinoDomestico a FelinoSalvaje
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),
		x.getEdad(), x.getPeso());
		//Se realiza la conversion
		FelinoSalvaje felino1 = converter.convert(gato);
		//mostramos los datos del objeto felino salvaje felino1
		converter.mostrarObjeto(felino1);
		
		
		FelinoSalvaje gato2 = new FelinoSalvaje("Tanner", (byte)20, 186f);
		Converter<FelinoSalvaje, FelinoDomestico> converter2 = f -> new FelinoDomestico(f.getNombre(), f.getEdad(), f.getPeso());
		
		if(Converter.isNotNull(gato2))
		{
			FelinoDomestico felino2 = converter2.convert(gato2);
			System.out.println("Realizando la conversión de un objeto felino salvaje a doméstico.");
            System.out.println("Antes de realizar la conversión, verifique que el objeto a convertir no es nulo.");
			converter2.mostrarObjeto(felino2);
		}
		
	}
	
}

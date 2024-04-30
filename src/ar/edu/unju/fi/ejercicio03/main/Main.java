package ar.edu.unju.fi.ejercicio03.main;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        Provincia[] provincias = Provincia.values();

	        for (Provincia provincia : provincias) {
	            System.out.printf("%s%nPoblación: %d%nSuperficie: %.2f%nDensidad poblacional: %.2f%n--%n",
	                    provincia.name(),
	                    provincia.getCantidadPoblacion(),
	                    provincia.getSuperficie(),
	                provincia.calcularDensidadPoblacional());
	        }
	    
	}

}

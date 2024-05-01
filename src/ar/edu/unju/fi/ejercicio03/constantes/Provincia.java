package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY("300000", 53000.0),
    SALTA("1200000", 155464.0),
    TUCUMAN("1500000", 22524.0),
    CATAMARCA("400000", 102069.0),
    LA_RIOJA("350000", 89620.0),
    SANTIAGO_DEL_ESTERO("800000", 136302.0);

    private  String cantidadPoblacion;
    private  double superficie;

    Provincia(String cantidadPoblacion, double superficie) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
    }

    public int getCantidadPoblacion() {
        return Integer.parseInt(cantidadPoblacion);
    }

    public void setCantidadPoblacion(String cantidadPoblacion) {
        this.cantidadPoblacion = cantidadPoblacion;
    }

    public double getSuperficie() {
        return superficie;
    }

    public double calcularDensidadPoblacional() {
        return getCantidadPoblacion() / superficie;
    }
}

package gestorAplicacion.sujeto;

public enum Categoria {
	ALTO_RENDIMIENTO(1.5),
	OLIMPICO(0.8),
	AFICIONADOS(0.7);
	  
	private final double costoFactor;

	private Categoria(double costoFactor) {
	        this.costoFactor = costoFactor;
	    }

	public double getCostoFactor() {
	        return costoFactor;
	    }

}

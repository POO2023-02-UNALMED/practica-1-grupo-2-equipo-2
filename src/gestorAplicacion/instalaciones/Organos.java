package gestorAplicacion.instalaciones;

public enum Organos {
    OJO(750000),
    OREJA(950000),
    PORCION_DE_HIGADO(1235000),
    RIÑON(1950000),
    UNA_EXTREMIDAD_SUPERIOR(2450000),
    UNA_EXTREMIDAD_INFERIOR(3000000);

    private final int precio;

    Organos(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

}

package gestorAplicacion.instalaciones;

public enum Lugar {
    CONSULTORIO(40000),
    GIMNASIO(55000),
    QUIROFANO(80000);

    private final int precio;

    Lugar(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}


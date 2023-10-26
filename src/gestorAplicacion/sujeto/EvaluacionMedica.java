package gestorAplicacion.sujeto;

public abstract class EvaluacionMedica {
	
	//Atributos
	protected String nombre;
    protected int cantidad;
    protected Especialidad especialidad;
    
    
    //Constructor
    protected EvaluacionMedica(String nombre, int cantidad, Especialidad especialidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.especialidad = especialidad;
    }
    
    //Metodo en el que se implementara la ligadura dinamica
    public void modificarCantidad(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
    }

    // Getter y setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter para cantidad
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Getter y setter para especialidad
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
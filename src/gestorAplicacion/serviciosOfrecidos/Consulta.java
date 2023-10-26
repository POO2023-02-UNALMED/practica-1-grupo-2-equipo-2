/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.serviciosOfrecidos;
import java.util.ArrayList;
import gestorAplicacion.adminHospitalaria.Cita;
import gestorAplicacion.instalaciones.Lugar;
//Lo que me interesa de esta importacion es: Categoria, Especialidad y Paciente
import gestorAplicacion.sujeto.*;

public class Consulta extends Tratamiento{
	
	// Atributos
	static private long contador = 0; 
	private final long ID;
	protected Rutina rutina;
	protected ArrayList<Ejercicio>ejerciciosOrdenados;
	
	// Constante específica para la clase Consulta
    public static final double PRECIO_BASE_CONSULTA = 600000;
    
    /* Este constructor se ejecuta cuando la cantidad de consultas necesarias para 
     * el tratamiento es solo una, devolviendo ese valor 1 en cantidad */
    public Consulta(Especialidad especialidad, Enfermedad enfermedad, Cita cita) {
    	super(1, especialidad, enfermedad, cita);
		Consulta.contador++;
    	this.ID = Consulta.contador; 
	}

	
    /*Calcula el precio de la consulta para un paciente dado.
     * Este método es una implementación de un método abstracto heredado de la clase Tratamiento.
     * @param paciente El paciente para el cual se calcula el precio.
     * @return El costo total de la consulta.*/
	@Override
    public double calcularPrecio(Paciente paciente) {
        // Obtén la categoría del paciente
        Categoria categoria = paciente.getCategoria();
        // Lugar fijo de la consulta
        Lugar lugar = Lugar.CONSULTORIO;
        // Calcula el costo base del tratamiento
        double costoBase = PRECIO_BASE_CONSULTA;
        // Calcula el costo total teniendo en cuenta la categoría, el lugar y el costo base
        double costoTotal = (costoBase + lugar.getPrecio()) * categoria.getCostoFactor();
        return costoTotal;
    }
	
    /*Convierte la información de la consulta en una cadena de texto.
     * Este método es una implementación de un método abstracto heredado de la clase Tratamiento.
     * @return Una cadena de texto que representa la información de la consulta.*/
	@Override
	public String toString() {
	    return  "* Consulta con el médico: " + this.getCita().getMedico().getNombre() + "\n" +
	    		"* Especialidad: " + this.getCita().getMedico().getEspecialidad() + "\n" +
	            "* Enfermedad: " + this.getEnfermedad().getNombre() + "\n" +
	            "* Fecha: " + this.getCita().getFecha() + "\n" +
	            "* Precio: " + this.calcularPrecio(this.getCita().getPaciente()) + "\n";
	}

	
	//Getters y setters
	public Cita getCita() {
		return super.cita;
	}
	public void setCita(Cita cita) {
		super.cita = cita;
	}
	
	public Long getID() {
		return ID;
	}
	
	public void setRutina(TipoTerapia tipoTerapia, TipoObjetivo tipoObjetivo) { 
		this.rutina = new Rutina(this.getPaciente(), tipoTerapia, tipoObjetivo); 
		
	}
	
	public Rutina getRutina() {
		return rutina;
	}
	
	public Medico getMedico() {
		return super.cita.getMedico();
	}
	
	public Paciente getPaciente() {
		return super.cita.getPaciente();
	}
	
	public ArrayList<Ejercicio>ejerciciosOrdenados(){
		return ejerciciosOrdenados;
	}
	
	public void actualizarEjerciciosOrdenados() {
		this.ejerciciosOrdenados = this.rutina.getEjerciciosOrdenados();
	}
}

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
	
	static private long contador = 0; 
	private final long ID;
	protected Rutina rutina;
	protected ArrayList<Ejercicio>ejerciciosOrdenados;
	
	// Constante específica para la clase Consulta
    public static final double PRECIO_BASE_CONSULTA = 600000;
    
    /* Este constructor se ejecuta cuando la cantidad de consultas necesarias para 
     * el tratamiento es solo una, devolviendo ese valor 1 en cantidad */
    public Consulta(String nombre, Especialidad especialidad, Enfermedad enfermedad, Cita cita) {
    	this(nombre, 1, especialidad, enfermedad, cita);
	}

    /* Este constructor se ejecuta cuando el medico necesita especificar la cantidad
     * de consultas necesarias para un tratamiento*/
	public Consulta(String nombre, int cantidad, Especialidad especialidad, Enfermedad enfermedad, Cita cita) {
		super(nombre, cantidad, especialidad, enfermedad, cita);
		Consulta.contador++;
    	this.ID = Consulta.contador; 
	}
	
	
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
	
	@Override
	public String toString() {
	    return  "* Consulta con el médico: " + this.getCita().getMedico().getNombre() + "\n" +
	            "* Especialidad: " + this.getCita().getMedico().obtenerEspecialidad() + "\n" +
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

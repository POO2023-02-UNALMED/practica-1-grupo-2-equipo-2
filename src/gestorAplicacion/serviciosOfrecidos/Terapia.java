/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.serviciosOfrecidos;
import java.util.ArrayList;
import gestorAplicacion.adminHospitalaria.*;
import gestorAplicacion.instalaciones.Lugar;
//Lo que me interesa de esta importacion es: Categoria, Especialidad, Paciente y Enfermedad
import gestorAplicacion.sujeto.*;

public class Terapia extends Consulta{
	
	// Constante específica para la clase Terapia
	public static final double PRECIO_BASE_TERAPIA = 2000000;
	
	//Atributos 
	int duracion;
	int intensidad;
	 
    /* Este constructor se ejecuta cuando la cantidad de citas de terapia necesarias para 
     * el tratamiento es solo una, devolviendo ese valor 1 en cantidad */
	public Terapia(String nombre, Especialidad especialidad, Enfermedad enfermedad, Cita cita, int duracion, int intensidad) {
		this(nombre, 1, especialidad, enfermedad, cita, duracion, intensidad);
	}
	/* Este constructor se ejecuta cuando el medico necesita especificar la cantidad
     * de consultas necesarias para un tratamiento*/
	// Constructor específico para Terapia
	 public Terapia(String nombre, int cantidad, Especialidad especialidad, Enfermedad enfermedad, Cita cita, int duracion, int intensidad) {
	        super(nombre, cantidad, especialidad, enfermedad, cita); 
	        this.duracion = duracion;
	        this.intensidad = intensidad;
	    }
    
    
    /*Calcula el precio de la terapia para un paciente dado.
     * Este método es una implementación de un método abstracto heredado de la clase Tratamiento.
     * @param paciente El paciente para el cual se calcula el precio.
     * @return El costo total de la terapia.*/
    @Override
    public double calcularPrecio(Paciente paciente) {
        // Obtén la categoría del paciente
        Categoria categoria = paciente.getCategoria();
        // Lugar fijo de la terapia
        Lugar lugar = Lugar.GIMNASIO;
        // Calcula el costo base del tratamiento
        double costoBase = PRECIO_BASE_TERAPIA;
        // Calcula el costo total teniendo en cuenta la categoría, el lugar y el costo base
        double costoTotal = (costoBase + lugar.getPrecio()) * categoria.getCostoFactor();
        return costoTotal;
    }
    
    /*Convierte la información de la terapia en una cadena de texto.
     * Este método es una implementación de un método abstracto heredado de la clase Tratamiento.
     * @return Una cadena de texto que representa la información de la terapia.*/
    @Override
    public String toString() {
        return  "* Terapia con el médico: " + this.getCita().getMedico().getNombre() + "\n" +
        		"* Nombre del tratamiento: " + this.getNombre() +  "\n" +
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
  		return super.getID();
  	}
  	
  	public Medico getMedico() {
  		return super.cita.getMedico();
  	}
  	
  	public Paciente getPaciente() {
  		return super.cita.getPaciente();
  	}
  	
  	public int getDuracion() {
  		return duracion;
  	}
  	
  	public void setDuracion(int duracion) {
  		this.duracion = duracion;
  	}
  	
  	public int getIntensidad() {
  		return intensidad;
  	}
  	
  	public void setIntensidad(int intensidad) {
  		this.intensidad = intensidad;
  	}
  	
}

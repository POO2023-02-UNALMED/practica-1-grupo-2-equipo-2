/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.serviciosOfrecidos;

import gestorAplicacion.adminHospitalaria.Cita;
import gestorAplicacion.instalaciones.Lugar;
import gestorAplicacion.sujeto.*;

//Descripción: Esta clase se encarga ...
public abstract class Tratamiento extends EvaluacionMedica{
	
	//Atributos
	protected Lugar lugar;
	protected Enfermedad enfermedad;
	protected boolean pagada;
	protected Cita cita;
	
	//Constructor
	protected Tratamiento(String nombre, int cantidad, Especialidad especialidad, Enfermedad enfermedad, Cita cita) {
        super(nombre, cantidad, especialidad);
        this.enfermedad = enfermedad;
        this.pagada = false; // Inicializa como no pagada
        this.cita = cita;
    }

	public abstract double calcularPrecio(Paciente paciente);
	
	public void marcarComoPagada() {
        pagada = true;
    }
	
	public abstract String toString();
	
	//Getters y setters de pagada
	public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
	
	// Getter para enfermedad
    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    // Setter para enfermedad
    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }
	
}

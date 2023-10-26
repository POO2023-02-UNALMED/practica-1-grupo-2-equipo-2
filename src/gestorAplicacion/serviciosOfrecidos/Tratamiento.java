/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.serviciosOfrecidos;

import gestorAplicacion.adminHospitalaria.Cita;
import gestorAplicacion.instalaciones.Lugar;
import gestorAplicacion.sujeto.*;

// Descripción: Esta clase abstracta representa un tratamiento médico que hereda de EvaluacionMedica.
public abstract class Tratamiento extends EvaluacionMedica{
	
	// Atributos
	protected Lugar lugar;
	protected Enfermedad enfermedad;
	protected boolean pagada;
	protected Cita cita;
	
	// Constructor
	protected Tratamiento(int cantidad, Especialidad especialidad, Enfermedad enfermedad, Cita cita) {
        super(null, cantidad, especialidad);
        this.enfermedad = enfermedad;
        this.pagada = false; // Inicializa como no pagada
        this.cita = cita;
    }

	// Método abstracto para calcular el precio del tratamiento para un paciente.
    public abstract double calcularPrecio(Paciente paciente);

    // Método abstracto para representar el tratamiento como cadena de texto.
    public abstract String toString();

    // Marcar el tratamiento como pagado.
    public void marcarComoPagada() {
        pagada = true;
    }
	
	//Getters y setters
	public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
	
    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }
	
}

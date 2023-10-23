/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.adminHospitalaria;

import gestorAplicacion.sujeto.Medico;
import gestorAplicacion.sujeto.Paciente;

public class Cita{

	// Atributos
	private Medico medico;
	private String fecha;
	private Paciente paciente;

	public Cita (Medico medico, String fecha, Paciente paciente){
		this.medico = medico;
		this.fecha = fecha;
		this.paciente = paciente;
	}
   
	// -------------------------------------------------------------- // 

	// Getter y Setter para el atributo 'medico'
	public Medico getMedico() {
	    return medico;
	}

	public void setMedico(Medico medico) {
	    this.medico = medico;
	}

	// Getter y Setter para el atributo 'fecha'
	public String getFecha() {
	    return fecha;
	}

	public void setFecha(String fecha) {
	    this.fecha = fecha;
	}

	// Getter y Setter para el atributo 'paciente'
	public Paciente getPaciente() {
	    return paciente;
	}

	public void setPaciente(Paciente paciente) {
	    this.paciente = paciente;
	}
}

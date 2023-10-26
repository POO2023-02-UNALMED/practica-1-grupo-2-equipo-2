/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.adminHospitalaria;

import gestorAplicacion.sujeto.*;
import gestorAplicacion.serviciosOfrecidos.*;
import gestorAplicacion.instalaciones.*;


public class Cita{

	// Atributos
	private static int contador = 0;
	private final int referencia;
	private Medico medico;
	private Fecha fecha;
	private Paciente paciente;
	private Tipo tipo;
	private Especialidad especialidad;
	private Categoria categoria;
	

	public Cita (Medico medico, Fecha fecha, Paciente paciente, Tipo tipo, Especialidad especialidad, Categoria categoria){
		this.medico = medico;
		this.fecha = fecha;
		this.paciente = paciente;
		this.tipo = tipo;
		this.especialidad = especialidad;
		this.categoria = categoria;
		
		this.referencia = contador;
		contador++;
	}
   
	// -------------------------------------------------------------- // 
	
	public boolean revisarDisponibilidadMedico(Fecha fecha, Medico medico) {
		for (Cita cita: medico.getAgenda()) {
			if (!cita.getFecha().comparar(fecha)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean revisarDisponibilidadHabitacion(Fecha fecha, Habitacion habitacion) {
		for (Cita cita: medico.getAgenda()) {
			if (!cita.getFecha().comparar(fecha)) {
				return false;
			}
		}
		return true;
	}

	// Getter y Setter para el atributo 'medico'
	public Medico getMedico() {
	    return medico;
	}

	public void setMedico(Medico medico) {
	    this.medico = medico;
	}

	// Getter y Setter para el atributo 'fecha'
	public Fecha getFecha() {
	    return fecha;
	}

	public void setFecha(Fecha fecha) {
	    this.fecha = fecha;
	}

	// Getter y Setter para el atributo 'paciente'
	public Paciente getPaciente() {
	    return paciente;
	}

	public void setPaciente(Paciente paciente) {
	    this.paciente = paciente;
	}

	private int getReferencia() {
		return referencia;
	}
	
}

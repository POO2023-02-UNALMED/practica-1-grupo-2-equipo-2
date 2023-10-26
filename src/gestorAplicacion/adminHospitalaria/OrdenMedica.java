/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.adminHospitalaria;

import java.util.ArrayList;
import gestorAplicacion.sujeto.*;
import gestorAplicacion.serviciosOfrecidos.*;
import gestorAplicacion.instalaciones.*;

//Descripción: Esta clase se encarga ...
public class OrdenMedica {

//Atributos
	private Paciente paciente;
	private Enfermedad enfermedad;
	private int registro;
	private Medico medico;
	private Tratamiento tratamientos;
	private String recomendaciones;
	

//Metodos
	

	public OrdenMedica(Paciente paciente,Enfermedad enfermedad, Medico medico,String recomendaciones) {
		this.paciente=paciente;
		this.enfermedad = enfermedad;
		this.medico = medico;
		this.tratamientos = tratamientos;
		this.recomendaciones = recomendaciones;
	}
	
	
	public int getRegistro() {
		return registro;
	}


	public void setRegistro(int registro) {
		this.registro = registro;
	}


	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Enfermedad getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Tratamiento getTratamientos() {
		return tratamientos;
	}
	public void setTratamientos(Tratamiento tratamientos) {
		this.tratamientos = tratamientos;
	}
	public String getRecomendaciones() {
		return recomendaciones;
	}
	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
		
	}



//Setters y getters

}

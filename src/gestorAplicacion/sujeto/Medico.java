/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.sujeto;

import java.util.ArrayList;
import gestorAplicacion.adminHospitalaria.Cita;

public class Medico extends Persona{
	private Especialidad especialidad;
	private ArrayList <Cita> agenda;
	
	// Constructor de la clase Medico sin sexo, peso y talla
    public Medico(Categoria categoria, int numeroIdentificacion, String nombre, Especialidad especialidad) {
        super(categoria, numeroIdentificacion, nombre);
        this.especialidad = especialidad;
        this.agenda = new ArrayList<>();
    }
	
	// Sobrescribir el método toString en la clase Médico
    @Override
    public String toString() {
        return "Médico:\n" +
               super.toString() + "\n" + // Llama al toString de la clase base
               "Especialidad: " + especialidad;
    }
    
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    public Especialidad getEspecialidad() {
        return especialidad;
    }
    //Metodos para definir la agenda
    public ArrayList<Cita> getAgenda() {
        return agenda;
    }
    
    public void setAgenda(ArrayList<Cita> agenda) {
        this.agenda = agenda;
    }
    //metodo para agregar las citas en la agenda
    public void agregarCita(Cita cita) {
        agenda.add(cita);
    }
    
}

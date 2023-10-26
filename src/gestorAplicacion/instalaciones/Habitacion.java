/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.instalaciones;

import java.util.ArrayList;

import gestorAplicacion.adminHospitalaria.Cita;
import gestorAplicacion.sujeto.Paciente;

/*Descripción: Esta clase se encarga de definir el elemento habitacion que los pacientes tienen.*/
public class Habitacion {
    private static long contador = 0;
    public final long ID;
    private boolean occupada;
    private ArrayList <Cita> agenda;
    private Paciente paciente;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    
    public Habitacion () {
    	this.ID = contador;
    	contador++;
    }
    
    //getters t setters

    public boolean isOccupada() {
        return this.occupada;
    }

    public void setOccupada(boolean occupada) {
        this.occupada = occupada;
    }
    
    public Paciente getPaciente () {
    	return this.paciente;
    }
    
    public long getId() {
    	return this.ID;
    }
    
    public void setPaciente(Paciente paciente) {
    	this.paciente = paciente;
    }
    
    // funcion que hace el enlace entre un paciente y un habitiacion
    public void reservarHabitacion(Paciente p){
        if(this.occupada == false){
            this.occupada = true;
            this.paciente = p;
            p.setHabitacionAsignada(this);
            // System.out.println("El paciente " + p.getNombre() + " fue anado en la habitacion n° : " + p.getHabitacionAsignada().getId());
        }
        // else
        //     System.out.println("La habitacion " + this.id + " esta occupada");

    }

    // funcion que deshace el enlace entre un paciente y un habitacion
    public void dejarHabitacion(){
        if (this.occupada){
            this.occupada = false;
            this.paciente.setHabitacionAsignada(null);
            this.paciente = null;
            //System.out.print("Room " + this.id + " has been freed (pero en espanol)\n");
        }
        // else
        //     System.out.println("La habitacion " + this.id + " esta libre todavia");
    }

    // function graphica usada en la clase Screen
    public String printOcupada(){
        if (this.isOccupada())
            return ANSI_RED + "Ocupada :" + ANSI_RESET;
        return ANSI_GREEN   + " Libre " + ANSI_RESET;
    }

}

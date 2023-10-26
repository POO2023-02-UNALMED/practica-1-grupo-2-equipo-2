/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.adminHospitalaria;

import java.util.ArrayList;
import gestorAplicacion.sujeto.*;
import gestorAplicacion.serviciosOfrecidos.*;

//Descripción: Esta clase se encarga 
public class HistoriaClinica {

//Atributos
	
	private final Paciente PACIENTE;
	private ArrayList <Enfermedad> historialEnfermedades;
	private ArrayList <OrdenMedica> historialOrdenes;
	private ArrayList <Terapia> historialTerapias;
	private ArrayList <Cirugia> historialCirugias;
	private ArrayList <Consulta> historialConsultas;
	private ArrayList <Rutina> historialRutinas;
	
//Constructor
	public HistoriaClinica(Paciente paciente) {
		this.PACIENTE = paciente;
		this.historialEnfermedades = new ArrayList<>();
        this.historialOrdenes = new ArrayList<>();
        this.historialTerapias = new ArrayList<>();
        this.historialCirugias = new ArrayList<>();
        this.historialConsultas = new ArrayList<>();
        this.setHistorialRutinas(new ArrayList<>());
    }

	// Getter para PACIENTE
    public Paciente getPACIENTE() {
        return PACIENTE;
    }

    // Getters y setters para historialEnfermedades
    public ArrayList<Enfermedad> getHistorialEnfermedades() {
        return historialEnfermedades;
    }

    public void setHistorialEnfermedades(ArrayList<Enfermedad> historialEnfermedades) {
        this.historialEnfermedades = historialEnfermedades;
    }

    // Getters y setters para historialOrdenes
    public ArrayList<OrdenMedica> getHistorialOrdenes() {
        return historialOrdenes;
    }

    public void setHistorialOrdenes(ArrayList<OrdenMedica> historialOrdenes) {
        this.historialOrdenes = historialOrdenes;
    }

    // Getters y setters para historialTerapias
    public ArrayList<Terapia> getHistorialTerapias() {
        return historialTerapias;
    }

    public void setHistorialTerapias(ArrayList<Terapia> historialTerapias) {
        this.historialTerapias = historialTerapias;
    }

    // Getters y setters para historialCirugias
    public ArrayList<Cirugia> getHistorialCirugias() {
        return historialCirugias;
    }

    public void setHistorialCirugias(ArrayList<Cirugia> historialCirugias) {
        this.historialCirugias = historialCirugias;
    }

    // Getters y setters para historialConsultas
    public ArrayList<Consulta> getHistorialConsultas() {
        return historialConsultas;
    }

    public void setHistorialConsultas(ArrayList<Consulta> historialConsultas) {
        this.historialConsultas = historialConsultas;
    }

	public ArrayList <Rutina> getHistorialRutinas() {
		return historialRutinas;
	}

	public void setHistorialRutinas(ArrayList <Rutina> historialRutinas) {
		this.historialRutinas = historialRutinas;
	}
	
	public void actualizarHistorialRutinas(Rutina rutina) {
		this.historialRutinas.add(rutina);
	}
}

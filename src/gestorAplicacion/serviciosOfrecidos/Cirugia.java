/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.serviciosOfrecidos;

import java.util.ArrayList;

import gestorAplicacion.adminHospitalaria.Cita;
import gestorAplicacion.instalaciones.Lugar;
//Lo que me interesa de esta importacion es: Categoria, Especialidad, Paciente y Enfermedad
import gestorAplicacion.sujeto.*;

//Descripción: Esta clase se encarga ...
public class Cirugia extends Consulta{
	
	
	// Constante específica para la clase Cirugia
	public static final double PRECIO_BASE_CIRUGIA = 1000000;
	private boolean resultadoLaboratorio;
	private boolean resultadoAnestesia;
	private String instruccionesEspeciales;
	
	// Constructor específico para Cirugia
    public Cirugia(Especialidad especialidad, Enfermedad enfermedad, Cita cita) {
        super(especialidad, enfermedad, cita); 
    }
    
    /*Calcula el precio de la cirugía para un paciente dado.
     * Este método es una implementación de un método abstracto heredado de la clase Tratamiento.
     * @param paciente El paciente para el cual se calcula el precio.
     * @return El costo total de la cirugía.*/
    @Override
    public double calcularPrecio(Paciente paciente) {
        // Obtén la categoría del paciente
        Categoria categoria = paciente.getCategoria();
        // Lugar fijo de la cirugia
        Lugar lugar = Lugar.QUIROFANO;
        // Calcula el costo base del tratamiento
        double costoBase = PRECIO_BASE_CIRUGIA;
        // Calcula el costo total teniendo en cuenta la categoría, el lugar y el costo base
        double costoTotal = (costoBase + lugar.getPrecio()) * categoria.getCostoFactor();
        return costoTotal;
    }
    
    /*Convierte la información de la cirugía en una cadena de texto.
     * Este método es una implementación de un método abstracto heredado de la clase Tratamiento.
     * @return Una cadena de texto que representa la información de la cirugía.*/
    @Override
    public String toString() {
        return  "* Cirugia con el médico: " + this.getCita().getMedico().getNombre() + "\n" +
                "* Especialidad: " + this.getCita().getMedico().getEspecialidad() + "\n" +
                "* Enfermedad: " + this.getEnfermedad().getNombre() + "\n" +
                "* Fecha: " + this.getCita().getFecha() + "\n" +
                "* Precio: " + this.calcularPrecio(this.getCita().getPaciente()) + "\n";
    }

    //Getters y Setters
    public boolean getResultadoLaboratorio() {
    	return resultadoLaboratorio;
    }
    
    public void setResultadoLaboratorio(boolean resultadoLaboratorio) {
    	this.resultadoLaboratorio = resultadoLaboratorio;
    }
    
    public boolean getResultadoAnestesia() {
    	return resultadoAnestesia;
    }
    
    public void setResultadoAnestesia(boolean resultadoAnestesia) {
    	this.resultadoAnestesia = resultadoAnestesia;	
    }
    
    public String getInstruccionesEspeciales() {
    	return instruccionesEspeciales;
    }
    
    public void setInstruccionesEspeciales(String instruccionesEspeciales) {
    	this.instruccionesEspeciales = instruccionesEspeciales;	
    }
}	

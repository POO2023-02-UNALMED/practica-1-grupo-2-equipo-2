/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.serviciosOfrecidos;
import gestorAplicacion.sujeto.*;
//Descripción: Esta clase se encarga ...

public class CaracteristicasEjercicio {
	private TipoTerapia tipoTerapia;
	private TipoObjetivo objetivo;
	private Restriccion restriccion; //Crear las restricciones en enfermedad
	
	
	//Constructor
	
	public CaracteristicasEjercicio(TipoTerapia tipoTerapia, TipoObjetivo objetivo, Restriccion restriccion) {
		this.tipoTerapia = tipoTerapia;
		this.objetivo = objetivo;
		this.restriccion = restriccion;
	}
	// Getters y setters para Tipo
	
	public TipoTerapia getTipoTerapia() {
		return tipoTerapia;
	}
	
	public void setTipoTerapia() {
		this.tipoTerapia = tipoTerapia;
	}
	
	// Getters y setters para TipoObjetivo
	public TipoObjetivo getTipoObjetivo() {
		return objetivo;
	}
	
	public void setTipoObjetivo() {
		this.objetivo = objetivo;
	}
	
	// Getters y setters para Restriccion
	public Restriccion getRestriccion() {
		return restriccion;
	}
	
	public void setRestriccion() {
		this.restriccion = restriccion;
	}
	

}

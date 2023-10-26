/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.sujeto;
import gestorAplicacion.instalaciones.Hospital;
import static uiMain.Screen.HOSPITAL;

public class Enfermedad extends EvaluacionMedica{
	
	//Atributos
	private static final Hospital HOSPITAL1 = HOSPITAL;
	private String tipologia;
	private String sintomas;
	private Restriccion restriccion;
	//Constructor
	public Enfermedad(String nombre, int cantidad, Especialidad especialidad, String tipologia, String sintomas) {
        this(nombre, cantidad, especialidad, tipologia, sintomas, null);
	}
	
	public Enfermedad(String nombre, int cantidad, Especialidad especialidad, String tipologia, String sintomas, Restriccion restriccion) {
        super(nombre, cantidad, especialidad);
        this.tipologia = tipologia;
        this.sintomas = sintomas;
        this.restriccion = restriccion;
        
        HOSPITAL1.addEnfermedad(this);
	}


     // Getters y setters para tipologia
	public String getTipologia() {
		return tipologia;
	}
	
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
     // Getters y setters para sintomas
	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	
	public Restriccion getRestriccion() {
		return restriccion;
	}

	public void setRestriccion(Restriccion restriccion) {
		this.restriccion = restriccion;
	}
}
